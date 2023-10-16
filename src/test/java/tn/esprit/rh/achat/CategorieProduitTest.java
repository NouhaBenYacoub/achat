package tn.esprit.rh.achat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tn.esprit.rh.achat.DTO.CategorieProduitDTO;
import tn.esprit.rh.achat.controllers.CategorieProduitController;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.exception.ResourceNotFoundException;
import tn.esprit.rh.achat.services.ICategorieProduitService;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class CategorieProduitTest {

    @Mock
    private ICategorieProduitService categorieProduitService;

    @InjectMocks
    private CategorieProduitController categorieProduitController;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCategorieProduit() {
        // Create a mock list of categorieProduits
        List<CategorieProduit> categorieProduits = Arrays.asList(
                new CategorieProduit(1L, "Category1", "Category1", null),
                new CategorieProduit(2L, "Category2", "Category2", null)
        );

        // Define the behavior of the categorieProduitService mock
        Mockito.when(categorieProduitService.retrieveAllCategorieProduits()).thenReturn(categorieProduits);

        List<CategorieProduit> result = categorieProduitController.getCategorieProduit();

        // Verify that the controller returned the expected result
        assert result != null;
        assert result.size() == 2;
    }

    @Test
    public void testRetrieveCategorieProduit() throws ResourceNotFoundException {
        Long categorieProduitId = 1L;
        CategorieProduit categorieProduit = new CategorieProduit(categorieProduitId, "Category1", "Category1", null);

        // Define the behavior of the categorieProduitService mock
        Mockito.when(categorieProduitService.retrieveCategorieProduit(categorieProduitId)).thenReturn(categorieProduit);

        CategorieProduit result = categorieProduitController.retrieveCategorieProduit(categorieProduitId);

        // Verify that the controller returned the expected result
        assert result != null;
        assert result.getIdCategorieProduit().equals(categorieProduitId);
    }

    @Test
    public void testAddCategorieProduit() {
//        CategorieProduitDTO categorieProduitDTO = new CategorieProduitDTO();
//        categorieProduitDTO.setLibelleCategorie("New Category");
//
//        CategorieProduit categorieProduitRequest = new CategorieProduit();
//        categorieProduitRequest.setLibelleCategorie("New Category");
//
//        // Define the behavior of the categorieProduitService mock
//        Mockito.when(categorieProduitService.saveCategorieProduit(categorieProduitRequest)).thenReturn(categorieProduitRequest);
//
//        CategorieProduitDTO result = categorieProduitController.addCategorieProduit(categorieProduitDTO);
//
//        // Verify that the controller returned the expected result
//        assert result != null;
//        assert result.getLibelleCategorie().equals(categorieProduitDTO.getLibelleCategorie());
    }

    @Test
    public void testRemoveCategorieProduit() {
        Long categorieProduitId = 1L;

        // Define the behavior of the categorieProduitService mock
        Mockito.doNothing().when(categorieProduitService).deleteCategorieProduit(categorieProduitId);

        // Verify that the controller successfully removes the category
        categorieProduitController.removeCategorieProduit(categorieProduitId);
    }
}

