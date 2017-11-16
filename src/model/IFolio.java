package model;

import java.util.Set;

public interface IFolio {

    /**
     * @param ticker
     * @param name
     * @param amount
     * @throws model.web.NoSuchTickerException if ticker doesnt exist
     * @throws NumberFormatException if amount <= 0
     * @throws javax.naming.InvalidNameException name == "" || name == null
     * @effects
     */
    public void createStock(String ticker, String name, int amount);

    public void deleteStock(IStock stock);

    public Set<IStock> getStocks();

    public double getValue();

}
