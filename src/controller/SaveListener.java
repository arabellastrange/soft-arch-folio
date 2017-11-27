package controller;


import model.IFolioTracker;
import view.FolioView;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SaveListener implements ActionListener {

    FolioView folioView;

    SaveListener(FolioView folioView)
    {
        this.folioView = folioView;
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
        int result = jfc.showSaveDialog(folioView.getfrMain());
        if (result == JFileChooser.APPROVE_OPTION)
        {
            System.out.println("Save");
            //TODO call some save function from the backend
            //IFolioTracker.saveToDisk(jfc.getSelectedFile());
        }
    }

}
