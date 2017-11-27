//package model;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//class StockTest {
//    private Stock dummyStock;
//
//    @BeforeEach
//    private void setUp() {
//        dummyStock = mock(Stock.class);
//        when(dummyStock.getHoldingValue()).thenReturn((double) 1000);
//        when(dummyStock.getPricePerShare()).thenAnswer(anwer -> (double) 3);
//    }
//
//    @Test
//    void test() {
//        assertEquals(dummyStock.getHoldingValue(), 1000);
//    }
//
//    @Test
//    void test2() {
//        assertEquals(dummyStock.getPricePerShare(), 3);
//    }
//
//}