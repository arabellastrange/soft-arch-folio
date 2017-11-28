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
        String msg = "Enter the amount you would like to buy";

        try {
            int amount = Integer.parseInt(folioView.inputAmount(msg));
            folio.getStockByTicker(ticker).buy(amount);
            System.out.println(folio.getStockByTicker(ticker).lossProfit());
        } catch (NegativeSharesException | NumberFormatException e1) {
            folioView.alertErrorMsg("You cannot buy an invalid amount of shares.");
           // e1.printStackTrace();
        }
    }
}
