package controller;

import model.IFolio;
import model.IFolioTracker;
import model.IStock;
import model.NegativeShares;
import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;

import javax.naming.InvalidNameException;

public class CreateController {
    private IFolioTracker f;
    private IFolio s;

    public void makeFolio( String name){
        f.createFolio(name);
    }

//    public String addStock(String ticker, String name, int nshares){
//        try {
//            s.createStock(ticker, name, nshares);
//            return "successfully added stock";
//        } catch (InvalidNameException e) {
//            return "Invalid name exception";
//        } catch (NegativeShares negativeShares) {
//            return "Negative shares exception";
//        } catch (NoSuchTickerException e) {
//            return "No such ticker exception";
//        } catch (WebsiteDataException e) {
//            return "the website died";
//        }
//    }

    public IStock getStock(){
        return null ;
    }

}
