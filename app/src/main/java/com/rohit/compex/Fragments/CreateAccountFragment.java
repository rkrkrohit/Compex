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
import com.rohit.compex.R;
import com.rohit.compex.models.Account;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.BigDecimal;

/**
 * Created by rohik on 12/10/16.
 */
public class CreateAccountFragment extends Fragment {

    private EditText mAccountName;
    private Spinner mCurrency;
    private EditText mInitialBalance;
    private Button mSubmitButton;

    public static Fragment newInstance() {
        return new CreateAccountFragment();
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_account, container, false);

        initializeViews(view);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Account newAccount = new Account();
                newAccount.setMAccountName(mAccountName.getText().toString());
                newAccount.setMCurrencyUnit((CurrencyUnit) mCurrency.getSelectedItem());
                newAccount.setMInitialAmount(Money.of(newAccount.getMCurrencyUnit(), new BigDecimal(mInitialBalance.getText().toString())));
                AccountsDao.newInstance().addAccount(newAccount);

                startActivity(CompexHomeActivity.getCompexHomeActivityIntent(getActivity()));
            }
        });
        return view;
    }

    private void initializeViews(View view) {
        mAccountName = (EditText) view.findViewById(R.id.account_name);
        mCurrency = (Spinner) view.findViewById(R.id.account_currency);
        mInitialBalance = (EditText) view.findViewById(R.id.initial_balance);
        mSubmitButton = (Button) view.findViewById(R.id.create_account_submit);

        ArrayAdapter<CurrencyUnit> spinnerItemsAdapter = new ArrayAdapter<CurrencyUnit>(getActivity(), android.support.v7.appcompat.R.layout.support_simple_spinner_dropdown_item, CurrencyUnit.registeredCurrencies());
        mCurrency.setAdapter(spinnerItemsAdapter);
    }
}
