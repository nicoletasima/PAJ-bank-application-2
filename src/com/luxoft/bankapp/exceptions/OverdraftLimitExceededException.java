package com.luxoft.bankapp.exceptions;

public class OverdraftLimitExceededException extends NotEnoughFundsException {
	
	private static final long serialVersionUID = -3737648528527468343L;
	private double overdraft;

	public OverdraftLimitExceededException(NotEnoughFundsException e, double overdraft) {
		super(e.getId(), e.getBalance(), Math.round(e.getAmount() * 100) / 100d, e.getMessage());
		// this.id = e.getId();
	    // this.balance = e.balance;
	    // this.amount = Math.round(amount * 100) / 100d;
        this.overdraft = overdraft;
    }
	
	public double getOverdraft() {
		return overdraft;
	}

}
