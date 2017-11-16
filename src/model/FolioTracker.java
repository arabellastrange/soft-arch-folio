package model;

import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;

import java.io.*;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

class FolioTracker extends Observable implements IFolioTracker, Serializable {

    private Set<Folio> folios;

    FolioTracker() {
        folios = new HashSet<>();
    }

    @Override
    public boolean createFolio(String name) {
        return folios.add(new Folio(name));
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
    public boolean deleteFolio(IFolio folio) {
        return folios.remove(folio);
    }

    @Override
    public void refresh() throws NoSuchTickerException, WebsiteDataException {
        for (Folio f : folios) {
            f.refresh();
        }
    }

    @Override
    public boolean saveToDisk() {
        FileOutputStream fos;
        ObjectOutputStream oos;

        try {
            fos = new FileOutputStream("test.folio");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("saved data");
        return true;
    }

}
