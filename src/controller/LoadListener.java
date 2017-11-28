package controller;

import model.IFolio;
import model.IFolioTracker;
import view.FolioTrackerView;
import view.FolioView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

public class LoadListener implements ActionListener {
    private final FolioTrackerView view;
    private IFolioTracker folioTracker;

    public LoadListener(IFolioTracker folioTracker, FolioTrackerView view) {
        this.folioTracker = folioTracker;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            File file = view.getFile();
            folioTracker = IFolioTracker.load(file);
            view.resetViews();
            view.setTracker(folioTracker);
            folioTracker.registerObserver(view);
            for (IFolio f : folioTracker.getFolios()) {
                FolioView newFolioView = new FolioView(folioTracker, f);
                f.registerObserver(newFolioView);
                view.addFolioView(f.getName(), newFolioView);
                newFolioView.update((Observable) f, null);
            }
            view.update((Observable) folioTracker, null);
        } catch (IOException e1) {
            view.outputErrorMessage("Not a valid file.");
        } catch (ClassNotFoundException e2) {
            view.outputErrorMessage("Not a valid file type.");
        } catch (NullPointerException nullpointer) {

        }
    }
}
