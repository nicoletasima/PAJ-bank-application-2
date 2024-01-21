package com.luxoft.bankapp.domain;

public class AccountFactory {
    public static AbstractAccount newAccount(String accountType) {
        if (accountType == null) {
            return null;
        }

        return switch (accountType.toUpperCase()) {
            case "CHECKING" -> new CheckingAccount(-1, 0.0, 0.0);
            case "SAVING" -> new SavingAccount(-1, 0.0);
            default -> null;
        };
    }
}
