package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveListener implements ActionListener {

    JFrame frMain;

    SaveListener(JFrame frMain)
    {
        this.frMain = frMain;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        save();
    }

    private void save()
    {
        JFileChooser jfc = new JFileChooser();
        jfc.showSaveDialog(frMain);
    }
}
