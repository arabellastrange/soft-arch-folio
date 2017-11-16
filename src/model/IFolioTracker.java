package model;

import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;

import java.util.Set;

public interface IFolioTracker {

    public boolean createFolio(String name);

    public Set<IFolio> getFolios();

    public boolean deleteFolio(IFolio folio);

    public void refresh() throws NoSuchTickerException, WebsiteDataException;

    public boolean saveToDisk();

}
