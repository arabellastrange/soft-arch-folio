//package model;
//
//import model.web.NoSuchTickerException;
//import model.web.WebsiteDataException;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import javax.naming.InvalidNameException;
//import java.io.IOException;
//
//class FolioTrackerTest {
//    private FolioTracker folioTracker;
//
//    @BeforeEach
//    void setUp() throws WebsiteDataException, NegativeSharesException, InvalidNameException, NoSuchTickerException {
//        folioTracker = new FolioTracker();
//        folioTracker.createFolio("MyFolio");
//        folioTracker.createFolio("YourFolio");
//        folioTracker.getFolioByName("MyFolio").createStock("MSFT", "microsoft", 20);
//    }
//
//    @Test
//    void testSave() {
////        assertTrue(folioTracker.saveToDisk());
//    }
//
//    @Test
//    void testLoad() throws IOException, ClassNotFoundException {
////        assertEquals(folioTracker, IFolioTracker.load());
//    }
//
//}
