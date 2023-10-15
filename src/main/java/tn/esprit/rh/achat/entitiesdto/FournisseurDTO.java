package tn.esprit.rh.achat.entitiesdto;

import lombok.Data;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.SecteurActivite;
import java.io.Serializable;

import java.util.Set;
@Data

public class FournisseurDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idFournisseur;
    private String code;
    private String libelle;
    private CategorieFournisseur categorieFournisseur;
    private Set<Facture> factures;
    private Set<SecteurActivite> secteurActivites;
    private DetailFournisseur detailFournisseur;

}

