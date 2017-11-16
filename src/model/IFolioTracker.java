package model;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface IFolioTracker {

    /**
     * @require
     * @param name
     */
    public void createFolio(String name);

    public Set<IFolio> getFolios();

    public void deleteFolio(IFolio folio);

    public void refresh();

    public boolean saveToDisk();

}
