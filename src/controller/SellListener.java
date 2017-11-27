package controller;

import model.IFolioTracker;
import model.NegativeSharesException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellListener implements ActionListener{

    private final IFolioTracker folioTrack;
    private final String ticker;
    private final String fName;

    SellListener(IFolioTracker folioTrack, String fName, String ticker){

        this.folioTrack = folioTrack;
        this.ticker = ticker;
        this.fName = fName;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String sellShares = JOptionPane.showInputDialog("Enter the amount you would like to sell");

        try {
            int amount = Integer.parseInt(sellShares);
            folioTrack.getFolioByName(fName).getStockByTicker(ticker).sell(amount);
            //Refresh
        } catch (NegativeSharesException | NumberFormatException e1) {
            e1.printStackTrace();
        }
    }
}
