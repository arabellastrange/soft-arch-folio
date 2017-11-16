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
    public IFolio getFolioByName(String name) {
        return null;
    }

    @Override
    public List<String> getFolioNames() {
        return folios
                .stream()
                .map(folio -> folio.getName())
                .collect(Collectors.toList());
    }

    @Override
    public void deleteFolio(String name) {
        folios = folios
                .stream()
                .filter(folio -> !folio.getName().equals(name))
                .collect(Collectors.toSet());
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
