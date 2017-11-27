package controller;

import model.IFolioTracker;
import view.FolioTrackerView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class OpenListener implements ActionListener {

    FolioTrackerView folioTrackerView;

    OpenListener(FolioTrackerView folioTrackerView)
    {
        this.folioTrackerView = folioTrackerView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            open();
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(folioTrackerView.getfrMain(), "Not a valid file", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e1) {
            JOptionPane.showMessageDialog(folioTrackerView.getfrMain(), "Not a valid file type", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void open() throws IOException, ClassNotFoundException {
        JFileChooser jfc = new JFileChooser();
        int result = jfc.showOpenDialog(folioTrackerView.getfrMain());
        if (result == JFileChooser.APPROVE_OPTION)
        {
            IFolioTracker.load(jfc.getSelectedFile());
        }

    }
}
