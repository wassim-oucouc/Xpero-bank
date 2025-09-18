package service;

import model.Account;
import repository.AccountRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account)
    {
       return this.accountRepository.createAccount(account);
    }

    public List<Account> getAllAccounts(UUID user_id)
    {
        return this.accountRepository.getAccounts(user_id);
    }
    public String closeAccount(String accountId)
    {
       BigDecimal soldeCheck =  this.accountRepository.GetBalanceAccountById(accountId);
        if(soldeCheck.compareTo(BigDecimal.ZERO) == 0)
        {
            this.accountRepository.closeAccount(accountId);
            return "account closed with success";
        }
        return "account is not equal zero";
    }







}
