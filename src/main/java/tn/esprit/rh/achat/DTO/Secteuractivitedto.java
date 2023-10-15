package tn.esprit.rh.achat.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import tn.esprit.rh.achat.entities.Fournisseur;

import javax.persistence.ManyToMany;
import java.util.Set;
@Data
public class Secteuractivitedto {
    private Long idSecteurActivite;
    private String codeSecteurActivite;
    private String libelleSecteurActivite;

    private Set<Fournisseur> fournisseurs;

}
