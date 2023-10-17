package tn.esprit.rh.achat.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import tn.esprit.rh.achat.entities.DetailFacture;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.Reglement;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
public class FactureDTO{

    private Long idFacture;
    private float montantRemise;
    private float montantFacture;
    private Date dateCreationFacture;
    private Date dateDerniereModificationFacture;
    private Boolean archivee;
    private Set<DetailFacture> detailsFacture;
    private Fournisseur fournisseur;
    private Set<Reglement> reglements;
}
