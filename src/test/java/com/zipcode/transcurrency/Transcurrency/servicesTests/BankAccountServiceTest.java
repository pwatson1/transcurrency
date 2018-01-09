package com.zipcode.transcurrency.Transcurrency.servicesTests;

import com.zipcode.transcurrency.Transcurrency.models.BankAccount;
import com.zipcode.transcurrency.Transcurrency.repositories.BankAccountRepository;
import com.zipcode.transcurrency.Transcurrency.services.BankAccountService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BankAccountServiceTest {

    private BankAccountService service;

    @Mock
    private BankAccountRepository bankAccountRepository;

    @InjectMocks
    private BankAccountService bankAccountService;



    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        bankAccountService = new BankAccountService(bankAccountRepository);
    }

    @Test
    public void getAllBankAccountsTest() {
        //Given:
        BankAccount bankAccount1 = new BankAccount;
        List<BankAccount> bankAccountList = new ArrayList<>();
        bankAccountList.add(bankAccount1);

        //When:
        when(bankAccountService.getAllBankAccounts()).thenReturn(bankAccountList);

        //Then:
        assertEquals(bankAccountList.size(), 1);
    }

    @Test
    public void updateBankAccountTest() {
        //Given:

        //When:

        //Then:
    }

    @Test
    public void deleteBankAccountTest() {
        //Given:

        //When:

        //Then:
    }


}
