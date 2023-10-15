package tn.esprit.rh.achat.controllers;


import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.DTO.CategorieProduitDTO;
import tn.esprit.rh.achat.DTO.StockDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;

import java.util.List;

@RestController
@Api(tags = "Gestion des stocks")
@RequestMapping("/stock")
@CrossOrigin("*")
public class StockRestController {

	@Autowired
	IStockService stockService;
	@Autowired
	private ModelMapper modelMapper;

	// http://localhost:8089/SpringMVC/stock/retrieve-all-stocks
	@GetMapping("/retrieve-all-stocks")
	@ResponseBody
	public List<Stock> getStocks() {
		return stockService.retrieveAllStocks();
	}

	// http://localhost:8089/SpringMVC/stock/retrieve-stock/8
	@GetMapping("/retrieve-stock/{stock-id}")
	@ResponseBody
	public Stock retrieveStock(@PathVariable("stock-id") Long stockId) {
		return stockService.retrieveStock(stockId);
	}

	// http://localhost:8089/SpringMVC/stock/add-stock
	@PostMapping("/add-stock")
	@ResponseBody
	public StockDTO addStock(@RequestBody StockDTO stockDTO) {
		Stock stockRequest = modelMapper.map(stockDTO, Stock.class);

		Stock stock = stockService.addStock(stockRequest);

		return modelMapper.map(stock, StockDTO.class);
	}

	@DeleteMapping("/remove-stock/{stock-id}")
	@ResponseBody
	public void removeStock(@PathVariable("stock-id") Long stockId) {
		stockService.deleteStock(stockId);
	}

	// http://localhost:8089/SpringMVC/stock/modify-stock
	@PutMapping("/modify-stock")
	@ResponseBody
	public StockDTO modifyStock(@RequestBody StockDTO stockDTO) {

		Stock stockRequest = modelMapper.map(stockDTO, Stock.class);

		Stock stock = stockService.updateStock(stockRequest);

		return modelMapper.map(stock, StockDTO.class);
	}

}