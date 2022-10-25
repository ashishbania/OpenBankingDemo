package com.example.demo.OpenBankingDemo.accounts;

import javax.persistence.*;

@Entity
@Table
public class Accounts {
    @Id
    @SequenceGenerator(name = "accounts_sequence",sequenceName = "accounts_sequence", allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accounts_sequence")
    @Column
    private Integer accountId;
    @Column
    private String status;
    @Column
    private String statusUpdateDateTime;
    @Column
    private String currency;
    @Column
    private String accountType;
    @Column
    private String openingDate;

    public Accounts() {
    }

    public Accounts(String status, String statusUpdateDateTime, String currency, String accountType, String openingDate) {
        this.status = status;
        this.statusUpdateDateTime = statusUpdateDateTime;
        this.currency = currency;
        this.accountType = accountType;
        this.openingDate = openingDate;
    }

    public Accounts(Integer accountId, String status, String statusUpdateDateTime, String currency, String accountType, String openingDate) {
        this.accountId = accountId;
        this.status = status;
        this.statusUpdateDateTime = statusUpdateDateTime;
        this.currency = currency;
        this.accountType = accountType;
        this.openingDate = openingDate;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusUpdateDateTime() {
        return statusUpdateDateTime;
    }

    public void setStatusUpdateDateTime(String statusUpdateDateTime) {
        this.statusUpdateDateTime = statusUpdateDateTime;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "accountId=" + accountId +
                ", status='" + status + '\'' +
                ", statusUpdateDateTime=" + statusUpdateDateTime +
                ", currency=" + currency +
                ", accountType='" + accountType + '\'' +
                ", openingDate=" + openingDate +
                '}';
    }
}
