package controller;

import model.DuplicateFolioException;
import model.IFolio;
import model.IFolioTracker;
import view.FolioTrackerView;
import view.FolioView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateFolioListener implements ActionListener {
    private IFolioTracker folioTracker;
    private FolioTrackerView trackerView;

    public CreateFolioListener(FolioTrackerView trackerView, IFolioTracker folioTracker) {
        this.folioTracker = folioTracker;
        this.trackerView = trackerView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String folioName = trackerView.getFolioName();
            IFolio f = folioTracker.createFolio(folioName);
            FolioView folioView = new FolioView(folioTracker, f);
            f.registerObserver(folioView);
            trackerView.createFolioView(folioName, folioView);
        } catch (NullPointerException ex) {
            //fixme error msg to user
        } catch (DuplicateFolioException e1) {
            //fixme error msg to user
        }
    }
}
