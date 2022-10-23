package com.example.demo.OpenBankingDemo.balances;

import javax.persistence.*;

@Entity
@Table
public class Balances {
    @Id
    @SequenceGenerator(name = "accounts_sequence", sequenceName = "transactions_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactions_sequence")
    @Column
    private Integer transactionId;
    @Column
    private Integer accountId;
    @Column
    private String cardNumber;
    @Column
    private String amount;
    @Column
    private String currency;
    @Column
    private String creditDebitIndicator;
    private String status;
    @Column
    private String transactionDate;
    @Column
    private String transactionInformation;

    public Balances() {
    }

    public Balances(Integer transactionId, Integer accountId, String cardNumber, String amount, String currency, String creditDebitIndicator, String status, String transactionDate, String transactionInformation) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.currency = currency;
        this.creditDebitIndicator = creditDebitIndicator;
        this.status = status;
        this.transactionDate = transactionDate;
        this.transactionInformation = transactionInformation;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCreditDebitIndicator() {
        return creditDebitIndicator;
    }

    public void setCreditDebitIndicator(String creditDebitIndicator) {
        this.creditDebitIndicator = creditDebitIndicator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionInformation() {
        return transactionInformation;
    }

    public void setTransactionInformation(String transactionInformation) {
        this.transactionInformation = transactionInformation;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "transactionId=" + transactionId +
                ", accountId=" + accountId +
                ", cardNumber='" + cardNumber + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                ", creditDebitIndicator='" + creditDebitIndicator + '\'' +
                ", status='" + status + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                ", transactionInformation='" + transactionInformation + '\'' +
                '}';
    }

}
