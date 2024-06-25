package com.capitolis.eq.cash.reconciliation.controller;

import com.capitolis.eq.cash.reconciliation.model.EnfusionCashTransaction;
import com.capitolis.eq.cash.reconciliation.model.HeliosCashTransaction;
import com.capitolis.eq.cash.reconciliation.service.ReconciliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
public class ReconciliationController {

    @Autowired
    private ReconciliationService reconciliationService;

    @GetMapping("/compare-transactions")
    public String compareTransactions() {
        // Create instances using Lombok Builder or any other means
        HeliosCashTransaction heliosTransaction = HeliosCashTransaction.builder()
                .cashId("H1")
                .amount(100.0)
                .transactionDate(new Date())
                .build();

        EnfusionCashTransaction enfusionTransaction = EnfusionCashTransaction.builder()
                .transactionId("H1")
                .txAmount(100.0)
                .transactionTime(new Date())
                .build();

        // Compare HeliosCashTransaction with EnfusionCashTransaction
        return reconciliationService.reconcile(enfusionTransaction, heliosTransaction);
    }
}
