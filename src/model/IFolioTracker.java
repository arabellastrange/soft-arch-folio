package model;

import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;

import java.util.Set;

public interface IFolioTracker {

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
