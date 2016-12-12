package com.rohit.compex.Managers;

import com.rohit.compex.models.Account;
import com.rohit.compex.models.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rohik on 12/10/16.
 */
public class TransactionDao {
    private List<Transaction> mTransactionList = new ArrayList<>();

    private static TransactionDao sTransactionDao;
    public static TransactionDao getTransactionDao() {
        if(sTransactionDao != null) return sTransactionDao;

        return sTransactionDao = new TransactionDao();
    }

    public void addTransaction(Transaction transaction) {
        mTransactionList.add(transaction);
    }

    public List<Transaction> getTransaction(Account account) {
        if(account == null) return mTransactionList;

        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction transaction:
             mTransactionList) {
            if(transaction.getMPrimaryAccount().equals(account) || transaction.getMSecondaryAccount().equals(account)) {
                transactionList.add(transaction);
            }
        }

        return transactionList;
    }
}
