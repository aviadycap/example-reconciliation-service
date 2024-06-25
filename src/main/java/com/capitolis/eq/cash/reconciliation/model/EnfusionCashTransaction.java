package com.capitolis.eq.cash.reconciliation.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class EnfusionCashTransaction {
    private String transactionId;
    private double txAmount;
    private Date transactionTime;
}
