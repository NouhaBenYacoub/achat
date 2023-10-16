package tn.esprit.rh.achat;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tn.esprit.rh.achat.DTO.StockDTO;
import tn.esprit.rh.achat.controllers.StockRestController;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;
import tn.esprit.rh.achat.services.ProduitServiceImpl;
import tn.esprit.rh.achat.services.StockServiceImpl;

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

    @InjectMocks
    private StockRestController stockController;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetStocks() {
        // Create a mock list of stocks
        List<Stock> stocks = Arrays.asList(
                RECORD_1, RECORD_2, RECORD_3
        );

        // Define the behavior of the stockService mock
        Mockito.when(stockService.retrieveAllStocks()).thenReturn(stocks);

        List<Stock> result = stockController.getStocks();

        // Verify that the controller returned the expected result
        assert result != null;
        assert result.size() == 3;
    }


    @Test
    public void testRetrieveStock() {

        // Define the behavior of the stockService mock
        Mockito.when(stockService.retrieveStock(id1)).thenReturn(RECORD_1);

        Stock result = stockController.retrieveStock(id1);

        // Verify that the controller returned the expected result
        assert result != null;
        assert result.getIdStock().equals(id1);
    }


    @Test
    public void testRemoveStockNonExisting() {
        Long nonExistingStockId = 999L;

        // Define the behavior of the stockService mock to throw an exception for a non-existing stock
        Mockito.doThrow(new IllegalArgumentException("Stock not found")).when(stockService).deleteStock(nonExistingStockId);

        // Verify that the controller handles the exception appropriately
        try {
            stockController.removeStock(nonExistingStockId);
            // Assert that an exception is thrown or some specific error handling behavior is performed
        } catch (IllegalArgumentException ex) {
            // Expected behavior
        }
    }

}
