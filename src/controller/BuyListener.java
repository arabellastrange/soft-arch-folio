package controller;

import model.IFolio;
import model.IFolioTracker;
import model.NegativeSharesException;
import view.FolioView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyListener implements ActionListener {

    private final IFolio folio;
    private final String ticker;

    public BuyListener(IFolio folio, String ticker) {
        this.ticker = ticker;
        this.folio = folio;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //fixme move the swing part in FolioView and generalize it so that its reusable
        String buyShares = JOptionPane.showInputDialog("Enter the amount you would like to buy");
        try {
            int amount = Integer.parseInt(buyShares);
            folio.getStockByTicker(ticker).buy(amount);
        } catch (NegativeSharesException | NumberFormatException e1) {
            e1.printStackTrace();
        }
    }
}
