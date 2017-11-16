package model;

import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;

import javax.naming.InvalidNameException;
import java.util.Set;

public interface IFolio {

    /**
     * @param ticker
     * @param name
     * @param shares
     * @return
     * @throws InvalidNameException
     * @throws NegativeShares
     * @throws NoSuchTickerException
     * @throws WebsiteDataException
     */
    public boolean createStock(String ticker, String name, int shares) throws InvalidNameException, NegativeShares, NoSuchTickerException, WebsiteDataException;

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

}
