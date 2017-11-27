package controller;

import view.FolioTrackerView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitListener implements ActionListener {

    FolioTrackerView fv;

    ExitListener(FolioTrackerView folioTrackerView)
    {
        fv = folioTrackerView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("exit");
        System.exit(0);
    }

}
