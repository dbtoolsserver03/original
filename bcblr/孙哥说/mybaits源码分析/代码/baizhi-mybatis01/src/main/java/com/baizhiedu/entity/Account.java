package com.baizhiedu.entity;

import java.io.Serializable;

public class Account implements Serializable {
    private Integer id;
    private String accountNo;
    private double balance;

    public Account() {
        System.out.println("---------account----------");
    }

    public Account(Integer id, String accountNo, double balance) {
        this.id = id;
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNo='" + accountNo + '\'' +
                ", balance=" + balance +
                '}';
    }
}
