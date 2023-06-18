package com.wallet.paymentmanagementservice.core.service;

import com.wallet.paymentmanagementservice.core.domain.PaymentDomain;

public interface PaymentService {
    void processPayment(PaymentDomain paymentDomain);
}
