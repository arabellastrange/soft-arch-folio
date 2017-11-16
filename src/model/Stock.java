package model;

import model.web.NoSuchTickerException;
import model.web.StrathQuoteServer;
import model.web.WebsiteDataException;

class Stock implements IStock {

    private String ticker;
    private String name;
    private double sharePrice;
    private double shares;
    private double totalCost;
    private double totalValueSold;

    Stock(String ticker, String name, double shares) {
        this.ticker = ticker;
        this.name = name;
        this.shares = shares;
        totalCost = sharePrice * shares;
        totalValueSold = 0;
        refresh();
    }

    boolean refresh() {
        String priceString;
        try {
            priceString = StrathQuoteServer.getLastValue(ticker);
            sharePrice = Double.parseDouble(priceString.trim());
        } catch (WebsiteDataException | NoSuchTickerException | NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return true;
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
    public void buy(double amount) {
        this.shares += amount;
        totalCost += amount * sharePrice;
    }

    @Override
    public void sell(double amount) {
        this.shares -= amount;
        totalValueSold += amount * sharePrice;
    }

    @Override
    public double netGainPercentage() {
        return ((sharePrice * shares + totalValueSold) / totalCost) * 100;
    }

}
