package model;

import java.util.Collection;

public interface IFolioTracker {

    public void createFolio(String name);

    public IFolio getFolioByName(String name);

    public String getFolioNames();

    public void deleteFolio(String name);

    public void refresh();

    public boolean saveToDisk();

}
