package controller;

import model.FolioTracker;
import model.IFolioTracker;
import view.FolioTrackerView;
import view.FolioView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateFolioListener implements ActionListener {
    private IFolioTracker iFolioTracker;
    private FolioTrackerView folioView;

    public CreateFolioListener(FolioTrackerView folioView, IFolioTracker iFolioTracker)
    {
        this.iFolioTracker = iFolioTracker;
        this.folioView = folioView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String folioName = folioView.getFolioName();
            if(!iFolioTracker.createFolio(folioName)) return;
            folioView.createFolioView(folioName);
        }
        catch (NullPointerException ex) {
            return;
        }
    }
}
