package service;

import model.Transaction;
import repository.TransactionRepository;

import java.util.List;
import java.util.UUID;

public class TransactionService {

    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    public List<Transaction> getAllTransactionsByUser(UUID user_id)
    {
        return this.transactionRepository.getAllTransactions(user_id);
    }
}
