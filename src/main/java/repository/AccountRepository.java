package repository;

import model.Account;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface AccountRepository {

    public Account createAccount(Account account);
    public List<Account> getAccounts(UUID user_id);
    public void addMoney(String account_id, BigDecimal amount);
    public void closeAccount(String account_id);
    public BigDecimal GetBalanceAccountById(String account_id);


}
