package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OperateurTest{

    @MockBean
    private OperateurRepository operateurRepository;
    @MockBean
    private FactureRepository factureRepository;

    @Autowired
    private OperateurServiceImpl operateurService;

    @Test
    void testRetrieveAllOperateurs() {
        // mocking
        List<Operateur> operateurList = new ArrayList<>();
        // Définissez le comportement attendu lorsque la méthode findAll est appelée.
        when(operateurRepository.findAll()).thenReturn(operateurList);

        // Appelez la méthode du service.
        List<Operateur> result = operateurService.retrieveAllOperateurs();

        // Assurez-vous que la liste n'est pas nulle et qu'elle contient deux éléments.
        assertSame(operateurList, result);
        assertTrue(result.isEmpty());

        // Vérifiez si la méthode findAll du repository a été appelée une fois.
        verify(operateurRepository).findAll();
    }

   /* @Test
    void testRetrieveOperateur() {
        Long operateurId = 1L;

        // Créez un opérateur fictif pour simuler la réponse de votre repository.
        Operateur operateur = new Operateur("Operateur 1");

        // Définissez le comportement attendu lorsque la méthode findById est appelée.
        when(operateurRepository.findById(operateurId)).thenReturn(java.util.Optional.of(operateur));

        // Appelez la méthode du service pour récupérer un opérateur.
        Operateur result = operateurService.retrieveOperateur(operateurId);

        // Assurez-vous que l'opérateur récupéré n'est pas nul.
        assertSame(operateur, result);
        assertEquals("Operateur 1", result.getNom());



        // Vérifiez si la méthode findById du repository a été appelée une fois.
        verify(operateurRepository).findById(operateurId);
    }*/

    @Test
    void testDeleteOperateur() {
        doNothing().when(operateurRepository).deleteById((Long) any());

        // Exécutez la méthode delete du service.
        operateurService.deleteOperateur(1L);

        // Assurez-vous que la méthode deleteById a été appelée une fois avec l'ID spécifié.
        verify(operateurRepository).deleteById((Long) any());
    }

}