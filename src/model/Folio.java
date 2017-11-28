package model;

import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;

import javax.naming.InvalidNameException;
import javax.swing.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.stream.Collectors;

class Folio extends Observable implements IFolio, Serializable {

    private String name;
    private Set<Stock> stocks;

    Folio(String name) {
        this.name = name;
        stocks = new HashSet<>();
    }

    Folio(Folio f) {
        name = f.name;
        stocks = f.stocks
                .stream()
                .map(stock -> new Stock(stock))
                .collect(Collectors.toSet());
    }

    void refresh() throws WebsiteDataException, NoSuchTickerException {
        for (Stock s : stocks) {
            s.refresh();
        }
    }

    @Override
    public boolean createStock(String ticker, String name, int shares) throws InvalidNameException, NoSuchTickerException, WebsiteDataException, NegativeSharesException {
       name = name.trim();
        if (name == null || name.isEmpty()) throw new InvalidNameException("name is empty or null");
        if (shares <= 0) throw new NegativeSharesException();
        for(Stock stock: stocks)
            if(stock.getTicker().equals(ticker)){
                stock.buy(shares);
                setChanged();
                notifyObservers();
                return true;
            }
        Stock s = new Stock(ticker, name, shares);
        boolean result = stocks.add(s);
        if (!result) return false;
        setChanged();
        notifyObservers();
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Folio folio = (Folio) o;

        return name.equals(folio.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public void deleteStock(IStock stock) {
        stocks.remove(stock);
        setChanged();
        notifyObservers();
    }

    @Override
    public Set<IStock> getStocks() {
        return stocks
                .stream()
                .collect(Collectors.toSet());
    }

    @Override
    public double getValue() {
        int value = 0;
        for (Stock stock : stocks)
            value += stock.getHoldingValue();
        return value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IStock getStockByTicker(String ticker) {
        for (IStock s : stocks)
            if (s.getTicker().equals(ticker)) return s;
        //fixme
        return null;
    }



    @Override
    public void registerObserver(Observer o) {
        addObserver(o);
    }

}
