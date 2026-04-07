package com.finance.banking_app.service.impl;

import com.finance.banking_app.dto.AccountDto;
import com.finance.banking_app.entity.Account;
import com.finance.banking_app.exception.AccountNotFoundException;
import com.finance.banking_app.exception.InsufficientBalanceException;
import com.finance.banking_app.mapper.AccountMapper;
import com.finance.banking_app.repository.AccountRepository;
import com.finance.banking_app.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account newAccount = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(newAccount);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long Id) {
        Account account = accountRepository.findById(Id).orElseThrow(()->new AccountNotFoundException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, Double amount) {

        Account account = accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException("Account does not exist"));
        Double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, Double amount) {

        Account account = accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException("Account does not exist"));

        if(account.getBalance() < amount){
            throw new InsufficientBalanceException("Insufficient amount");
        }

        Double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(AccountMapper::mapToAccountDto).collect(Collectors.toList());
    }

    @Override
    public void deleteAccountById(Long id) {
        accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account does not exist"));
        accountRepository.deleteById(id);
    }


}
