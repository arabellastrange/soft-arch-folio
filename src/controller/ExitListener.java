package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitListener implements ActionListener {

    JFrame frMain;

    ExitListener(JFrame frMain)
    {
        this.frMain = frMain;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        exit();
    }

    private void exit()
    {
        System.exit(0);
    }
}
