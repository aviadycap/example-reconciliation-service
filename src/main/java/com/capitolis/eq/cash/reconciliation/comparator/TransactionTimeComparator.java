package com.capitolis.eq.cash.reconciliation.comparator;

import com.capitolis.eq.cash.reconciliation.model.EnfusionCashTransaction;
import com.capitolis.eq.cash.reconciliation.model.HeliosCashTransaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionTimeComparator {

    public boolean areTimesEqual(EnfusionCashTransaction enfusion, HeliosCashTransaction helios) {
        return enfusion.getTransactionTime().equals(helios.getTransactionDate());
    }
}

