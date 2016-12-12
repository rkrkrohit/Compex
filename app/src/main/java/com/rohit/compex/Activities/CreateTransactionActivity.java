package com.rohit.compex.Activities;

import android.support.v4.app.Fragment;

import com.rohit.compex.Fragments.CreateTransactionFragment;

/**
 * Created by rohik on 12/11/16.
 */
public class CreateTransactionActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return CreateTransactionFragment.newInstance();
    }
}
