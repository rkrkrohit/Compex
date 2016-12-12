package com.rohit.compex.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.rohit.compex.Activities.CompexHomeActivity;
import com.rohit.compex.Managers.AccountsDao;
import com.rohit.compex.Managers.TransactionDao;
import com.rohit.compex.R;
import com.rohit.compex.models.Account;
import com.rohit.compex.models.Transaction;

import org.joda.money.Money;

import java.math.BigDecimal;

/**
 * Created by rohik on 12/11/16.
 */
public class CreateTransactionFragment extends Fragment {

    private EditText mTransactionType;
    private EditText mAmount;
    private Spinner mAccount;
    private Button mSubmitButton;

    public static Fragment newInstance() {
        return new CreateTransactionFragment();
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_transaction, container, false);

        initializeViews(view);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Transaction newTransaction = new Transaction();
                Account transactionAccount = (Account) mAccount.getSelectedItem();

                newTransaction.setMPrimaryAccount(transactionAccount);
                newTransaction.setMTransactionType(mTransactionType.getText().toString());
                newTransaction.setMAmount(Money.of(transactionAccount.getMCurrencyUnit(), new BigDecimal(mAmount.getText().toString())));
                TransactionDao.getTransactionDao().addTransaction(newTransaction);
                startActivity(CompexHomeActivity.getCompexHomeActivityIntent(getActivity()));
            }
        });

        return view;
    }

    private void initializeViews(View view) {
        mTransactionType = (EditText) view.findViewById(R.id.transaction_type);
        mAmount = (EditText) view.findViewById(R.id.transaction_amount);
        mAccount = (Spinner) view.findViewById(R.id.transaction_account);
        mSubmitButton = (Button) view.findViewById(R.id.transaction_create_submit);

        ArrayAdapter<Account> accountListDropdownAdapter = new ArrayAdapter<Account>(
                getActivity(),
                android.support.v7.appcompat.R.layout.support_simple_spinner_dropdown_item,
                AccountsDao.newInstance().getAccountsList());
        mAccount.setAdapter(accountListDropdownAdapter);
    }
}
