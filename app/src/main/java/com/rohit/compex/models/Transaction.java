package com.rohit.compex.models;

import org.joda.money.Money;

import java.util.Date;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by rohik on 12/10/16.
 */
@Getter
@Setter
public class Transaction {
    private UUID mTransactionId;
    private Money mAmount;
    private String mCategory;
    private String mStatus;
    private Date mDate;
    private String mNotes;
    private Account mPrimaryAccount;
    private Account mSecondaryAccount;
    private String mTransactionType;

    public Transaction() {
        mTransactionId = UUID.randomUUID();
        mDate = new Date();
    }
}
