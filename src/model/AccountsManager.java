package oop.model;

import model.Account;
import model.Tariff;

public class AccountsManager {
    private Account[] accounts;
    private int size;

    public AccountsManager(int size) {
        this.size = size;
        accounts = new Account[size];
    }

    public AccountsManager(Account[] accounts) {
        size = accounts.length;
        this.accounts = accounts;
    }

    public boolean add(Account account) {
        for (int i = 0; i < size && accounts[i] == null; i++) {
            accounts[i] = account;
            return true;
        }

        return false;
    }

    public boolean add(int index, Account account) {
        if (index < size && accounts[index] == null) {
            accounts[index] = account;
            return true;
        }

        return false;
    }

    public Account get(int index) {
        if (index < size) {
            return accounts[index];
        }

        return null;
    }

    public Account set(int index, Account account) {
        if (index < size) {
            accounts[index] = account;
            return accounts[index];
        }

        return null;
    }

    public Account remove(int index) {
        if (index < size) {
            Account account = accounts[index];
            Account[] temp = new Account[size - 1];
            System.arraycopy(accounts, 0, temp, 0, index);

            if (index != accounts.length - 1)
                System.arraycopy(accounts, index+1, temp, index, accounts.length-index-1);

            size--;
            accounts = temp;
            return account;
        }

        return null;
    }

    public int size() {
        return size;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public Tariff getTariff(long accountNumber) {
        for (Account account : accounts) {
            if (account != null && account.getNumber() == accountNumber) {
                return account.getTariff();
            }
        }

        return null;
    }

    public Tariff setTariff(long accountNumber, Tariff tariff) {
        for (Account account : accounts) {
            if (account != null && account.getNumber() == accountNumber) {
                account.setTariff(tariff);
                return account.getTariff();
            }
        }

        return null;
    }

}
