package model;

import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.InvalidNameException;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StockTest {
    private Stock dummyStock1;
    private Stock dummyStock2;
    private Stock dummyStock3;
    private Stock dummyStock5;
    private Stock dummyStock6;

    @BeforeEach
    private void setUp() throws NoSuchTickerException, WebsiteDataException {
        dummyStock1 = new Stock("msft", "help", 88);
        dummyStock3 = new Stock("msft", "add", 2112);
        dummyStock2 = new Stock("aapl", "me", 400);
        dummyStock5 = new Stock(dummyStock2);
        dummyStock6 = new Stock ("aapl", "whp", 500);
    }

    @Test
    public void testSetUp(){
        assertEquals(dummyStock1.getShares(), 88);
    }

    @Test
    public void testBuy() throws NegativeSharesException {
        dummyStock1.buy(100);
        assertEquals(dummyStock1.getShares(), 188);
    }

    @Test
    public void testBuy2() throws NegativeSharesException {
         assertThrows(NegativeSharesException.class, () -> dummyStock1.buy(-7));
    }

    @Test
    public void testSell() throws NegativeSharesException {
        dummyStock2.sell(200);
        assertEquals(dummyStock2.getShares(), 200);
    }

    @Test
    public void testSell2() throws NegativeSharesException {
        assertThrows(NegativeSharesException.class, () -> dummyStock2.sell(600));
    }

    @Test
    public void testSetName() throws InvalidNameException {
        assertTrue(dummyStock1.getName().equals("help"));
        dummyStock1.setName("Ahhh");
        assertTrue(dummyStock1.getName().equals("Ahhh"));
    }

    @Test
    public void testSetName2() throws  InvalidNameException{
        assertThrows(InvalidNameException.class,  () -> dummyStock1.setName(""));
    }

    @Test
    public void testHoldingValue() throws NegativeSharesException {
        double oldHold = dummyStock1.getHoldingValue();
        dummyStock1.buy(200);
        assertTrue(dummyStock1.getHoldingValue() > oldHold);
    }

    @Test
    public void testHoldingValue2() throws NegativeSharesException {
        double oldHold = dummyStock1.getHoldingValue();
        dummyStock1.sell(20);
        assertTrue(dummyStock1.getHoldingValue() < oldHold);
    }

    @Test
    public void testEqualsReflexive(){
        assertTrue(dummyStock1.equals(dummyStock1));
    }

    @Test
    public void testEqualsSymmetric(){
        assertTrue(dummyStock3.equals(dummyStock1) && dummyStock1.equals(dummyStock3));
    }

    @Test
    public void testEqualsConsistent(){
        assertTrue(dummyStock3.equals(dummyStock1) && dummyStock3.equals(dummyStock1));
    }

    @Test
    public void testEqualsNotNull(){
        Stock dummyStock4 = null;
        assertFalse(dummyStock1.equals(dummyStock4));
    }

    @Test
    public void testNotEqual(){
        assertFalse(dummyStock1.equals(dummyStock2));
    }

    @Test
    public void testEqualTransitive(){
        assertTrue(dummyStock2.equals(dummyStock5) && dummyStock5.equals(dummyStock6) && dummyStock2.equals(dummyStock6));
    }

    @Test
    public void testHashCode(){
        assertEquals(dummyStock1.hashCode(), dummyStock3.hashCode());
    }

    @Test
    public void testNoTicker(){
        assertThrows(WebsiteDataException.class, () -> new Stock("apple", "green", 87));
    }
}