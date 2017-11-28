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
        String msg = "Enter the number of shares would like to sell";
        String amountString = folioView.inputAmount(msg);
        if(amountString !=  null){
            try {
                int amount = Integer.parseInt(amountString.trim());
                folio.getStockByTicker(ticker).sell(amount);
                if (folio.getStockByTicker(ticker).getShares() == 0)
                    folio.deleteStock(folio.getStockByTicker(ticker));
            } catch (NegativeSharesException e1) {
            folioView.alertErrorMsg("Shares not sold: You cannot sell more shares than you own.");
            // e1.printStackTrace();
             }
            catch(NumberFormatException e1){
            folioView.alertErrorMsg("Shares not sold: Invalid number formatting");
         }
        }
    }
}
