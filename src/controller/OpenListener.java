package controller;

import model.IFolioTracker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class OpenListener implements ActionListener {

    JFrame frMain;

    OpenListener(JFrame frMain)
    {
        this.frMain = frMain;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            open();
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(frMain, "Not a valid file", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e1) {
            JOptionPane.showMessageDialog(frMain, "Not a valid file type", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void open() throws IOException, ClassNotFoundException {
        JFileChooser jfc = new JFileChooser();
        int result = jfc.showOpenDialog(frMain);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            IFolioTracker.load(jfc.getSelectedFile());
        }

    }
}
