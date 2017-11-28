package controller;

import model.IFolio;
import model.NegativeSharesException;
import view.FolioView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteShareListener implements ActionListener {

    private final IFolio folio;
    private final String ticker;
    private final FolioView folioView;

    public DeleteShareListener(FolioView folioView, IFolio folio, String ticker) {
        this.folioView = folioView;
        this.folio = folio;
        this.ticker = ticker;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //fixme same as in buy
        String msg = "Are you sure you want to delete all " + ticker + " shares?";

        try {
          if (folioView.getConfirmation(msg))
          {
              folio.deleteStock(folio.getStockByTicker(ticker));
          }
        } catch (NullPointerException ee) {
            ee.printStackTrace();
        }
    }
}
