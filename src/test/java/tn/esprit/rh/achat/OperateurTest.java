package tn.esprit.rh.achat;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith( SpringRunner.class)
@ContextConfiguration(classes = {OperateurServiceImpl.class})
public class OperateurTest {

    @Mock
    private OperateurRepository operateurRepository;
    //private OperateurServiceImpl operateurService;


   // @Test
    //public void getOperateurTest(){
      //  System.out.println(" get test operateur");
        //long id = java.util.UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        //long id2 = java.util.UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;

        //operateurRepository = mock(OperateurRepository.class);
        //operateurService = new OperateurServiceImpl(operateurRepository);

        //List<Operateur> operateurList = new ArrayList<>();
        //operateurList.add(new Operateur(id,"naziha","ksouri","azerty"));
        //when(operateurRepository.findAll()).thenReturn(operateurList);

    //}
    //@InjectMocks
    @Autowired
    private OperateurServiceImpl operateurService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getOperateurTest() {
        long id = java.util.UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        long id2 = java.util.UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;

        List<Operateur> operateurList = new ArrayList<>();
        operateurList.add(new Operateur(id, "naziha", "ksouri", "azerty"));

        when(operateurRepository.findAll()).thenReturn(operateurList);

        List<Operateur> resultat = operateurService.retrieveAllOperateurs();

        assertEquals(1, resultat.size());
        Operateur operateurRetourne = resultat.get(0);
        assertEquals("naziha", operateurRetourne.getNom());
        assertEquals("ksouri", operateurRetourne.getPrenom());
        assertEquals("azerty", operateurRetourne.getPassword());
    }

    @Test
    public void testTousLesOperateursExistants() {
        long id = java.util.UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        long id2 = java.util.UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;

        List<Operateur> operateurList = new ArrayList<>();
        operateurList.add(new Operateur(id, "naziha", "ksouri", "azerty"));
        operateurList.add(new Operateur(id2, "najwa", "joujou", "password2"));

        when(operateurRepository.findAll()).thenReturn(operateurList);

        List<Operateur> resultat = operateurService.retrieveAllOperateurs();

        assertEquals(2, resultat.size());

        // Vous pouvez également vérifier si tous les opérateurs existent
        assertTrue(resultat.containsAll(operateurList));
    }
}
