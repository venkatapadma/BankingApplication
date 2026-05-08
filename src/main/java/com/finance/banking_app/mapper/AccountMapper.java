package com.finance.banking_app.mapper;

import com.finance.banking_app.dto.AccountDto;
import com.finance.banking_app.dto.AccountRequestDto;
import com.finance.banking_app.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountRequestDto requestDto) {
        Account account = new Account();
        account.setAccountHolderName(requestDto.accountHolderName());
        account.setBalance(requestDto.balance());
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
