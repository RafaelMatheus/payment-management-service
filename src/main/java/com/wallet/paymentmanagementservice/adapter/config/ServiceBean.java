package com.wallet.paymentmanagementservice.adapter.config;

import com.wallet.paymentmanagementservice.core.service.PaymentService;
import com.wallet.paymentmanagementservice.core.service.impl.PaymentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ServiceBean {
    @Bean
    public PaymentService paymentService() {
        return new PaymentServiceImpl();
    }
}
