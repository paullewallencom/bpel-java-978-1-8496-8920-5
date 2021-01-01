package org.packt.loan;


public class LoanCalc
{

    public LoanCalc()
    {
    }

    public LoanInfo calculateLoan(long principal, double interest, int months)
    {
        int N = months;
        double intMonth = 0.0d;
        double S = 0.0d;
        double monthlyPay = 0.0d;
        double totalPay = 0.0d;
        double loanCost = 0.0d;
        
        LoanInfo result = new LoanInfo();
        intMonth = interest / 1200d;
        S = Math.pow(1.0d + intMonth, months);
        
        monthlyPay = (double)Math.round((((double)principal * (intMonth * S)) / (S - 1.0d)) * 100d) / 100D;
        totalPay = monthlyPay * (double)N;
        loanCost = totalPay - (double)principal;
        
        result.setMonthly(monthlyPay);
        result.setTotal(totalPay);
        result.setCost(loanCost);
        
        return result;
    }
}
