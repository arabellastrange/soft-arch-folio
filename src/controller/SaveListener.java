package controller;


import model.EmptyFolioTrackerException;
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
            view.outputErrorMessage("No folios to save.");
            return;
        }
        try {
            file = view.getFile();
        } catch (FileNotFoundException e1) {
            view.outputErrorMessage("Wrong file");
        }
        try {
            folioTracker.saveToDisk(file);
        } catch (IOException e1) {
            view.outputErrorMessage("Couldnr read from file");
        } catch (NullPointerException nullptr) {

        }
    }

}
