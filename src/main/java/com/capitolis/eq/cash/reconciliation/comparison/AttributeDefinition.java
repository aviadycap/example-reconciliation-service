package com.capitolis.eq.cash.reconciliation.comparison;

import java.util.List;

public interface AttributeDefinition<T1, T2> {
    List<AttributeComparison<T1, T2>> defineComparisons();
}
