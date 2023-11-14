package tn.esprit.rh.achat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;
import tn.esprit.rh.achat.services.ReglementServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class RelgmntTest {
    @Autowired
    private ReglementServiceImpl reglementService;

    @Autowired
    private ReglementRepository reglementRepository;
    @Test
    void testRetrieveAllReglements() {
        // Créer une liste fictive de règlements
        List<Reglement> reglementList = new ArrayList<>();
        Reglement reglement1 = new Reglement();
        Reglement reglement2 = new Reglement();
        reglementList.add(reglement1);
        reglementList.add(reglement2);

        // Mock le comportement du repository pour retourner la liste fictive
        when(reglementRepository.findAll()).thenReturn(reglementList);

        // Appeler la méthode du service
        List<Reglement> result = reglementService.retrieveAllReglements();

        // Assertions
        assertEquals(2, result.size());
        assertTrue(result.contains(reglement1));
        assertTrue(result.contains(reglement2));
    }


}
