package com.example.stipend;

public class Loan {

    private static Loan instance;
    private double amountPayableBalance;

    private Loan() {
        this.amountPayableBalance = 0;
    }
    public static Loan getInstance() {
        if (instance == null) {
            instance = new Loan();
        }
        return instance;
    }

    public boolean getLoanAvailability() {
        return !(this.amountPayableBalance > 0);
    }
    public void setLoan(boolean available) {
        if (available) {
            this.amountPayableBalance = 50000.00;
        }
    }

    public boolean payBalanceAvailability(double amount) {
        if (this.amountPayableBalance == 0) {
            return false;
        } else if (amount > this.amountPayableBalance) {
            return false;
        } else {
            return true;
        }
    }

    public void payBalance(double amount) {
        if (payBalanceAvailability(amount)) {
            this.amountPayableBalance -= amount;
        }
    }

    public double showBalance() {
       return this.amountPayableBalance;
    }
}
