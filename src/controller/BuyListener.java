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

    public BuyListener(IFolioTracker folioTrack, String fName, String ticker){
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
        } catch (NegativeSharesException | NumberFormatException e1) {
            e1.printStackTrace();
        }
    }
}
