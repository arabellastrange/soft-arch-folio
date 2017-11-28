package controller;

import model.IFolio;
import model.NegativeSharesException;
import view.FolioView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellListener implements ActionListener {

    private final IFolio folio;
    private final String ticker;
    private final FolioView folioView;

    public SellListener(FolioView folioView, IFolio folio, String ticker) {
        this.folioView = folioView;
        this.folio = folio;
        this.ticker = ticker;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //fixme same as in buy
        String msg = "Enter the amount you would like to sell";

        try {
            int amount = Integer.parseInt(folioView.inputAmount(msg));
            folio.getStockByTicker(ticker).sell(amount);
            if(folio.getStockByTicker(ticker).getShares() == 0)
                folio.deleteStock(folio.getStockByTicker(ticker));
        } catch (NegativeSharesException | NumberFormatException e1) {
            e1.printStackTrace();
        }
    }
}
