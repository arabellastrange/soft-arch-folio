package model;

import java.util.HashSet;
import java.util.Set;

class Folio implements IFolio {

    private String name;
    private Set<Stock> stocks;
    private double value;

    Folio(String name) {
        this.name = name;
        value = 0;
    }

    String getName() {
        return name;
    }

    void refresh() {
        stocks.forEach(stock -> stock.refresh());
    }

    @Override
    public void createStock(String ticker, String name, double amount) {
        stocks.add(new Stock(ticker, name, amount));
    }

    @Override
    public void deleteStock(String ticker) {
        for (Stock stock : stocks) {
            if (stock.getName().equals(ticker))
                stocks.remove(stock);
        }
    }

    @Override
    public Set<String> getTickers() {
        Set<String> tickers = new HashSet<>();
        for (Stock stock : stocks)
            tickers.add(stock.getName());
        return tickers;
    }

    @Override
    public IStock getStockByTicker(String ticker) {
        //Does Stock in for loop need to be IStock?
        for (Stock stock : stocks) {
            if (stock.getName().equals(ticker))
                return stock;
        }
        return null;
    }

    @Override
    public double getValue() {
        int value = 0;
        for (Stock stock : stocks)
            value += stock.getHoldingValue();
        return value;
    }

}
