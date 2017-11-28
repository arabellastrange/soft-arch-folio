package controller;

import model.IFolio;
import model.IFolioTracker;
import model.NegativeSharesException;
import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;
import view.FolioView;

import javax.naming.InvalidNameException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStockListener implements ActionListener {

    private final FolioView folioView;
    private final IFolio folio;

    public AddStockListener(FolioView folioView, IFolio folio) {
        this.folioView = folioView;
        this.folio = folio;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String ticker = folioView.getTicker().trim().toUpperCase();
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
        } catch (NullPointerException e1    ){
            folioView.alertErrorMsg("invalid share amount");
        }
    }

}
