package model;

import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;

import javax.naming.InvalidNameException;
import java.util.Observer;
import java.util.Set;

public interface IFolio {

    /**
     * @requires
     * @modifies this
     * @effects stocks' = stocks + new Stock();
     * @throws InvalidNameException, NegativeSharesException,  NoSuchTickerException, WebsiteDataException, NegativeSharesException
     */
    public boolean createStock(String ticker, String name, int shares) throws InvalidNameException, NegativeSharesException, NoSuchTickerException, WebsiteDataException, NegativeSharesException;

    /**
     *
     * @modifies this
     * @effects stocks' = stocks - stock
     */
    public void deleteStock(IStock stock);

    /**
     * @return set of stocks
     */
    public Set<IStock> getStocks();

    /**
     * @return folio value
     */
    public double getValue();

    /**
     *
     * @return folio name
     */
    public String getName();

    /**
     * @return stock where stock ticker equals ticker
     */
    public IStock getStockByTicker(String ticker);


    public void registerObserver(Observer o);

}
