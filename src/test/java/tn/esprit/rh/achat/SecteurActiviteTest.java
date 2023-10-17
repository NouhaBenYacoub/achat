package tn.esprit.rh.achat;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;
import tn.esprit.rh.achat.services.ReglementServiceImpl;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
@ContextConfiguration(classes = {SecteurActiviteServiceImpl.class})
@ExtendWith(SpringExtension.class)
class SecteurActiviteTest{

    @MockBean
    private SecteurActiviteRepository secteurActiviteRepository;

    @Autowired
    private SecteurActiviteServiceImpl secteurActiviteService;

    @Test
    void testRetrieveAllOperateurs() {
        // Mocking
        List<SecteurActivite> operateurList = new ArrayList<>();
        when(secteurActiviteRepository.findAll()).thenReturn(operateurList);

        // Test
        List<SecteurActivite> result = secteurActiviteService.retrieveAllSecteurActivite();

        // Assertions
        assertSame(operateurList, result);
        assertTrue(result.isEmpty());

        // Vérification que la méthode findAll a été appelée
        verify(secteurActiviteRepository).findAll();
    }

//    @Test
//    void testRetrieveOperateur() {
//        // Mocking
//        Long id = 1L;
//        Operateur mockOperateur = new Operateur();
//        when(operateurRepository.findById(id)).thenReturn(Optional.of(mockOperateur));
//
//        // Test
//        Operateur result = operateurService.retrieveOperateur(id);
//
//        // Assertions
//        assertEquals(mockOperateur, result);
//
//        // Vérification que la méthode findById a été appelée avec le bon argument
//        verify(operateurRepository).findById(id);
//    }
//
//    @Test
//    void testDeleteOperateur() {
//        doNothing().when(operateurRepository).deleteById((Long) any());
//
//        // Exécutez la méthode delete du service.
//        operateurService.deleteOperateur(1L);
//
//        // Assurez-vous que la méthode deleteById a été appelée une fois avec l'ID spécifié.
//        verify(operateurRepository).deleteById((Long) any());
//    }

}
