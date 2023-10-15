package tn.esprit.rh.achat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith( SpringRunner.class)
@ContextConfiguration(classes = {StockServiceImpl.class})
public class FournisseurTest {

    private FournisseurServiceImpl service;
    private FournisseurRepository repository;
    @Test
    public void getFournisseurTest(){
        System.out.println(" get test fournisseur");
        long id = java.util.UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        long id2 = java.util.UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        long id3 = java.util.UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;

        repository = mock(FournisseurRepository.class);
        service = new FournisseurServiceImpl(repository);

        List<Fournisseur> fournisseurList = new ArrayList<>();
        fournisseurList.add(Fournisseur.builder().idFournisseur(id).code("JF5").libelle("Dell").build());
        fournisseurList.add(Fournisseur.builder().idFournisseur(id2).code("FT4").libelle("Topnet").build());
        fournisseurList.add(Fournisseur.builder().idFournisseur(id3).code("FT88").libelle("Asus").build());
        when(repository.findAll()).thenReturn(fournisseurList);

    }
}
