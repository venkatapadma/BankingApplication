package com.finance.banking_app.service.impl;

import com.finance.banking_app.dto.AccountDto;
import com.finance.banking_app.dto.AccountRequestDto;
import com.finance.banking_app.entity.Account;
import com.finance.banking_app.exception.AccountNotFoundException;
import com.finance.banking_app.exception.InsufficientBalanceException;
import com.finance.banking_app.mapper.AccountMapper;
import com.finance.banking_app.repository.AccountRepository;
import com.finance.banking_app.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountRequestDto requestDto) {
        log.info("Creating account {}", requestDto);
        Account newAccount = AccountMapper.mapToAccount(requestDto);
        Account savedAccount = accountRepository.save(newAccount);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long Id) {
        log.info("Getting account by id {}", Id);
        Account account = accountRepository.findById(Id).orElseThrow(() -> new AccountNotFoundException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, Double amount) {
        log.info("Deposit request by id {}", id);
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account does not exist"));
        Double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, Double amount) {
        log.info("Withdraw request by id {}", id);
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account does not exist"));

        if (account.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient amount");
        }

        Double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        log.info("Getting all accounts");
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(AccountMapper::mapToAccountDto).collect(Collectors.toList());
    }

    @Override
    public void deleteAccountById(Long id) {
        log.info("Deleting account {}", id);
        accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account does not exist"));
        accountRepository.deleteById(id);
    }


}
