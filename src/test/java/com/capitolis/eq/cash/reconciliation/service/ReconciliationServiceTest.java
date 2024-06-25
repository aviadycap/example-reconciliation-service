package com.capitolis.eq.cash.reconciliation.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.capitolis.eq.cash.reconciliation.comparator.TransactionAmountComparator;
import com.capitolis.eq.cash.reconciliation.comparator.TransactionIdComparator;
import com.capitolis.eq.cash.reconciliation.comparator.TransactionTimeComparator;
import com.capitolis.eq.cash.reconciliation.comparison.AttributeComparison;
import com.capitolis.eq.cash.reconciliation.comparison.CashTransactionAttributeDefinition;
import com.capitolis.eq.cash.reconciliation.model.EnfusionCashTransaction;
import com.capitolis.eq.cash.reconciliation.model.HeliosCashTransaction;
import java.util.Arrays;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ReconciliationServiceTest {

    @InjectMocks
    private ReconciliationService reconciliationService;

    @Mock
    private CashTransactionAttributeDefinition cashDefinition;

    @Mock
    private TransactionIdComparator idComparator;

    @Mock
    private TransactionAmountComparator amountComparator;

    @Mock
    private TransactionTimeComparator timeComparator;

    @Mock
    private TransactionReconcilerService transactionReconcilerService;

    private HeliosCashTransaction heliosTransaction;
    private EnfusionCashTransaction enfusionTransaction;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize sample transactions
        heliosTransaction = HeliosCashTransaction.builder()
                .cashId("H1")
                .amount(100.0)
                .transactionDate(new Date())
                .build();

        enfusionTransaction = EnfusionCashTransaction.builder()
                .transactionId("H1")
                .txAmount(100.0)
                .transactionTime(new Date())
                .build();

        // Define mock behavior
        when(cashDefinition.defineComparisons()).thenReturn(Arrays.asList(
                new AttributeComparison<>("transactionId", idComparator::areIdsEqual),
                new AttributeComparison<>("TxAmount", amountComparator::areAmountsEqual),
                new AttributeComparison<>("transactionTime", timeComparator::areTimesEqual)
        ));

        when(transactionReconcilerService.reconcile(enfusionTransaction, heliosTransaction, cashDefinition.defineComparisons())).thenReturn(true);
    }

    @Test
    public void testReconcileTransactions_Matching() {
        String result = reconciliationService.reconcile(enfusionTransaction, heliosTransaction);
        assertEquals("Transactions match: true", result);
    }

    @Test
    public void testReconcileTransactions_NotMatching() {
        heliosTransaction = HeliosCashTransaction.builder()
                .cashId("H2")
                .amount(200.0)
                .transactionDate(new Date())
                .build();

        when(transactionReconcilerService.reconcile(enfusionTransaction, heliosTransaction, cashDefinition.defineComparisons())).thenReturn(false);

        String result = reconciliationService.reconcile(enfusionTransaction, heliosTransaction);
        assertEquals("Transactions match: false", result);
    }
}
