package repository.implement;

import model.Transaction;
import repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InMemoryTransactionRepository implements TransactionRepository {

    List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> getAllTransactions(UUID user_id)
    {
       return  transactions.stream().filter(t -> t.getUser_id() == user_id).toList();
    }

    public Transaction createTransaction(Transaction transaction)
    {
        this.transactions.add(transaction);
        return transaction;
    }
}
