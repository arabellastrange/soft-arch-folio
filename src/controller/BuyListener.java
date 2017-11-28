package controller;

import model.IFolio;
import model.IFolioTracker;
import model.NegativeSharesException;
import view.FolioView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyListener implements ActionListener {

    private final FolioView folioView;
    private final IFolio folio;
    private final String ticker;

    public BuyListener(FolioView folioView, IFolio folio, String ticker) {
        this.folioView = folioView;
        this.ticker = ticker;
        this.folio = folio;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = "Enter the number of shares you would like to buy";
        String amountString = folioView.inputAmount(msg);
        if(amountString !=  null){
            try {
                int amount = Integer.parseInt(amountString.trim());
                folio.getStockByTicker(ticker).buy(amount);
                System.out.println(folio.getStockByTicker(ticker).lossProfit());
            } catch (NegativeSharesException e1) {
                folioView.alertErrorMsg("Shares not bought: You cannot buy a negative amount of shares.");
                // e1.printStackTrace();
            }
            catch(NumberFormatException e1){
                folioView.alertErrorMsg("Shares not bought: Invalid number formatting");
            }
        }
    }
}
