package tn.esprit.rh.achat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperateurTest {

    @Mock
    private OperateurRepository operateurRepository;

    private OperateurServiceImpl operateurService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        operateurService = new OperateurServiceImpl(operateurRepository);
    }

    @Test
    public void testAjouterOperateur() {
        Operateur operateur = new Operateur();
        operateur.setNom("John");
        operateur.setPrenom("Doe");

        Mockito.when(operateurRepository.save(operateur)).thenReturn(operateur);

        Operateur resultat = operateurService.addOperateur(operateur);

        Mockito.verify(operateurRepository, Mockito.times(1)).save(operateur);
        assertEquals("John", resultat.getNom());
        assertEquals("Doe", resultat.getPrenom());
    }
}
