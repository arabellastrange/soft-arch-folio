package controller;

import model.IFolio;
import model.IFolioTracker;
import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;
import view.FolioTrackerView;
import view.FolioView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

public class LoadListener implements ActionListener {
    private final FolioTrackerView folioTrackerView;
    private IFolioTracker folioTracker;

    public LoadListener(IFolioTracker folioTracker, FolioTrackerView folioTrackerView) {
        this.folioTracker = folioTracker;
        this.folioTrackerView = folioTrackerView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = jfc.showOpenDialog(folioTrackerView.getfrMain());
        if (result == 0) {
            try {
                folioTracker = IFolioTracker.load(jfc.getSelectedFile());
                folioTrackerView.resetViews();
                folioTrackerView.setTracker(folioTracker);
                folioTracker.registerObserver(folioTrackerView);
                for (IFolio f : folioTracker.getFolios()) {
                    FolioView newFolioView = new FolioView(folioTracker, f);
                    f.registerObserver(newFolioView);
                    folioTrackerView.addFolioView(f.getName(), newFolioView);
                    newFolioView.update((Observable) f, null);
                }
                folioTrackerView.update((Observable) folioTracker, null);
            } catch (IOException e1) {
                folioTrackerView.outputErrorMessage("Not a valid file.");
            } catch (ClassNotFoundException e2) {
                folioTrackerView.outputErrorMessage("Not a valid file type.");
            }
        }
    }
}
