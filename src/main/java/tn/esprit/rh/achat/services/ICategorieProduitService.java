package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.exception.ResourceNotFoundException;
import tn.esprit.rh.achat.entities.CategorieProduit;

import java.util.List;


public interface ICategorieProduitService {

	List<CategorieProduit> retrieveAllCategorieProduits();

	CategorieProduit saveCategorieProduit(CategorieProduit cp);

	void deleteCategorieProduit(Long id);


	CategorieProduit retrieveCategorieProduit(Long id) throws ResourceNotFoundException;

}
