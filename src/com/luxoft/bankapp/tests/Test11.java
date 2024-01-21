package com.luxoft.bankapp.tests;

import com.luxoft.bankapp.domain.AbstractAccount;
import com.luxoft.bankapp.domain.AccountCache;
import com.luxoft.bankapp.domain.CheckingAccount;
import com.luxoft.bankapp.domain.SavingAccount;
import org.junit.Assert;
import org.junit.Test;

public class Test11 {
    @Test
    public void TestAccountCache_LoadCache() {
        AccountCache cache = new AccountCache();
        AbstractAccount checkingAccount = new CheckingAccount(2, 1000, 100);
        AbstractAccount savingAccount = new SavingAccount(3, 5000);
        cache.loadCache(checkingAccount);
        cache.loadCache(savingAccount);


        Assert.assertEquals(cache.getCacheMap().get("Checking").getType(), 2);
        Assert.assertEquals(cache.getCacheMap().get("Saving").getType(), 1);
    }

    @Test
    public void TestAccountCache_CloneSavingAccount() {
        AccountCache cache = new AccountCache();
        AbstractAccount checkingAccount = new CheckingAccount(2, 1000, 100);
        AbstractAccount savingAccount = new SavingAccount(3, 5000);
        cache.loadCache(checkingAccount);
        cache.loadCache(savingAccount);

        AbstractAccount newSavingAccount = cache.cloneAccount("Saving");
        AbstractAccount oldAccount = cache.getCacheMap().get("Saving");

        Assert.assertNotSame(oldAccount, newSavingAccount);
        Assert.assertEquals(oldAccount.getType(), newSavingAccount.getType());
        Assert.assertEquals(cache.getCacheMap().get("Saving").getId(), newSavingAccount.getId());
    }

    @Test
    public void TestAccountCache_CloneCheckingAccount() {
        AccountCache cache = new AccountCache();
        AbstractAccount checkingAccount = new CheckingAccount(2, 1000, 100);
        AbstractAccount savingAccount = new SavingAccount(3, 5000);
        cache.loadCache(checkingAccount);
        cache.loadCache(savingAccount);

        AbstractAccount newCheckingAccount = cache.cloneAccount("Checking");
        AbstractAccount oldAccount = cache.getCacheMap().get("Checking");

        Assert.assertNotSame(oldAccount, newCheckingAccount);
        Assert.assertEquals(oldAccount.getType(), newCheckingAccount.getType());
        Assert.assertEquals(cache.getCacheMap().get("Checking").getId(), newCheckingAccount.getId());
    }

    @Test
    public void TestAccountCache_InvalidAccountType() {
        AccountCache cache = new AccountCache();
        AbstractAccount newAccount = cache.cloneAccount("Invalid");

        Assert.assertNull(newAccount);
    }
}
