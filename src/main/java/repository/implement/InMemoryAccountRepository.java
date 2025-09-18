package repository.implement;

import model.Account;
import repository.AccountRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class InMemoryAccountRepository  implements AccountRepository {

    List<Account> accounts = new ArrayList<>();

    private BigDecimal soldeCheck;


    public Account createAccount(Account account) {
        this.accounts.add(account);
        return account;
    }

    public List<Account> getAccounts(UUID user_id) {
        return this.accounts.stream().filter(a -> a.getOwnerUserId() == user_id).toList();

    }

    public void addMoney(String account_id, BigDecimal amount) {
        for (Account account : accounts) {
            if (account.getAccountId() == account_id) {
                account.setBalance(amount);
            }
        }
    }

    public void closeAccount(String account_id) {
        for (Account account : accounts) {
            if (Objects.equals(account.getAccountId(), account_id)) {
                account.setActive(false);
            }
        }
    }

    public BigDecimal GetBalanceAccountById(String account_id) {
        for (Account account : accounts) {
            if (Objects.equals(account.getAccountId(), account_id)) {
               this.soldeCheck =  account.getBalance();
            }
        }
        return this.soldeCheck;
    }
}
