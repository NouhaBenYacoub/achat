package tn.esprit.rh.achat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tn.esprit.rh.achat.DTO.StockDTO;
import tn.esprit.rh.achat.controllers.StockRestController;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class StockTest {

    long id1 = java.util.UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    long id2 = java.util.UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    long id3 = java.util.UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    Stock RECORD_1 = new Stock(id1, "alimentaire", 50, 5);
    Stock RECORD_2 = new Stock(id2, "électro", 100, 20);
    Stock RECORD_3 = new Stock(id3, "vestimentaire", 150, 10);

    @Mock
    private IStockService stockService;
    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private StockRestController stockController;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetStocks() {
        List<Stock> stocks = Arrays.asList(
                RECORD_1, RECORD_2, RECORD_3
        );

        Mockito.when(stockService.retrieveAllStocks()).thenReturn(stocks);

        List<Stock> result = stockController.getStocks();

        assert result != null;
        assert result.size() == 3;
    }


    @Test
    public void testRetrieveStock() {

        Mockito.when(stockService.retrieveStock(id1)).thenReturn(RECORD_1);

        Stock result = stockController.retrieveStock(id1);

        assert result != null;
        assert result.getIdStock().equals(id1);
    }


    @Test
    public void testRemoveStockNonExisting() {
        Long nonExistingStockId = 999L;

        Mockito.doThrow(new IllegalArgumentException("Stock not found")).when(stockService).deleteStock(nonExistingStockId);

        try {
            stockController.removeStock(nonExistingStockId);
        } catch (IllegalArgumentException ex) {
        }
    }

    @Test
    public void testAddStock() {
        StockDTO stockDTO = new StockDTO();
        stockDTO.setIdStock(1L);
        stockDTO.setLibelleStock("New Stock");
        stockDTO.setQte(50);
        stockDTO.setQteMin(5);

        Stock stock = new Stock();
        stock.setIdStock(1L);
        stock.setLibelleStock("New Stock");
        stock.setQte(50);
        stock.setQteMin(5);

        Mockito.when(modelMapper.map(Mockito.any(Stock.class), Mockito.any())).thenReturn(stockDTO);
        Mockito.when(modelMapper.map(Mockito.any(StockDTO.class), Mockito.any())).thenReturn(stock);

        Mockito.when(stockService.addStock(stock)).thenReturn(stock);

        StockDTO result = stockController.addStock(stockDTO);

        assert result != null;
        assert result.getLibelleStock().equals(stockDTO.getLibelleStock());
    }

    @Test
    public void testmodifStock() {
        StockDTO stockDTO = new StockDTO();
        stockDTO.setIdStock(1L);
        stockDTO.setLibelleStock("New Stock");
        stockDTO.setQte(50);
        stockDTO.setQteMin(5);

        Stock stock = new Stock();
        stock.setIdStock(1L);
        stock.setLibelleStock("New Stock");
        stock.setQte(50);
        stock.setQteMin(5);

        Mockito.when(modelMapper.map(Mockito.any(Stock.class), Mockito.any())).thenReturn(stockDTO);
        Mockito.when(modelMapper.map(Mockito.any(StockDTO.class), Mockito.any())).thenReturn(stock);

        Mockito.when(stockService.updateStock(stock)).thenReturn(stock);

        StockDTO result = stockController.modifyStock(stockDTO);

        assert result != null;
        assert result.getLibelleStock().equals(stockDTO.getLibelleStock());
    }

}
