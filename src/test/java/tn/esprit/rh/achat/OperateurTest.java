package tn.esprit.rh.achat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OperateurTest {

    @Mock
    private OperateurRepository operateurRepository;

    private OperateurServiceImpl operateurService;

    @BeforeEach
    void setUp() {
        operateurService = new OperateurServiceImpl(operateurRepository);
    }

    @Test
    void testRetrieveAllOperateurs() {
        // Create some sample data
        Operateur operateur1 = new Operateur(1L, "John", "Doe", "password");
        Operateur operateur2 = new Operateur(2L, "Alice", "Smith", "secret");
        List<Operateur> operateurList = new ArrayList<>();
        operateurList.add(operateur1);
        operateurList.add(operateur2);

        // Mock the behavior of operateurRepository.findAll()
        when(operateurRepository.findAll()).thenReturn(operateurList);

        // Call the method you want to test
        List<Operateur> actualOperateurs = operateurService.retrieveAllOperateurs();

        // Assertions
        assertEquals(2, actualOperateurs.size());
        assertEquals("John", actualOperateurs.get(0).getNom());
        assertEquals("Alice", actualOperateurs.get(1).getNom());
    }

    @Test
    void testGetIdOperateur() {
        // Create a sample Operateur
        Operateur operateur = new Operateur(1L, "John", "Doe", "password");

        // Mock the behavior of operateurRepository.findById()
        when(operateurRepository.findById(1L)).thenReturn(Optional.of(operateur));

        // Call the method you want to test
        Optional<Operateur> actualOperateur = operateurService.getById(1L);

        // Assertions
        assertEquals("John", actualOperateur.get().getNom());
        assertEquals("Doe", actualOperateur.get().getPrenom());
    }
}
