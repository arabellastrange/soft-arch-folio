package model;

import java.util.Set;

class Folio implements IFolio {

    private String name;
    private Set<Stock> stocks;
    private double value;

    @Override
    public void createStock(String ticker, String name, double amount) {

    }

    @Override
    public void deleteStock(String ticker) {

    }

    @Override
    public Set<String> getTickers() {
        return null;
    }

    @Override
    public IStock getStockByTicker(String ticker) {
        return null;
    }

    @Override
    public double getValue() {
        return 0;
    }
}
