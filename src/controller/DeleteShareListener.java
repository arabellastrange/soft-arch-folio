package controller;

import model.IFolio;
import model.IFolioTracker;
import model.IStock;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteShareListener implements ActionListener{

    private IFolioTracker f;
    private IFolio s;
    private String ticker;

    DeleteShareListener(IFolioTracker f, String ticker, String fName)
    {
        this.f = f;
        s = f.getFolioByName(fName);
        this.ticker = ticker;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        delDialogue();
    }

    private void delDialogue()
    {
        int dialogueButton = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this share?", "WARNING", dialogueButton);
        if(dialogueButton == JOptionPane.YES_OPTION)
        {
            //delete stock in the model
            s.deleteStock(s.getStockByTicker(ticker));

            //delete the row
            //refresh the view by calling the refresh method Ioan is currently working on
        }
        else
        {
            //do not delete the row
        }
    }
}
