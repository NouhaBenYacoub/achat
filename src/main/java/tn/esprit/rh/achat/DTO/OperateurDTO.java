package tn.esprit.rh.achat.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import tn.esprit.rh.achat.entities.Facture;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;
@Data
public class OperateurDTO {

    private Long idOperateur;
    private String nom;
    private String prenom;

    private String password;
    private Set<Facture> factures;

}
