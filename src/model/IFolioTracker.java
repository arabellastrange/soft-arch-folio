package model;

import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;

import java.io.*;
import java.util.Observer;
import java.util.Set;

public interface IFolioTracker {

    public static IFolioTracker load(File file) throws IOException, ClassNotFoundException {
        FileInputStream fis;
        ObjectInputStream ois;

        fis = new FileInputStream(file);
        ois = new ObjectInputStream(fis);

        return (FolioTracker) ois.readObject();
    }

    /**
     * @modifies this
     * @effects folios' = folios + new Folio()
     */
    public IFolio createFolio(String name) throws DuplicateFolioException, EmptyNameException;

    /**
     * @returns set of foios
     */
    public Set<IFolio> getFolios();

    /**
     * @modifies this
     * @effects folios' = folios - folio
     */
    public boolean deleteFolio(IFolio folio);

    /**
     * @modifies this
     * @effects refreshes all stocks in all folios such that stock price is updated
     */
    public void refresh() throws NoSuchTickerException, WebsiteDataException;

    /**
     * @effects saves folio tracker to disk
     */
    public void saveToDisk(File file) throws IOException;


    public void registerObserver(Observer o);

}
