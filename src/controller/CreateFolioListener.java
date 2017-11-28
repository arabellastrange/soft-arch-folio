package controller;

import model.DuplicateFolioException;
import model.EmptyNameException;
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
            String folioName;
            folioName = trackerView.getFolioName();
            IFolio f = folioTracker.createFolio(folioName);
            FolioView folioView = new FolioView(folioTracker, f);
            f.registerObserver(folioView);
            trackerView.addFolioView(folioName, folioView);
        } catch (NullPointerException ex) {
            //fixme error msg to user
        } catch (DuplicateFolioException e1) {
            trackerView.outputErrorMessage("Folio not added: Please don't create two folios with the same name.");
        } catch (EmptyNameException e1) {
            trackerView.outputErrorMessage("Folio not added: A folio must have a name");
        }
    }
}
