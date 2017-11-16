package model;

public interface IStock {

    public String getTicker();

    public String getName();

    public double getShares();

    public double getPricePerShare();

    public double getHoldingValue();

    /**
     * @require shares > 0
     * @modifies this
     * @param shares
     * @effects this.shares' = this.shares + shares
     *          totalcost' = totalcost + shares * pricePerShare
     */
    public void buy(int shares);

    /**
     * @require shares > 0 && shares <= this.shares
     * @modifies this
     * @param shares
     * @effects this.shares' = this.shares - shares
     *          totalValueSold' = totalValuesSold + shares * pricePerShare
     */
    public void sell(double shares);


    /**
     * @return gain/loss percentage
     */
    public double netGainPercentage();

}
