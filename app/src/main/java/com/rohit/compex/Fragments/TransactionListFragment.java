package com.rohit.compex.Fragments;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rohit.compex.Managers.TransactionDao;
import com.rohit.compex.R;
import com.rohit.compex.models.Transaction;

import java.util.List;

/**
 * Created by rohik on 12/11/16.
 */
public class TransactionListFragment extends RecyclerListFragment<Transaction> {

    public static Fragment newInstance() {
        return new TransactionListFragment();
    }

    @Override
    public List<Transaction> getListData() {
        return TransactionDao.getTransactionDao().getTransaction(null);
    }

    @Override
    public RecyclerListViewHolder<Transaction> getViewHolder(final ViewGroup parent, final int viewType) {
        return new TransactionListViewHolder(parent);
    }

    private class TransactionListViewHolder extends RecyclerListViewHolder<Transaction> {

        private TextView mTransactionAmount;
        private TextView mTransactionAccount;

        public TransactionListViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(getActivity()).inflate(R.layout.list_transaction, parent, false));
        }

        @Override
        public void initializeViews(final View view) {
            mTransactionAmount = (TextView) view.findViewById(R.id.list_transaction_amount);
            mTransactionAccount = (TextView) view.findViewById(R.id.list_transaction_account);
        }

        @Override
        public void bind(final Transaction dataObject) {
            mTransactionAmount.setText(dataObject.getMAmount().toString());
            mTransactionAccount.setText(dataObject.getMPrimaryAccount().getMAccountName());
        }
    }
}
