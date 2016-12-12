package com.rohit.compex.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.rohit.compex.Fragments.AccountListFragment;
import com.rohit.compex.Managers.AccountsDao;
import com.rohit.compex.R;
import com.rohit.compex.models.Account;

public class CompexHomeActivity extends AppCompatActivity {

    private static final String TAG = "CompexHomeActivity";
    public static Intent getCompexHomeActivityIntent(Context context) {
        Intent compexHomeActivityIntent = new Intent(context, CompexHomeActivity.class);
        return compexHomeActivityIntent;
    }

    private Button mCreateAccountButton;
    private Button mAccountListButton;
    private Button mCreateTransactionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compex_home);


        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.account_list_fragment_container);

        if(fragment == null) {
            fragment = AccountListFragment.newInstance();
            fm.beginTransaction()
                    .add(R.id.account_list_fragment_container, fragment)
                    .commit();
        }

        mAccountListButton = (Button) findViewById(R.id.account_list_button);

        mAccountListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent i = new Intent(getApplicationContext(), AccountListActivity.class);
                startActivity(i);
            }
        });

        mCreateTransactionButton = (Button) findViewById(R.id.create_transaction_home);

        mCreateTransactionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent i = new Intent(getApplicationContext(), CreateTransactionActivity.class);
                startActivity(i);
            }
        });

        mCreateAccountButton = (Button) findViewById(R.id.create_account);

        for (Account account:
                AccountsDao.newInstance().getAccountsList()) {
            Log.i(TAG, account.toString());
        }
        mCreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent i = new Intent(getApplicationContext(), CreateAccountActivity.class);
                startActivity(i);
            }
        });
    }
}
