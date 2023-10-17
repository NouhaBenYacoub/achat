package tn.esprit.rh.achat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tn.esprit.rh.achat.DTO.CategorieProduitDTO;
import tn.esprit.rh.achat.controllers.CategorieProduitController;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.exception.ResourceNotFoundException;
import tn.esprit.rh.achat.services.ICategorieProduitService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class CategorieProduitTest {

    @Mock
    private ICategorieProduitService categorieProduitService;

    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private CategorieProduitController categorieProduitController;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCategorieProduit() {
        List<CategorieProduit> categorieProduits = Arrays.asList(
                new CategorieProduit(1L, "Category1", "Category1", null),
                new CategorieProduit(2L, "Category2", "Category2", null)
        );

        Mockito.when(categorieProduitService.retrieveAllCategorieProduits()).thenReturn(categorieProduits);

        List<CategorieProduit> result = categorieProduitController.getCategorieProduit();

        assert result != null;
        assert result.size() == 2;
    }

    @Test
    public void testRetrieveCategorieProduit() throws ResourceNotFoundException {
        Long categorieProduitId = 1L;
        CategorieProduit categorieProduit = new CategorieProduit(categorieProduitId, "Category1", "Category1", null);

        Mockito.when(categorieProduitService.retrieveCategorieProduit(categorieProduitId)).thenReturn(categorieProduit);

        CategorieProduit result = categorieProduitController.retrieveCategorieProduit(categorieProduitId);

        assert result != null;
        assert result.getIdCategorieProduit().equals(categorieProduitId);
    }

    @Test
    public void testAddCategorieProduit() {
        CategorieProduitDTO categorieProduitDTO = new CategorieProduitDTO();
        categorieProduitDTO.setLibelleCategorie("New Category");
        categorieProduitDTO.setCodeCategorie("123");
        categorieProduitDTO.setProduits(new HashSet<Produit>());
        categorieProduitDTO.setIdCategorieProduit(1L);

        CategorieProduit categorieProduitRequest = new CategorieProduit();
        categorieProduitRequest.setIdCategorieProduit(1L);
        categorieProduitRequest.setLibelleCategorie("New Category");
        categorieProduitRequest.setCodeCategorie("123");
        categorieProduitRequest.setProduits(new HashSet<Produit>());

        Mockito.when(modelMapper.map(Mockito.any(CategorieProduit.class), Mockito.any())).thenReturn(categorieProduitDTO);
        Mockito.when(modelMapper.map(Mockito.any(CategorieProduitDTO.class), Mockito.any())).thenReturn(categorieProduitRequest);

        Mockito.when(categorieProduitService.saveCategorieProduit(categorieProduitRequest)).thenReturn(categorieProduitRequest);

        CategorieProduitDTO result = categorieProduitController.addCategorieProduit(categorieProduitDTO);

        assert result != null;
        assert result.getLibelleCategorie().equals(categorieProduitDTO.getLibelleCategorie());
    }

    @Test
    public void testRemoveCategorieProduit() {
        Long categorieProduitId = 1L;

        Mockito.doNothing().when(categorieProduitService).deleteCategorieProduit(categorieProduitId);

        categorieProduitController.removeCategorieProduit(categorieProduitId);
    }
}

