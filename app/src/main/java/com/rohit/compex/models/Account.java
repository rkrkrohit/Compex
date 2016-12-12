package com.rohit.compex.models;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by rohik on 12/10/16.
 */
@Getter
@Setter
public class Account {
    private UUID mAccountId;
    private String mAccountName;
    private CurrencyUnit mCurrencyUnit;
    private Money mInitialAmount;
    private Date mDateCreated;

    public Account() {
        mAccountId = UUID.randomUUID();
        mDateCreated = new Date();
    }

    @Override
    public String toString() {
        return "Account{" +
                "mAccountId=" + mAccountId +
                ", mAccountName='" + mAccountName + '\'' +
                ", mCurrencyUnit=" + mCurrencyUnit +
                ", mInitialAmount=" + mInitialAmount +
                ", mDateCreated=" + mDateCreated +
                '}';
    }
}
