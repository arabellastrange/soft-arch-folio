package model;

public interface IStock {

    public String getTicker();

    public String getName();

    public double getShares();

    public double getPricePerShare();

    public double getHoldingValue();

    public void buy(double shares);

    public void sell(double shares);

    public double netGainPercentage();

}
