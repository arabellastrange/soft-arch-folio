package model;

import java.util.Set;

public interface IFolio {

    public void createStock(String ticker, String name, double amount);

    public void deleteStock(String ticker);

    public Set<String> getTickers();

    public IStock getStockByTicker(String ticker);

    public double getValue();

}
