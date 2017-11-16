package model;

import model.web.NoSuchTickerException;
import model.web.StrathQuoteServer;
import model.web.WebsiteDataException;

import java.io.Serializable;

class Stock implements IStock, Serializable {

    private String ticker;
    private String name;
    private double sharePrice;
    private double shares;
    private double totalCost;
    private double totalValueSold;

    Stock(Stock s) {
        this.ticker = s.ticker;
        this.name = s.name;
        this.sharePrice = s.sharePrice;
        this.shares = s.shares;
        this.totalCost = s.totalCost;
        this.totalValueSold = s.totalValueSold;
    }

    Stock(String ticker, String name, double shares) throws WebsiteDataException, NoSuchTickerException {
        this.ticker = ticker;
        this.name = name;
        this.shares = shares;
        totalCost = sharePrice * shares;
        totalValueSold = 0;
        refresh();
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
    public void buy(int amount) throws NegativeShares {
        if (amount <= 0) throw new NegativeShares();
        this.shares += amount;
        totalCost += amount * sharePrice;
    }

    @Override
    public void sell(double amount) throws NegativeShares {
        if (amount > shares || amount <= 0) throw new NegativeShares();
        this.shares -= amount;
        totalValueSold += amount * sharePrice;
    }

    @Override
    public double netGainPercentage() {
        return ((sharePrice * shares + totalValueSold) / totalCost) * 100;
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
