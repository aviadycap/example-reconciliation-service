package com.capitolis.eq.cash.reconciliation.service;

import com.capitolis.eq.cash.reconciliation.comparison.CashTransactionAttributeDefinition;
import com.capitolis.eq.cash.reconciliation.model.EnfusionCashTransaction;
import com.capitolis.eq.cash.reconciliation.model.HeliosCashTransaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReconciliationService {

    private final CashTransactionAttributeDefinition cashDefinition;
    private final TransactionReconcilerService transactionReconciler;

    public String reconcile(EnfusionCashTransaction enfusionTransaction, HeliosCashTransaction heliosTransaction) {
        boolean match = transactionReconciler.reconcile(enfusionTransaction, heliosTransaction, cashDefinition.defineComparisons());
        return "Transactions match: " + match;
    }
}
