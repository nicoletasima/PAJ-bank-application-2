package com.luxoft.bankapp.tests;

import com.luxoft.bankapp.domain.AbstractAccount;
import com.luxoft.bankapp.domain.AccountFactory;
import com.luxoft.bankapp.domain.CheckingAccount;
import com.luxoft.bankapp.domain.SavingAccount;
import org.junit.Test;

import com.luxoft.bankapp.employees.AbstractSpecialist;
import com.luxoft.bankapp.employees.FinancialSpecialist;
import com.luxoft.bankapp.employees.HousingPropertySpecialist;

import static org.junit.Assert.*;

public class Test10 {

    @Test
    public void testAccountFactory_WhenAccountTypeIsNull_ThenReturnNull() {
        AbstractAccount accountFactory = AccountFactory.newAccount(null);

        assertNull(accountFactory);
    }

    @Test
    public void testAccountFactory_WhenAccountTypeIsChecking_ThenReturnCheckingAccount() {
        AbstractAccount accountFactory = AccountFactory.newAccount("Checking");

        assertTrue(accountFactory instanceof CheckingAccount);
    }

    @Test
    public void testAccountFactory_WhenAccountTypeIsSaving_ThenReturnSavingAccount() {
        AbstractAccount accountFactory = AccountFactory.newAccount("Saving");

        assertTrue(accountFactory instanceof SavingAccount);
    }

    @Test
    public void testAccountFactory_WhenInvalidAccountType_ThenReturnNull() {
        AbstractAccount accountFactory = AccountFactory.newAccount("Invalid");

        assertNull(accountFactory);
    }

}
