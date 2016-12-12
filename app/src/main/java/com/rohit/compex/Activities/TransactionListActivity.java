package com.rohit.compex.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.rohit.compex.Fragments.TransactionListFragment;

/**
 * Created by rohik on 12/11/16.
 */
public class TransactionListActivity extends SingleFragmentActivity {

    public static Intent getIntent(Context context) {
        Intent i = new Intent(context, TransactionListActivity.class);
        return i;
    }

    @Override
    protected Fragment createFragment() {
        return TransactionListFragment.newInstance();
    }
}
