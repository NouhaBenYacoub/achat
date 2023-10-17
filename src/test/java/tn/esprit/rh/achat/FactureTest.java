package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.rh.achat.entities.*;
import tn.esprit.rh.achat.repositories.*;
import tn.esprit.rh.achat.services.FactureServiceImpl;
import tn.esprit.rh.achat.services.ReglementServiceImpl;
import java.util.Optional;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {FactureServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class FactureTest {

    @MockBean
    private FactureRepository factureRepository;
    @MockBean
    private OperateurRepository operateurRepository;
    @MockBean
    private DetailFactureRepository detailFactureRepository;
    @MockBean
    private FournisseurRepository fournisseurRepository;
    @MockBean
    private ProduitRepository produitRepository;
    @MockBean
    private ReglementServiceImpl reglementService;

    @Autowired
    private FactureServiceImpl factureService;

    @Test
    void testRetrieveAllFactures() {
        ArrayList<Facture> factures = new ArrayList<>();
        when(factureRepository.findAll()).thenReturn(factures);
        List<Facture> allFactures = factureService.retrieveAllFactures();
        assertSame(factures, allFactures);
        assertTrue(allFactures.isEmpty());
        verify(factureRepository).findAll();
    }

    @Test
    void testAddFacture() {
        Facture facture = new Facture();
        when(factureRepository.save(any(Facture.class))).thenReturn(facture);
        Facture result = factureService.addFacture(facture);
        assertEquals(facture, result);
        verify(factureRepository).save(facture);
    }

//    @Test
//    void testAddDetailsFacture() {
//        // Mocking
//        Facture facture = new Facture();
//        when(factureRepository.save(any(Facture.class))).thenReturn(facture);
//
//        Set<DetailFacture> DetailFacture = new HashSet<DetailFacture>();
//        // Test
//        Facture result = factureService.addDetailsFacture(facture, DetailFacture);
//
//        // Assertions
//        assertNotNull(result);
//        // Add your specific assertions for the updated facture here
//
//        // Vérification que les méthodes nécessaires ont été appelées avec les bons arguments
//        verify(produitRepository, times(2)).findById(any(Long.class));
//        verify(detailFactureRepository, times(2)).save(any(DetailFacture.class));
//    }

    @Test
    public void testRetrieveFacture() throws Exception {
        Long factureId = 1L;
        Facture facture = new Facture();
        when(factureRepository.findById(factureId)).thenReturn(Optional.of(facture));
        // Test
        Facture result = factureService.retrieveFacture(factureId);
        // Assertions
        assertEquals(facture, result);

        // Vérification que la méthode findById a été appelée avec le bon argument
        verify(factureRepository).findById(factureId);
    }

    @Test
    public void testCancelFacture() throws Exception {
        Long factureId = 1L;
        Facture facture = new Facture();
        when(factureRepository.findById(factureId)).thenReturn(Optional.of(facture));
        // Test
        factureService.cancelFacture(factureId);
        // Assertions
//        assertEquals(facture, result);

        // Vérification que la méthode findById a été appelée avec le bon argument
        verify(factureRepository).findById(factureId);

        assertTrue(facture.getArchivee());
    }

    @Test
    public void testGetFacturesByFournisseur() throws Exception {
        Long fournisseurId = 1L;
        Fournisseur fournisseur = new Fournisseur();

        // Mock the behavior of fournisseurRepository
        when(fournisseurRepository.findById(fournisseurId)).thenReturn(Optional.of(fournisseur));

        // Test
        List<Facture> result = factureService.getFacturesByFournisseur(fournisseurId);

        // Assertions
        assertFalse(result.isEmpty());

        // Verify that the findById method was called with the expected argument
        verify(fournisseurRepository).findById(fournisseurId);
    }

}