package model;

import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.InvalidNameException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FolioTest {
    private FolioTracker folioTracker;
    private Folio f1;
    private Folio f2;
    private Folio f3;
    private Folio f4;

    @BeforeEach
    void setUp() throws WebsiteDataException, NegativeSharesException, InvalidNameException, NoSuchTickerException {
        folioTracker = new FolioTracker();
        f1 = new Folio("MyFolio");
        f2 = new Folio("YourFolio");
        f3 = new Folio("MyFolio");
        f4 = new Folio("MyFolio");

        folioTracker.createFolio(f1);
        folioTracker.createFolio(f2);
    }

    @Test
    void testSave() {
//        assertTrue(folioTracker.saveToDisk());
    }

    @Test
    void testLoad() throws IOException, ClassNotFoundException {
//        assertEquals(folioTracker, IFolioTracker.load());
    }

    @Test
    void testAddStock() throws WebsiteDataException, NegativeSharesException, InvalidNameException, NoSuchTickerException {
        Folio oldF = new Folio(f1);
        f1.createStock("MSFT", "microsoft", 20);
        assertTrue(f1.getStocks().size() == 1 + oldF.getStocks().size());

    }

    @Test
    void testAddStock2() throws WebsiteDataException, NegativeSharesException, InvalidNameException, NoSuchTickerException {
        f1.createStock("aapl", "aaa", 300);
        f1.createStock("x", "woo", 40);

        Folio oldF = new Folio(f1);

        f1.createStock("MSFT", "microsoft", 20);

        assertTrue(f1.getStocks().size() == 1 + oldF.getStocks().size() && f1.getStocks().containsAll(oldF.getStocks()));
    }

    @Test
    void testAddStock3() throws WebsiteDataException, NegativeSharesException, InvalidNameException, NoSuchTickerException {
        assertThrows(NegativeSharesException.class, () -> f1.createStock("x", "woo", -4));
    }

    @Test
    void testAddStock4() throws WebsiteDataException, NegativeSharesException, InvalidNameException, NoSuchTickerException {
        assertThrows(InvalidNameException.class, () -> f1.createStock("x", "", 4));
    }

    @Test
    void testAddStock5() throws WebsiteDataException, NegativeSharesException, InvalidNameException, NoSuchTickerException {
        assertThrows(WebsiteDataException.class, () -> f1.createStock("oK", "gfhgf", 4));
    }

    @Test
    void testGetStock() throws NoSuchTickerException, WebsiteDataException, InvalidNameException, NegativeSharesException {
        Stock s = new Stock("sd", "yay", 34);
        f1.createStock("sd", "yay", 34);
        assertEquals(f1.getStockByTicker("sd"), s);
    }

    @Test
    void testGetStock2() throws NoSuchTickerException, WebsiteDataException, InvalidNameException, NegativeSharesException {
        f1.createStock("sd", "yay", 34);
        assertEquals(f1.getStockByTicker("dldlsa"), null);
    }

    @Test
    void testDeleteStock() throws WebsiteDataException, NegativeSharesException, InvalidNameException, NoSuchTickerException {
        f1.createStock("aapl", "aaa", 300);
        f1.createStock("x", "woo", 40);
        f1.createStock("MSFT", "microsoft", 20);
        Stock x = (Stock) f1.getStockByTicker("x");
        Folio oldF = new Folio(f1);
        f1.deleteStock(x);
        assertFalse(f1.getStocks().contains(x));
        assertTrue(f1.getStocks().size() == oldF.getStocks().size() - 1);
    }

    @Test
    void testDeleteStock2() throws WebsiteDataException, NegativeSharesException, InvalidNameException, NoSuchTickerException {
        f1.createStock("aapl", "aaa", 300);
        Stock m = new Stock("MSFT", "microsoft", 20);
       // assertFalse(f1.deleteStock(m));
    }

    @Test
    void testEqualsConsistent() {
        assertTrue(f1.equals(f4) && f1.equals(f4));
    }

    @Test
    void testEqualsReflexive() {
        assertTrue(f1.equals(f1));
    }

    @Test
    void testEqualsSymmetric() {
        assertTrue(f1.equals(f4) && f4.equals(f1));
    }

    @Test
    void testNotEqualNull() {
        Stock s = null;
        assertFalse(f1.equals(s));
    }

    // transitive equal

    @Test
    void testGetValue() throws NoSuchTickerException, WebsiteDataException, InvalidNameException, NegativeSharesException {
        f1.createStock("aapl", "aaa", 300);
        f1.createStock("x", "woo", 40);
        Folio oldF = new Folio(f1);
        f1.createStock("MSFT", "microsoft", 20);
        assertTrue(f1.getValue() > oldF.getValue());
    }


}
