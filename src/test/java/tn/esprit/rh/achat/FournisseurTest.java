package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.*;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;

@ContextConfiguration(classes = {FournisseurServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class FournisseurTest {

    @InjectMocks
    private FournisseurServiceImpl fournisseurService;
    @MockBean
    private DetailFournisseurRepository detailFournisseurRepository;
    @MockBean
    private FactureRepository factureRepository;
    @MockBean
    private SecteurActiviteRepository secteurActiviteRepository;
    @MockBean
    private ProduitRepository produitRepository;
    @MockBean
    private FournisseurRepository fournisseurRepository;
    @Autowired
    private FournisseurServiceImpl fournisseurServiceImpl;

    @Test
    void testAddFournisseur() {
        Fournisseur fournisseur = new Fournisseur();
        when(fournisseurRepository.save(any(Fournisseur.class))).thenReturn(fournisseur);

        Fournisseur result = fournisseurServiceImpl.addFournisseur(fournisseur);

        assertEquals(fournisseur, result);
        verify(fournisseurRepository).save(fournisseur);
    }
    @Test
    public void getFournisseurTest() {
        System.out.println(" get test fournisseur");

        fournisseurRepository = Mockito.mock(FournisseurRepository.class);
        fournisseurServiceImpl = new FournisseurServiceImpl(fournisseurRepository);

        List<Fournisseur> fournisseurList = new ArrayList<>();
        fournisseurList.add(new Fournisseur(103L, "JF5", "Dell"));
        fournisseurList.add(new Fournisseur(148L, "FT2", "Topnet"));
        fournisseurList.add(new Fournisseur(136L, "OK8", "Asus"));
        when(fournisseurRepository.findAll()).thenReturn(fournisseurList);
    }
    @Test
    public void testGetFournisseur() {
        List<Fournisseur> fournisseurList = new ArrayList<>();
        when(fournisseurRepository.findAll()).thenReturn(fournisseurList);
        List<Fournisseur> actualRetrieveAllFournisseurResult = fournisseurServiceImpl.retrieveAllFournisseurs();

        assertSame(fournisseurList, actualRetrieveAllFournisseurResult);
        assertTrue(actualRetrieveAllFournisseurResult.isEmpty());
        verify(fournisseurRepository).findAll();
    }
 /*   @Test
    public void testUpdateFournisseur() {
        Fournisseur fournisseur = new Fournisseur();
        DetailFournisseur detailFournisseur = new DetailFournisseur();
        when(detailFournisseurRepository.save(detailFournisseur)).thenReturn(detailFournisseur);

        FournisseurServiceImpl fournisseurService = new FournisseurServiceImpl(fournisseurRepository);
        assertNotNull(fournisseur);
        Fournisseur result = fournisseurService.updateFournisseur(fournisseur);

        verify(fournisseurRepository).save(fournisseur);
    }*/
    @Test
    public void testDeleteFournisseur() {
        doNothing().when(fournisseurRepository).deleteById((Long) any());
        fournisseurServiceImpl.deleteFournisseur(103L);

        verify(fournisseurRepository).deleteById((Long) any());
    }
    @Test
    void testRetrieveFournisseur() {
        Long fournisseurId = 1L;
        Fournisseur mockFournisseur = new Fournisseur();
        when(fournisseurRepository.findById(fournisseurId)).thenReturn(Optional.of(mockFournisseur));

        Fournisseur result = fournisseurServiceImpl.retrieveFournisseur(fournisseurId);

        assertEquals(mockFournisseur, result);
        verify(fournisseurRepository).findById(fournisseurId);
    }
  /*  @Test
    public void testAssignSecteurActiviteToFournisseur() {
        Long idSecteurActivite = 1L;
        Long idFournisseur = 2L;

        Fournisseur fournisseur = new Fournisseur();
        SecteurActivite secteurActivite = new SecteurActivite();
        when(fournisseurRepository.findById(1L)).thenReturn(Optional.of(fournisseur));
        when(secteurActiviteRepository.findById(2L)).thenReturn(Optional.of(secteurActivite));

        fournisseurService.assignSecteurActiviteToFournisseur(idSecteurActivite, idFournisseur);

        verify(fournisseurRepository).save(fournisseur);
        assertEquals(1, fournisseur.getSecteurActivites().size());
    }*/
}
