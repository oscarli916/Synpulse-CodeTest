package com.example.demo.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController {

    Logger logger = LoggerFactory.getLogger(TransactionController.class);
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getTransactions(){
        logger.info("Getting transactions");
        return transactionService.getTransactions();
    }

    @GetMapping(path="{id}")
    public Transaction getTransaction(@PathVariable("id") UUID id){
        logger.info("Getting transaction");
        return transactionService.getTransaction(id);
    }

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public Transaction registerNewTransaction(@RequestBody Transaction transaction){
        logger.info("Adding transactions");
        return transactionService.addNewTransaction(transaction);
    }

    @PutMapping(path="{id}")
    public Transaction updateTransaction(@PathVariable("id") UUID id, @RequestBody Transaction transaction){
        logger.info("Updating transactions");
        return transactionService.updateTransaction(id, transaction);
    }

    @DeleteMapping(path="{id}")
    public Transaction deleteTransaction(@PathVariable("id") UUID id){
        logger.info("Deleting transactions");
        return transactionService.deleteTransaction(id);
    }
}
