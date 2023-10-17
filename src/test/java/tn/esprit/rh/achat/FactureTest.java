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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
//        // Mocking
//        ArrayList<Facture> factureList = new ArrayList<>();
//        when(factureRepository.findAll()).thenReturn(factureList);
//
//        // Test
//        List<Facture> result = factureService.retrieveAllFactures();
//
//        // Assertions
//        assertSame(factureList, result);
//        assertEquals(2, result.size());
//
//        // Vérification que la méthode findAll a été appelée
//        verify(factureRepository).findAll();

        ArrayList<Facture> produitList = new ArrayList<>();
        when(factureRepository.findAll()).thenReturn(produitList);
        List<Facture> actualRetrieveAllProduitsResult = factureService.retrieveAllFactures();
        assertSame(produitList, actualRetrieveAllProduitsResult);
        assertTrue(actualRetrieveAllProduitsResult.isEmpty());
        verify(factureRepository).findAll();
    }

//    @Test
//    void testAddFacture() {
//        // Mocking
//        Facture facture = new Facture();
//        when(factureRepository.save(any(Facture.class))).thenReturn(facture);
//
//        // Test
//        Facture result = factureService.addFacture(facture);
//
//        // Assertions
//        assertEquals(facture, result);
//
//        // Vérification que la méthode save a été appelée avec le bon argument
//        verify(factureRepository).save(facture);
//    }

//    @Test
//    void testAddDetailsFacture() {
//        // Mocking
//        Facture facture = new Facture();
//        when(factureRepository.save(any(Facture.class))).thenReturn(facture);
//
//        // Test
//        Facture result = factureService.addDetailsFacture(facture, detailsFacture);
//
//        // Assertions
//        assertNotNull(result);
//        // Add your specific assertions for the updated facture here
//
//        // Vérification que les méthodes nécessaires ont été appelées avec les bons arguments
//        verify(produitRepository, times(2)).findById(any(Long.class));
//        verify(detailFactureRepository, times(2)).save(any(DetailFacture.class));
//    }

    // Ajoutez les autres tests pour les méthodes restantes de FactureServiceImpl ici

}