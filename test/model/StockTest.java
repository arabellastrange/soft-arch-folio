package model;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {
    private Stock dummyStock;

    @BeforeEach
    private void setUp() {
        dummyStock = new Stock("MSFT", "Microsoft", 23);
    }

}