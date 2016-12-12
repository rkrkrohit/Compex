package com.rohit.compex.Activities;

import android.support.v4.app.Fragment;

import com.rohit.compex.Fragments.AccountListFragment;

/**
 * Created by rohik on 12/11/16.
 */
public class AccountListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return AccountListFragment.newInstance();
    }
}
