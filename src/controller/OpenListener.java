package controller;

import model.IFolioTracker;
import view.FolioView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class OpenListener implements ActionListener {

    FolioView folioView;

    OpenListener(FolioView folioView)
    {
        this.folioView = folioView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            open();
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(folioView.getfrMain(), "Not a valid file", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e1) {
            JOptionPane.showMessageDialog(folioView.getfrMain(), "Not a valid file type", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void open() throws IOException, ClassNotFoundException {
        JFileChooser jfc = new JFileChooser();
        int result = jfc.showOpenDialog(folioView.getfrMain());
        if (result == JFileChooser.APPROVE_OPTION)
        {
            IFolioTracker.load(jfc.getSelectedFile());
        }

    }
}
