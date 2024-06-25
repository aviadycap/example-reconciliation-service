package com.capitolis.eq.cash.reconciliation.comparator;

import com.capitolis.eq.cash.reconciliation.model.EnfusionCashTransaction;
import com.capitolis.eq.cash.reconciliation.model.HeliosCashTransaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionIdComparator {

    public boolean areIdsEqual(EnfusionCashTransaction enfusion, HeliosCashTransaction helios) {
        return enfusion.getTransactionId().equals(helios.getCashId());
    }
}
