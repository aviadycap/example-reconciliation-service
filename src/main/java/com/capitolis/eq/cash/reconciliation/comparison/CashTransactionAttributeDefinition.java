package com.capitolis.eq.cash.reconciliation.comparison;

import com.capitolis.eq.cash.reconciliation.comparator.TransactionAmountComparator;
import com.capitolis.eq.cash.reconciliation.comparator.TransactionIdComparator;
import com.capitolis.eq.cash.reconciliation.comparator.TransactionTimeComparator;
import com.capitolis.eq.cash.reconciliation.model.EnfusionCashTransaction;
import com.capitolis.eq.cash.reconciliation.model.HeliosCashTransaction;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CashTransactionAttributeDefinition implements AttributeDefinition<EnfusionCashTransaction, HeliosCashTransaction> {

    private final TransactionIdComparator idComparator;
    private final TransactionAmountComparator amountComparator;
    private final TransactionTimeComparator timeComparator;


    @Override
    public List<AttributeComparison<EnfusionCashTransaction, HeliosCashTransaction>> defineComparisons() {
        return Arrays.asList(
                AttributeComparisonFactory.createComparison("transactionId", idComparator::areIdsEqual),
                AttributeComparisonFactory.createComparison("TxAmount", amountComparator::areAmountsEqual),
                AttributeComparisonFactory.createComparison("transactionTime", timeComparator::areTimesEqual)
        );
    }
}
