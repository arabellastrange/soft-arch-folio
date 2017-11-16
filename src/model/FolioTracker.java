package model;

import java.util.*;
import java.util.stream.Collectors;

class FolioTracker extends Observable implements IFolioTracker {

    private Set<Folio> folios;

    FolioTracker() {
        folios = new HashSet<>();

    }

    @Override
    public void createFolio(String name) {
        folios.add(new Folio(name));
    }

    @Override
    public Set<IFolio> getFolios() {

        Set<IFolio> copyFolios = new HashSet<>();

        for (Folio f : folios) {
            copyFolios.add(new Folio(f));
        }

        return copyFolios;
    }

    @Override
    public void deleteFolio(IFolio folio) {

    }

    @Override
    public void refresh() {
        folios.forEach(folio -> folio.refresh());
    }

    @Override
    public boolean saveToDisk() {
        return false;
    }

}
