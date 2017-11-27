package controller;

import view.FolioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitListener implements ActionListener {

    FolioView fv;

    ExitListener(FolioView folioView)
    {
        fv = folioView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("exit");
        System.exit(0);
    }

}
