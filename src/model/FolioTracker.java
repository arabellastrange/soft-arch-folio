package model;

import java.util.Collection;
import java.util.Observable;

public class FolioTracker extends Observable implements IFolioTracker {

    private Collection<Folio> folios;

    @Override
    public void createFolio(String name) {

    }

    @Override
    public IFolio getFolioByName(String name) {
        return null;
    }

    @Override
    public String getFolioNames() {
        return null;
    }

    @Override
    public void deleteFolio(String name) {

    }

    @Override
    public void refresh() {

    }

}
