package com.capitolis.eq.cash.reconciliation.service;

import com.capitolis.eq.cash.reconciliation.comparison.AttributeComparison;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TransactionReconcilerService {

    public <T1, T2> boolean reconcile(T1 model1, T2 model2, List<AttributeComparison<T1, T2>> attributeComparisons) {
        return attributeComparisons.stream()
                .allMatch(comparison -> comparison.compare(model1, model2));
    }
}
