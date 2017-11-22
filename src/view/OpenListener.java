package view;

import model.IFolioTracker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenListener implements ActionListener {

    JFrame frMain;

    OpenListener(JFrame frMain)
    {
        this.frMain = frMain;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        open();
    }

    private void open()
    {
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(frMain);
        //IFolioTracker.load(jfc.getSelectedFile());
    }
}
