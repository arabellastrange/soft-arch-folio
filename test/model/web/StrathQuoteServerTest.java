package model.web;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrathQuoteServerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getLastValue() throws NoSuchTickerException, WebsiteDataException {
        String result = StrathQuoteServer.getLastValue("MSFT");
        System.out.println(result);
        assertTrue(!result.isEmpty() && result instanceof String, "price should be string");
    }

}