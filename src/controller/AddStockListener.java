package controller;

import model.IFolio;
import model.IFolioTracker;
import model.NegativeSharesException;
import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;
import view.FolioView;

import javax.naming.InvalidNameException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStockListener implements ActionListener {

    private final FolioView folioView;
    private final String folioName;
    private final IFolioTracker folioTracker;

    public AddStockListener(FolioView folioView, IFolioTracker f, String folioName) {
        this.folioView = folioView;
        this.folioTracker = f;
        this.folioName = folioName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        IFolio folio = folioTracker.getFolioByName(folioName);
        try {
            String ticker = folioView.getTicker();
            folio.createStock(ticker, folioView.getStockName(), folioView.getNumberOfShares());
            folio.getStockByTicker(ticker).registerObserver(folioView);

        } catch (InvalidNameException e1) {
            folioView.alertErrorMsg("invalid name");
        } catch (NegativeSharesException e1) {
            folioView.alertErrorMsg("negative shares");
        } catch (NoSuchTickerException e1) {
            folioView.alertErrorMsg("no ticker ");
        } catch (WebsiteDataException e1) {
            folioView.alertErrorMsg("dead weabsite");
        }
    }

}
