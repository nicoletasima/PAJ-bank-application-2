package com.luxoft.bankapp.domain;

import java.util.HashMap;
import java.util.Map;

public class AccountCache {
    private final Map<String, AbstractAccount> cacheMap;

    public AccountCache() {
        cacheMap = new HashMap<>();
        cacheMap.put("Checking", AccountFactory.newAccount("Checking"));
        cacheMap.put("Saving", AccountFactory.newAccount("Saving"));
    }

    public void loadCache(AbstractAccount abstractAccount) {
        if (abstractAccount instanceof CheckingAccount) {
            cacheMap.put("Checking", abstractAccount);
        }

        if (abstractAccount instanceof SavingAccount) {
            cacheMap.put("Saving", abstractAccount);
        }
    }

    public AbstractAccount cloneAccount(String accountType) {
        if (accountType.equalsIgnoreCase("Checking")) {
            return cacheMap.get("Checking").clone();
        }

        if (accountType.equalsIgnoreCase("Saving")) {
            return cacheMap.get("Saving").clone();
        }

        return null;
    }

    public Map<String, AbstractAccount> getCacheMap() {
        return cacheMap;
    }
}
