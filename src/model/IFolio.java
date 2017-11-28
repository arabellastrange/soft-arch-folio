package model;

import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;

import javax.naming.InvalidNameException;
import java.util.Observer;
import java.util.Set;

public interface IFolio {

    /**
     * @param ticker
     * @param name
     * @param shares
     * @return
     * @throws InvalidNameException
     * @throws NegativeSharesException
     * @throws NoSuchTickerException
     * @throws WebsiteDataException
     */
    public boolean createStock(String ticker, String name, int shares) throws InvalidNameException, NegativeSharesException, NoSuchTickerException, WebsiteDataException, NegativeSharesException;

    /**
     * @param stock
     * @return
     */
    public boolean deleteStock(IStock stock);

    /**
     * @return
     */
    public Set<IStock> getStocks();

    /**
     * @return
     */
    public double getValue();

    /**
     *
     * @return
     */
    public String getName();

    public IStock getStockByTicker(String ticker);


    public void registerObserver(Observer o);

}
