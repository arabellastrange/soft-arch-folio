package controller;

import model.IFolioTracker;
import model.NegativeSharesException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyListener implements ActionListener {

    private final IFolioTracker folioTrack;
    private final String ticker;
    private final String fName;

    BuyListener(IFolioTracker folioTrack, String ticker, String fName){

        this.folioTrack = folioTrack;
        this.ticker = ticker;
        this.fName = fName;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String buyShares = JOptionPane.showInputDialog("Enter the amount you would like to buy");


        try {
            int amount = Integer.parseInt(buyShares);
            folioTrack.getFolioByName(fName).getStockByTicker(ticker).buy(amount);
            //Refresh
        } catch (NegativeSharesException | NumberFormatException e1) {
            e1.printStackTrace();
        }
    }
}
