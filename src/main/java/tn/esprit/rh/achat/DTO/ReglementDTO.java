package tn.esprit.rh.achat.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import tn.esprit.rh.achat.entities.Facture;

import javax.persistence.*;
import java.util.Date;

public class ReglementDTO {
    private Long idReglement;
    private float montantPaye;
    private float montantRestant;
    private Boolean payee;
    private Date dateReglement;
    private Facture facture;

}
