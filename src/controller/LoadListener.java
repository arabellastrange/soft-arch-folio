package controller;

import model.IFolio;
import model.IFolioTracker;
import view.FolioTrackerView;
import view.FolioView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        int result = jfc.showOpenDialog(folioTrackerView.getfrMain());
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                folioTracker = IFolioTracker.load(jfc.getSelectedFile());
                folioTracker.registerObserver(folioTrackerView);
                for (IFolio f : folioTracker.getFolios()) {
                    FolioView newFolioView = new FolioView(folioTracker, f);
                    f.registerObserver(newFolioView);
                    folioTrackerView.addFolioView(f.getName(), newFolioView);
                }

                folioTrackerView.update((Observable) folioTracker, null);
            } catch (IOException e1) {
                //fixme err msgs
                JOptionPane.showMessageDialog(folioTrackerView.getfrMain(), "Not a valid file", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException e2) {
                //fixme err msgs
                JOptionPane.showMessageDialog(folioTrackerView.getfrMain(), "Not a valid file type", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
