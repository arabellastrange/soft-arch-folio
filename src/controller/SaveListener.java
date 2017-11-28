package controller;


import model.EmptyFolioTrackerException;
import model.FolioTracker;
import model.IFolioTracker;
import view.FolioTrackerView;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SaveListener implements ActionListener {

    private FolioTrackerView folioTrackerView;
    private IFolioTracker folioTracker;

    public SaveListener(FolioTrackerView folioTrackerView, IFolioTracker folioTracker) {
        this.folioTrackerView = folioTrackerView;
        this.folioTracker = folioTracker;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            save();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private void save() throws IOException {
        FileNameExtensionFilter filtTxt = new FileNameExtensionFilter("FOLIO FILES", "folio", "folios");
        JFileChooser jfc = new JFileChooser();
        jfc.setSelectedFile(new File("default.folio"));
        jfc.setFileFilter(filtTxt);
        if (1 == JFileChooser.APPROVE_OPTION) {
            try {
                folioTracker.saveToDisk(jfc.getSelectedFile());
            } catch (EmptyFolioTrackerException e) {
                //fixme alert user
            }
        }
    }

}
