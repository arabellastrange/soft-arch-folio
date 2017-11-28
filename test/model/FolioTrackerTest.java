package model;

import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.InvalidNameException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FolioTrackerTest {
    private FolioTracker folioTracker;

    @BeforeEach
    void setUp() throws WebsiteDataException, NegativeSharesException, InvalidNameException, NoSuchTickerException {
        folioTracker = new FolioTracker();
    }

    @Test
    void testSave() {
//        assertTrue(folioTracker.saveToDisk());
    }

    @Test
    void testLoad() throws IOException, ClassNotFoundException {
//        assertEquals(folioTracker, IFolioTracker.load());
    }

}
