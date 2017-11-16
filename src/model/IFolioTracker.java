package model;

import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.Set;

public interface IFolioTracker {

    public static IFolioTracker load() throws IOException, ClassNotFoundException {
        FileInputStream fis;
        ObjectInputStream ois;

        fis = new FileInputStream("test.folio");
        ois = new ObjectInputStream(fis);

        return (FolioTracker) ois.readObject();
    }

    /**
     * @param name
     * @return
     */
    public boolean createFolio(String name);

    /**
     * @return
     */
    public Set<IFolio> getFolios();

    /**
     * @param folio
     * @return
     */
    public boolean deleteFolio(IFolio folio);

    /**
     * @throws NoSuchTickerException
     * @throws WebsiteDataException
     */
    public void refresh() throws NoSuchTickerException, WebsiteDataException;

    /**
     * @return
     */
    public boolean saveToDisk();

}
