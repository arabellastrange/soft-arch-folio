package controller;

import model.IFolioTracker;
import view.FolioTrackerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SaveListener implements ActionListener {

    private FolioTrackerView view;
    private IFolioTracker folioTracker;

    public SaveListener(FolioTrackerView view, IFolioTracker folioTracker) {
        this.view = view;
        this.folioTracker = folioTracker;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File file = null;
        if (folioTracker.getFolios().isEmpty()) {
            view.outputErrorMessage("File not saved: No folios to save.");
            return;
        }
        try {
            file = view.getFile();
            String path = file.getPath();
            if (!path.endsWith(".folio")) path += ".folio";
            file = new File(path);
        } catch (FileNotFoundException e1) {
            view.outputErrorMessage("File not saved: Wrong file");
        }
        try {
            folioTracker.saveToDisk(file);
        } catch (IOException e1) {
            view.outputErrorMessage("File not saved: Couldn't read from file");
        } catch (NullPointerException nullptr) {

        }
    }

}
