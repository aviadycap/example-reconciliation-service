package com.capitolis.eq.cash.reconciliation.comparison;

import java.util.function.BiPredicate;
import lombok.Getter;

@Getter
public class AttributeComparison<T1, T2> {

    private String compareRuleName;
    private BiPredicate<T1, T2> comparator;

    public AttributeComparison(String compareRuleName, BiPredicate<T1, T2> comparator) {
        this.compareRuleName = compareRuleName;
        this.comparator = comparator;
    }

    public boolean compare(T1 model1, T2 model2) {
        return comparator.test(model1, model2);
    }
}


