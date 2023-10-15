package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.dto.FournisseurDTO;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.services.IFournisseurService;

import java.util.List;
import org.modelmapper.ModelMapper;

@RestController
@Api(tags = "Gestion des fournisseurss")
@RequestMapping("/fournisseur")
public class FournisseurRestController {

	@Autowired
	IFournisseurService fournisseurService;
	@Autowired
	private ModelMapper modelMapper;

	// http://localhost:8089/SpringMVC/fournisseur/retrieve-all-fournisseurs
	@GetMapping("/retrieve-all-fournisseurs")
	@ResponseBody
	public List<Fournisseur> getFournisseurs() {
		return fournisseurService.retrieveAllFournisseurs();

	}

	// http://localhost:8089/SpringMVC/fournisseur/retrieve-fournisseur/8
	@GetMapping("/retrieve-fournisseur/{fournisseur-id}")
	@ResponseBody
	public Fournisseur retrieveFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
		return fournisseurService.retrieveFournisseur(fournisseurId);
	}

	// http://localhost:8089/SpringMVC/fournisseur/add-fournisseur
	@PostMapping("/add-fournisseur")
	@ResponseBody
	public FournisseurDTO addFournisseur(@RequestBody FournisseurDTO fournisseurdto) {
		Fournisseur fournisseurRequest = modelMapper.map(fournisseurdto, Fournisseur.class);
		Fournisseur fournisseur = fournisseurService.addFournisseur(fournisseurRequest);

		// convert entity to DTO
		return modelMapper.map(fournisseur, FournisseurDTO.class);

	}


	@DeleteMapping("/remove-fournisseur/{fournisseur-id}")
	@ResponseBody
	public void removeFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
		fournisseurService.deleteFournisseur(fournisseurId);
	}

	// http://localhost:8089/SpringMVC/fournisseur/modify-fournisseur
	@PutMapping("/modify-fournisseur")
	@ResponseBody
	public FournisseurDTO modifyFournisseur(@RequestBody FournisseurDTO fournisseurdto) {
		Fournisseur fournisseurRequest = modelMapper.map(fournisseurdto, Fournisseur.class);
		Fournisseur fournisseur = fournisseurService.updateFournisseur(fournisseurRequest);

		// convert entity to DTO
		return modelMapper.map(fournisseur, FournisseurDTO.class);
	}

	// http://localhost:8089/SpringMVC/fournisseur/assignSecteurActiviteToFournisseur/1/5
	@PutMapping(value = "/assignSecteurActiviteToFournisseur/{idSecteurActivite}/{idFournisseur}")
	public void assignProduitToStock(@PathVariable("idSecteurActivite") Long idSecteurActivite, @PathVariable("idFournisseur") Long idFournisseur) {
		fournisseurService.assignSecteurActiviteToFournisseur(idSecteurActivite, idFournisseur);
	}

}
