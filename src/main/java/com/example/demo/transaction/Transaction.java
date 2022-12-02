package com.example.demo.transaction;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table
public class Transaction {
    @Id
    private UUID id = UUID.randomUUID();
    private float amount;
    private String currency;
    private String iban;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;
    private String description;

    public Transaction() {
    }

    public Transaction(UUID id, float amount, String currency, String iban, LocalDate date, String description) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.iban = iban;
        this.date = date;
        this.description = description;
    }

    public Transaction(float amount, String currency, String iban, LocalDate date, String description) {
        this.amount = amount;
        this.currency = currency;
        this.iban = iban;
        this.date = date;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", iban='" + iban + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
