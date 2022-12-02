package com.example.demo.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    Logger logger = LoggerFactory.getLogger(TransactionService.class);

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getTransactions(){
        return transactionRepository.findAll();
    }

    public Transaction getTransaction(UUID id) {
        return transactionRepository.findById(id).orElseThrow(() -> new IllegalStateException("transaction id: " + id + " does not exists"));
    }

    public Transaction addNewTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
        return transaction;
    }

    public Transaction updateTransaction(UUID id, Transaction transaction) {
        Transaction existingTransaction = transactionRepository.findById(id).orElseThrow(() -> new IllegalStateException("transaction id: " + id + " does not exists"));
        existingTransaction.setAmount(transaction.getAmount());
        existingTransaction.setCurrency(transaction.getCurrency());
        existingTransaction.setIban(transaction.getIban());
        existingTransaction.setDate(transaction.getDate());
        existingTransaction.setDescription(transaction.getDescription());
        transactionRepository.save(existingTransaction);
        return existingTransaction;
    }

    public Transaction deleteTransaction(UUID id) {
        boolean exists = transactionRepository.existsById(id);
        if (!exists){
            logger.error("transaction id: " + id + " does not exists");
            throw new IllegalStateException("transaction id: " + id + " does not exists");
        }
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new IllegalStateException("transaction id: " + id + " does not exists"));
        transactionRepository.deleteById(id);
        return transaction;
    }
}
