package com.luxoft.bankapp.exceptions;

public class NotEnoughFundsException extends BankException {

	// task3 - changed fields id, balance, amount from public to private
	private static final long serialVersionUID = -3034651278778929257L;
	private int id;
	private double balance;
	private double amount;
	
	public NotEnoughFundsException(String message) {
		 super(message);
	}
	
	public NotEnoughFundsException(int id, double balance, double amount, String message) {
        super(message);
        this.id = id;
        this.balance = balance;
        this.amount = Math.round(amount * 100) / 100d;
    }
    
    public int getId() {
		return id;
	}
    
    public double getBalance() {
		return balance;
	}

    public double getAmount() {
        return amount;
    }

}
