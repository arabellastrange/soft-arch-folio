package model;

import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.InvalidNameException;
import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class FolioTrackerTest {
    private FolioTracker ft1;
    private FolioTracker ft2;
    private FolioTracker ft3;

    @BeforeEach
    public void setUp(){
        ft1 = new FolioTracker();
        ft2 = new FolioTracker();
        ft3 = new FolioTracker();
    }

    @Test
    public void testCreateFolio() throws DuplicateFolioException, EmptyNameException {
        Set<IFolio> ftCopy = ft1.getFolios();
        Folio f = (Folio) ft1.createFolio("test");
        assertTrue(ftCopy.size() == 0 && ft1.getFolios().size() == 1);
        assertTrue(ft1.getFolios().contains(f));
    }

    @Test
    public void testCreateDuplicate() throws DuplicateFolioException, EmptyNameException {
        ft1.createFolio("test");
        assertThrows(DuplicateFolioException.class, () -> ft1.createFolio("test"));
    }

    @Test
    public void testCreateEmpty() throws DuplicateFolioException,EmptyNameException{
        assertThrows(EmptyNameException.class, ()-> ft2.createFolio(""));
    }

    @Test
    public void testCreateFolio2(){
        Folio f = new Folio("grain");
        assertTrue(ft2.createFolio(f));
    }

    @Test
    public void testCreateDuplicate2(){
        Folio f = new Folio("cookie");
        ft2.createFolio(f);
        assertFalse(ft2.createFolio(f));
    }

    @Test
    public void testDelete(){
        Folio f= new Folio("g");
        Folio f1 = new Folio("cat");
        ft1.createFolio(f);
        ft1.createFolio(f1);
        Set<IFolio> ftCopy = ft1.getFolios();
        ft1.deleteFolio(f);
        assertTrue(ft1.getFolios().size() == ftCopy.size() -1 && !ft1.getFolios().contains(f));
    }

    @Test
    public void testDelete2(){
        Folio f= new Folio("g");
        Folio f1 = new Folio("cat");
        ft1.createFolio(f);
        assertFalse(ft1.deleteFolio(f1));
    }

    @Test
    public void testRefresh() throws DuplicateFolioException, EmptyNameException, WebsiteDataException, NegativeSharesException, InvalidNameException, NoSuchTickerException {
        Folio f = new Folio("cat");
        ft1.createFolio(f);
        assertTrue(f.createStock("msft", "micro", 200));
    }


}
