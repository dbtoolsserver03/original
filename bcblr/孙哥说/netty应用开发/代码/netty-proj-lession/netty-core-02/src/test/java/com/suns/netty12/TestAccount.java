package com.suns.netty12;

public class TestAccount {
    public static void main(String[] args) {
        Account account = new Account();
        //com.suns.netty12.Account@4517d9a3
        System.out.println("account = " + account);
        System.out.println("account.hashCode() = " + Integer.toHexString(account.hashCode()));
    }
}
