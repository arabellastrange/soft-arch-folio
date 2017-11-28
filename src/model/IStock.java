package model;

import javax.naming.InvalidNameException;
import java.util.Observer;

public interface IStock {

    /**
     * @return
     */
    public String getTicker();

    /**
     * @return
     */
    public String getName();

    /**
     * @return
     */
    public double getShares();

    /**
     * @return
     */
    public double getPricePerShare();

    /**
     * @return
     */
    public double getHoldingValue();

    /**
     * @param shares
     * @require shares > 0
     * @modifies this
     * @effects this.shares' = this.shares + shares
     * totalcost' = totalcost + shares * pricePerShare
     */
    public void buy(int shares) throws NegativeSharesException;

    /**
     * @param shares
     * @require shares > 0 && shares <= this.shares
     * @modifies this
     * @effects this.shares' = this.shares - shares
     * totalValueSold' = totalValuesSold + shares * pricePerShare
     */
    public void sell(double shares) throws NegativeSharesException;


    /**
     * @return gain/loss percentage
     */
    public double lossProfit();

    /**
     *
     * @param name
     * @throws InvalidNameException
     */
    public void setName(String name) throws InvalidNameException, EmptyNameException;

    public void registerObserver(Observer o);
}
