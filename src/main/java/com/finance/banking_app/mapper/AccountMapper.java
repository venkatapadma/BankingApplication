package com.finance.banking_app.mapper;

import com.finance.banking_app.dto.AccountDto;
import com.finance.banking_app.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto) {
        Account account = new Account();
        account.setAccountHolderName(accountDto.accountHolderName());
        account.setBalance(accountDto.balance());
        return account;
    }

    public static AccountDto mapToAccountDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
    }
}
