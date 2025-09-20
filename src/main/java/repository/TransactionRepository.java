package repository;

import model.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository {

    public List<Transaction> getAllTransactions(UUID user_id);
    public Transaction createTransaction(Transaction transaction);

}
