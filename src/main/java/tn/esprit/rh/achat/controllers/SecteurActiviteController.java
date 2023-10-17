package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.entitiesdto.Secteuractivitedto;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.services.ISecteurActiviteService;
import org.modelmapper.ModelMapper;

import java.util.List;

@RestController
@Api(tags = "Gestion des secteurs activites")
@RequestMapping("/secteurActivite")
@CrossOrigin("*")
public class SecteurActiviteController {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	ISecteurActiviteService secteurActiviteService;
	
	// http://localhost:8089/SpringMVC/secteurActivite/retrieve-all-secteurActivite
	@GetMapping("/retrieve-all-secteurActivite")
	@ResponseBody
	public List<SecteurActivite> getSecteurActivite() {
		return secteurActiviteService.retrieveAllSecteurActivite();

	}

	// http://localhost:8089/SpringMVC/secteurActivite/retrieve-secteurActivite/8
	@GetMapping("/retrieve-secteurActivite/{secteurActivite-id}")
	@ResponseBody
	public SecteurActivite retrieveSecteurActivite(@PathVariable("secteurActivite-id") Long secteurActiviteId) {
		return secteurActiviteService.retrieveSecteurActivite(secteurActiviteId);
	}

	// http://localhost:8089/SpringMVC/secteurActivite/add-secteurActivite
	@PostMapping("/add-secteurActivite")
	@ResponseBody
	public Secteuractivitedto addSecteurActivite(@RequestBody Secteuractivitedto secteurActivitedto) {

		SecteurActivite secteurActiviteRequest = modelMapper.map(secteurActivitedto, SecteurActivite.class);

		SecteurActivite secteurActivite =secteurActiviteService.addSecteurActivite(secteurActiviteRequest);

		// convert entity to DTO
		return   modelMapper.map(secteurActivite, Secteuractivitedto.class);

	}


	@DeleteMapping("/remove-secteurActivite/{secteurActivite-id}")
	@ResponseBody
	public void removeSecteurActivite(@PathVariable("secteurActivite-id") Long secteurActiviteId) {
		secteurActiviteService.deleteSecteurActivite(secteurActiviteId);
	}

	// http://localhost:8089/SpringMVC/secteurActivite/modify-secteurActivite
	@PutMapping("/modify-secteurActivite")
	@ResponseBody
	public Secteuractivitedto modifySecteurActivite(@RequestBody Secteuractivitedto secteurActivitedto) {

		SecteurActivite secteurActiviteRequest = modelMapper.map(secteurActivitedto, SecteurActivite.class);

		SecteurActivite secteurActivite = secteurActiviteService.updateSecteurActivite(secteurActiviteRequest);

		// convert entity to DTO
		 return   modelMapper.map(secteurActivite, Secteuractivitedto.class);}

	
}
