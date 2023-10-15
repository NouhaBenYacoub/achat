package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.DTO.CategorieProduitDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.services.ICategorieProduitService;
import org.modelmapper.ModelMapper;

import java.util.List;

@RestController
@Api(tags = "Gestion des categories Produit")

@RequestMapping("/categorieProduit")
public class CategorieProduitController {

	@Autowired
	ICategorieProduitService categorieProduitService;
	@Autowired
	private ModelMapper modelMapper;
	
	// http://localhost:8089/SpringMVC/categorieProduit/retrieve-all-categorieProduit
	@GetMapping("/retrieve-all-categorieProduit")
	@ResponseBody
	public List<CategorieProduit> getCategorieProduit() {
		return categorieProduitService.retrieveAllCategorieProduits();

	}

	// http://localhost:8089/SpringMVC/categorieProduit/retrieve-categorieProduit/8
	@GetMapping("/retrieve-categorieProduit/{categorieProduit-id}")
	@ResponseBody
	public CategorieProduit retrieveCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
		return categorieProduitService.retrieveCategorieProduit(categorieProduitId);
	}

	// http://localhost:8089/SpringMVC/categorieProduit/add-categorieProduit
	@PostMapping("/add-categorieProduit")
	@ResponseBody
	public CategorieProduitDTO addCategorieProduit(@RequestBody CategorieProduitDTO categorieProduitDTO) {
		CategorieProduit categorieProduitRequest = modelMapper.map(categorieProduitDTO, CategorieProduit.class);

		CategorieProduit categorieProduit = categorieProduitService.addCategorieProduit(categorieProduitRequest);

		return modelMapper.map(categorieProduit, CategorieProduitDTO.class);
	}


	@DeleteMapping("/remove-categorieProduit/{categorieProduit-id}")
	@ResponseBody
	public void removeCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
		categorieProduitService.deleteCategorieProduit(categorieProduitId);
	}

	// http://localhost:8089/SpringMVC/categorieProduit/modify-categorieProduit
	@PutMapping("/modify-categorieProduit")
	@ResponseBody
	public CategorieProduitDTO modifyCategorieProduit(@RequestBody CategorieProduitDTO categorieProduitDTO) {
		CategorieProduit categorieProduitRequest = modelMapper.map(categorieProduitDTO, CategorieProduit.class);

		CategorieProduit categorieProduit = categorieProduitService.updateCategorieProduit(categorieProduitRequest);

		return modelMapper.map(categorieProduit, CategorieProduitDTO.class);

	}

	
}
