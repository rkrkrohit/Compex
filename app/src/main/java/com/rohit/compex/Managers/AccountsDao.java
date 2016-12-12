package com.rohit.compex.Managers;

import com.rohit.compex.models.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rohik on 12/10/16.
 */
public class AccountsDao {

    private  List<Account> mAccountsList = new ArrayList<>();

    private static AccountsDao sAccountsDao;

    public static AccountsDao newInstance() {
        if(sAccountsDao != null) {
            return sAccountsDao;
        }
         return sAccountsDao = new AccountsDao();
    }

    public void addAccount(Account account) {
        mAccountsList.add(account);
    }

    public List<Account> getAccountsList() {
        return mAccountsList;
    }
}
