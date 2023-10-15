package tn.esprit.rh.achat;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {FournisseurServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class FournisseurTest {

    @MockBean
    private FournisseurRepository fournisseurRepository;
    @Autowired
    private FournisseurServiceImpl fournisseurServiceImpl;

 /*   @Test
    public void getFournisseurTest() {
        System.out.println(" get test fournisseur");

        repository = Mockito.mock(FournisseurRepository.class);
        fournisseurServiceImpl = new FournisseurServiceImpl(repository);

        List<Fournisseur> fournisseurList = new ArrayList<>();
        fournisseurList.add(new Fournisseur(123L, "JF5", "Dell"));
        fournisseurList.add(new Fournisseur(148L, "FT2", "Topnet"));
        fournisseurList.add(new Fournisseur(136L, "OK8", "Asus"));
        when(repository.findAll()).thenReturn(fournisseurList);
    }*/

    @Test
    public void getFournisseurTest() {
        List<Fournisseur> fournisseurList = new ArrayList<>();
        when(fournisseurRepository.findAll()).thenReturn(fournisseurList);
        List<Fournisseur> actualRetrieveAllFournisseurResult = fournisseurServiceImpl.retrieveAllFournisseurs();

        assertSame(fournisseurList, actualRetrieveAllFournisseurResult);
        assertTrue(actualRetrieveAllFournisseurResult.isEmpty());
        verify(fournisseurRepository).findAll();
    }

    @Test
    public void testDeleteFournisseur() {
        doNothing().when(fournisseurRepository).deleteById((Long) any());
        fournisseurServiceImpl.deleteFournisseur(123L);
        verify(fournisseurRepository).deleteById((Long) any());
    }
}
