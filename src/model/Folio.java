package model;

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
    public void createStock(String ticker, String name, int amount) {
        stocks.add(new Stock(ticker, name, amount));
    }

    @Override
    public void deleteStock(IStock stock) {
        stocks.remove(stock);
    }

    @Override
    public Set<IStock> getStocks() {
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
