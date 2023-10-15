package tn.esprit.rh.achat.entitiesdto;

import tn.esprit.rh.achat.entities.Facture;

import java.util.Date;

public class ReglementDTO {
    private Long idReglement;
    private float montantPaye;
    private float montantRestant;
    private Boolean payee;
    private Date dateReglement;
    private Facture facture;

}
