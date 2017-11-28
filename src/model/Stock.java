package model;

import model.web.NoSuchTickerException;
import model.web.StrathQuoteServer;
import model.web.WebsiteDataException;

import javax.naming.InvalidNameException;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

class Stock extends Observable implements IStock, Serializable {

    private String ticker;
    private String name;
    private double sharePrice;
    private double shares;
    private double totalCost;

    Stock(Stock s) {
        this.ticker = s.ticker;
        this.name = s.name;
        this.sharePrice = s.sharePrice;
        this.shares = s.shares;
        this.totalCost = s.totalCost;
    }

    Stock(String ticker, String name, double shares) throws WebsiteDataException, NoSuchTickerException {
        this.ticker = ticker;
        this.name = name;
        this.shares = shares;
        refresh();
        totalCost = sharePrice * shares;
    }

    void refresh() throws NoSuchTickerException, WebsiteDataException {
        String priceString;
        try {
            priceString = StrathQuoteServer.getLastValue(ticker);
            sharePrice = Double.parseDouble(priceString.trim());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getTicker() {
        return ticker;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getShares() {
        return shares;
    }

    @Override
    public double getPricePerShare() {
        return sharePrice;
    }

    @Override
    public double getHoldingValue() {
        return shares * sharePrice;
    }

    @Override
    public void buy(int amount) throws NegativeSharesException {
        if (amount <= 0) throw new NegativeSharesException();
        this.shares += amount;
        totalCost += amount * sharePrice;
        setChanged();
        notifyObservers();
    }

    @Override
    public void sell(double amount) throws NegativeSharesException {
        if (amount > shares || amount <= 0) throw new NegativeSharesException();
        this.shares -= amount;
        totalCost -= amount * sharePrice;
        setChanged();
        notifyObservers();
    }

    @Override
    public double lossProfit() {
        return totalCost - shares*sharePrice;
    }

    @Override
    public void setName(String name) throws InvalidNameException, EmptyNameException {
        if (name == null || name.isEmpty()) throw new InvalidNameException("name is empty or null");
        this.name = name;
        setChanged();
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        addObserver(o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        return ticker.equals(stock.ticker);
    }

    @Override
    public int hashCode() {
        return ticker.hashCode();
    }
}
