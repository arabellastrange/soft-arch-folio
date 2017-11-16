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
     * @throws model.web.NoSuchTickerException if ticker doesnt exist
     * @throws NumberFormatException if amount <= 0
     * @throws javax.naming.InvalidNameException name == "" || name == null
     * @effects stocks' == stock + {stock}
     * @return
     */
    public boolean createStock(String ticker, String name, int shares) throws InvalidNameException, NegativeShares, NoSuchTickerException, WebsiteDataException;

    public boolean deleteStock(IStock stock);

    public Set<IStock> getStocks();

    public double getValue();

}
