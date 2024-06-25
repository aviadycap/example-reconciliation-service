package com.capitolis.eq.cash.reconciliation.comparison;

import java.util.function.BiPredicate;


public class AttributeComparisonFactory {

    public static <T1, T2> AttributeComparison<T1, T2> createComparison(String compareRuleName, BiPredicate<T1, T2> comparator) {
        return new AttributeComparison<>(compareRuleName, comparator);
    }
}


