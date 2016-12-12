package com.rohit.compex.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rohit.compex.Activities.TransactionListActivity;
import com.rohit.compex.Managers.AccountsDao;
import com.rohit.compex.R;
import com.rohit.compex.models.Account;

import java.util.List;

/**
 * Created by rohik on 12/11/16.
 */
public class AccountListFragment extends RecyclerListFragment<Account> {


    public static Fragment newInstance() {
        return new AccountListFragment();
    }

    @Override
    public List<Account> getListData() {
        return AccountsDao.newInstance().getAccountsList();
    }

    @Override
    public RecyclerListViewHolder<Account> getViewHolder(final ViewGroup parent, final int viewType) {
        return new AccountListViewHolder(parent);
    }

    private class AccountListViewHolder extends RecyclerListViewHolder<Account>  implements View.OnClickListener{

        private TextView mAccountName;

        public AccountListViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(getActivity()).inflate(R.layout.list_account, parent, false));
            itemView.setOnClickListener(this);
        }

        @Override
        public void initializeViews(final View view) {
            mAccountName = (TextView) itemView.findViewById(R.id.list_account_name);
        }

        @Override
        public void bind(final Account dataObject) {
            mAccountName.setText(dataObject.getMAccountName());
        }

        @Override
        public void onClick(final View view) {
            startActivity(TransactionListActivity.getIntent(getActivity()));
        }
    }
}
