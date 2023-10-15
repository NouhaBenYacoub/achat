package tn.esprit.rh.achat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith( SpringRunner.class)
@ContextConfiguration(classes = {FournisseurServiceImpl.class})
public class FournisseurTest {

    @Autowired
    private FournisseurServiceImpl service;
    @MockBean
    private FournisseurRepository repository;

    @Test
    public void getFournisseurTest() {
        System.out.println(" get test fournisseur");

        repository = Mockito.mock(FournisseurRepository.class);
        service = new FournisseurServiceImpl(repository);

        List<Fournisseur> fournisseurList = new ArrayList<>();
        fournisseurList.add(new Fournisseur(123L, "JF5", "Dell"));
        fournisseurList.add(new Fournisseur(148L, "FT2", "Topnet"));
        fournisseurList.add(new Fournisseur(136L, "OK8", "Asus"));
        when(repository.findAll()).thenReturn(fournisseurList);

        List<Fournisseur> fournisseurs = service.retrieveAllFournisseurs();

        assertEquals(fournisseurList, fournisseurs);
        verify(repository).findAll();
    }
}
