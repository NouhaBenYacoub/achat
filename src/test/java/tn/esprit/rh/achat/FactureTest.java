package tn.esprit.rh.achat;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tn.esprit.rh.achat.controllers.FactureRestController;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.repositories.ReglementRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;
import tn.esprit.rh.achat.services.IFactureService;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(classes = {FactureServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class FactureTest {

    private MockMvc mockMvc;

    @Autowired
    private FactureServiceImpl factureService;

    @Mock
    private ReglementRepository reglementRepository;

    @Mock
    private FournisseurRepository fournisseurRepository;

    @Mock
    private FactureRepository factureRepository;

    @Test
    public void testGetFactures() throws Exception {
        // Créer un exemple de liste de factures pour simuler la réponse du service
        List<Facture> factureList = new ArrayList<>();
        when(factureRepository.findAll()).thenReturn(factureList);

        // Test
        List<Facture> result = factureService.retrieveAllFactures();

        // Assertions
        assertSame(factureList, result);
        assertTrue(result.isEmpty());

        // Vérification que la méthode findAll a été appelée
        verify(reglementRepository).findAll();
    }

//    @Test
//    public void testRetrieveFacture() throws Exception {
//        Long factureId = 1L;
//        Facture facture = new Facture();
//        when(factureService.retrieveFacture(factureId)).thenReturn(facture);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/facture/retrieve-facture/{facture-id}", factureId)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").exists());
//    }
//
//    @Test
//    public void testAddFacture() throws Exception {
//        Facture facture = new Facture();
//        when(factureService.addFacture(any(Facture.class))).thenReturn(facture);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/facture/add-facture")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").exists());
//    }
//
//    @Test
//    public void testCancelFacture() throws Exception {
//        Long factureId = 1L;
//        doNothing().when(factureService).cancelFacture(factureId);
//
//        mockMvc.perform(MockMvcRequestBuilders.put("/facture/cancel-facture/{facture-id}", factureId)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
}