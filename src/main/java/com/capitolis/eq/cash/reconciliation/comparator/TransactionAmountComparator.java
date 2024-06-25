package com.capitolis.eq.cash.reconciliation.comparator;

import com.capitolis.eq.cash.reconciliation.model.EnfusionCashTransaction;
import com.capitolis.eq.cash.reconciliation.model.HeliosCashTransaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionAmountComparator {

    private static final double TOLERANCE = 0.001;

    public boolean areAmountsEqual(EnfusionCashTransaction enfusion, HeliosCashTransaction helios) {
        return Math.abs(enfusion.getTxAmount() - helios.getAmount()) < TOLERANCE;
    }
}
