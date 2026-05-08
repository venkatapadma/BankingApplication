package com.finance.banking_app.service;

import com.finance.banking_app.dto.AccountDto;
import com.finance.banking_app.dto.AccountRequestDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountRequestDto account);

    AccountDto getAccountById(Long Id);

    AccountDto deposit(Long id, Double amount);

    AccountDto withdraw(Long id, Double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccountById(Long id);
}
