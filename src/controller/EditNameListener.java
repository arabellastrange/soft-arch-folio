package controller;

import model.EmptyNameException;
import model.IFolio;
import model.IFolioTracker;
import model.NegativeSharesException;
import view.FolioView;

import javax.naming.InvalidNameException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditNameListener implements ActionListener {

    private final FolioView folioView;
    private final IFolio folio;
    private final String ticker;
    private String name;

    public EditNameListener(FolioView folioView, IFolio folio, String ticker, String name) {
        this.folioView = folioView;
        this.ticker = ticker;
        this.folio = folio;
        this.name = name;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = "Enter the new name for this stock";
        name = folioView.inputAmount(msg);
        if (name !=null) {

            try {
                folio.getStockByTicker(ticker).setName(name);
            } catch (EmptyNameException e1) {
                folioView.alertErrorMsg("Please enter a valid name for the stock.");
                // e1.printStackTrace();
            } catch (InvalidNameException e1) { 
                folioView.alertErrorMsg("Please enter a valid name for the stock.");
            }
        }
    }
}
