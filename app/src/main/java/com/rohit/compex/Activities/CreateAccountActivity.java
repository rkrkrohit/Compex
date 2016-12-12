package com.rohit.compex.Activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.rohit.compex.Fragments.CreateAccountFragment;
import com.rohit.compex.R;

public class CreateAccountActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return CreateAccountFragment.newInstance();
    }


}
