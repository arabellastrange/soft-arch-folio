package model;

import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;

import java.io.*;
import java.util.*;

public class FolioTracker extends Observable implements IFolioTracker, Serializable{

    private Set<Folio> folios;
    private transient Timer refreshTimer;

    public FolioTracker() {
        folios = new HashSet<>();
//        setUpAutoRefresh(3000);
    }

    private void setUpAutoRefresh(long period) {
        refreshTimer = new Timer("refresh timer");
        refreshTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    refresh();
                    System.out.println("all the tickers were refreshed");
                } catch (NoSuchTickerException e) {
                    e.printStackTrace();
                } catch (WebsiteDataException e) {
                    e.printStackTrace();
                }
            }
        }, 0, period);
    }

    @Override
    public IFolio createFolio(String name) throws DuplicateFolioException, EmptyNameException {
        if(name.equals("")) throw new EmptyNameException();
        Folio f = new Folio(name);
        if (!folios.add(f)) throw new DuplicateFolioException();
        setChanged();
        notifyObservers();
        return f;
    }

    public boolean createFolio(Folio f){ return folios.add(f);}

    @Override
    public Set<IFolio> getFolios() {
        Set<IFolio> copyFolios = new HashSet<>();
        for (Folio f : folios) {
            copyFolios.add(f);
        }
        return copyFolios;
    }

    @Override
    public boolean deleteFolio(IFolio folio) {
        boolean result = folios.remove(folio);
        if (!result) return false;
        setChanged();
        notifyObservers();
        return true;
    }

    @Override
    public void refresh() throws NoSuchTickerException, WebsiteDataException {
        for (Folio f : folios) {
            f.refresh();
        }
        setChanged();
        notifyObservers();
    }

    @Override
    public boolean saveToDisk(File file) throws EmptyFolioTrackerException {
        if (folios.isEmpty()) throw new EmptyFolioTrackerException();

        FileOutputStream fos;
        ObjectOutputStream oos;

        try {
            fos = new FileOutputStream(file);
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

//    @Override
//    public IFolio getFolioByName(String name) {
//        for (Folio f : folios) {
//            if (f.getName().equals(name)) return f;
//        }
//        throw new RuntimeException(); // fixme
//    }

    @Override
    public void registerObserver(Observer o) {
        addObserver(o);
    }



}
