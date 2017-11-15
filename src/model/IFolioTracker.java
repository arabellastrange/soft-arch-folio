package model;

import java.util.Collection;
import java.util.List;

public interface IFolioTracker {

    public void createFolio(String name);

    public IFolio getFolioByName(String name);

    public List<String> getFolioNames();

    public void deleteFolio(String name);

    public void refresh();

    public boolean saveToDisk();

}
