package controller;

import model.IFolio;
import model.NegativeSharesException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellListener implements ActionListener {

    private final IFolio folio;
    private final String ticker;

    public SellListener(IFolio folio, String ticker) {
        this.folio = folio;
        this.ticker = ticker;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //fixme same as in buy
        String sellShares = JOptionPane.showInputDialog("Enter the amount you would like to sell");

        try {
            int amount = Integer.parseInt(sellShares);
            folio.getStockByTicker(ticker).sell(amount);
        } catch (NegativeSharesException | NumberFormatException e1) {
            e1.printStackTrace();
        }
    }
}
