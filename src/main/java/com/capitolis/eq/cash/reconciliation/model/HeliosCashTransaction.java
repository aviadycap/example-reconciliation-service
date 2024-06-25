package com.capitolis.eq.cash.reconciliation.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class HeliosCashTransaction {
    private String cashId;
    private double amount;
    private Date transactionDate;
}
