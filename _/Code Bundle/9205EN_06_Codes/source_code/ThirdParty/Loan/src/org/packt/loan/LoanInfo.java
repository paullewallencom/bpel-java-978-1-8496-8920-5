package org.packt.loan;

public class LoanInfo
{
    private double monthly;
    private double total;
    private double cost;

    public LoanInfo()
    {
        monthly = 0.0d;
        total = 0.0d;
        cost = 0.0d;
    }

    public void setMonthly(double monthly)
    {
        this.monthly = monthly;
    }

    public double getMonthly()
    {
        return monthly;
    }

    public void setTotal(double total)
    {
        this.total = total;
    }

    public double getTotal()
    {
        return total;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    public double getCost()
    {
        return cost;
    }

}
