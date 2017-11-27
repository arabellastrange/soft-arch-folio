package controller;

import model.IFolio;
import model.IFolioTracker;
import view.CreateView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListener implements ActionListener {

    private IFolioTracker ift;
    private IFolio f;
    private CreateView cv;

    DeleteListener(CreateView cv, String folioName, IFolioTracker folioTracker)
    {
        ift = folioTracker;
        f = ift.getFolioByName(folioName);
        this.cv = cv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(areYouSure())
        {
            delete();
        }
    }

    private boolean areYouSure()
    {
        int dialogueButton = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this folio?","WARNING",dialogueButton);
        if(dialogueButton == JOptionPane.YES_OPTION)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private void delete()
    {
        ift.deleteFolio(f);
        cv.closeTab();
    }
}
