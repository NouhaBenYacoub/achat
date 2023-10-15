package tn.esprit.rh.achat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class OperateurTest {
    @Mock
    private OperateurRepository operateurRepository;
    private OperateurServiceImpl operateurService;

    @BeforeEach
    public void setUp() {
        operateurService = new OperateurServiceImpl(operateurRepository);
    }

    @Test
    public void testAjouterOperateur() {
        Operateur operateur = new Operateur();
        operateur.setNom("John");
        operateur.setPrenom("Doe");

        when(operateurRepository.save(operateur)).thenReturn(operateur);

        Operateur resultat = operateurService.addOperateur(operateur);

        verify(operateurRepository, times(1)).save(operateur);
        assertEquals("John", resultat.getNom());
        assertEquals("Doe", resultat.getPrenom());
    }
}
