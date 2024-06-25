package com.capitolis.eq.cash.reconciliation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EqCommonCashReconciliationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EqCommonCashReconciliationServiceApplication.class, args);
    }

}
