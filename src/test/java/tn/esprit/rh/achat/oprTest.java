package tn.esprit.rh.achat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
@SpringBootTest
@ActiveProfiles("test")
public class oprTest {
    @Autowired
    private OperateurServiceImpl operateurService;

    @Autowired
    private OperateurRepository operateurRepository;

    @Test
    void testRetrieveAllOperateurs() {
        // Créer une liste fictive d'opérateurs
        List<Operateur> operateurList = new ArrayList<>();
        Operateur operateur1 = new Operateur();
        Operateur operateur2 = new Operateur();
        operateurList.add(operateur1);
        operateurList.add(operateur2);
        // Stubbing pour simuler le comportement du repository
        when(operateurRepository.findAll()).thenReturn(operateurList);

        // Appeler la méthode du service
        List<Operateur> result = operateurService.retrieveAllOperateurs();

        // Assertions
        assertEquals(2, result.size());
        assertTrue(result.contains(operateur1));
        assertTrue(result.contains(operateur2));}
    @Test
    void testRetrieveOperateur() {
        // Créer un opérateur fictif
        Long id = 1L;
        Operateur mockOperateur = new Operateur();

        // Stubbing pour simuler le comportement du repository
        when(operateurRepository.findById(id)).thenReturn(Optional.of(mockOperateur));

        // Appeler la méthode du service
        Operateur result = operateurService.retrieveOperateur(id);

        // Assertions
        assertEquals(mockOperateur, result);
    }
}
