package com.wallet.paymentmanagementservice.core.port;

import com.wallet.paymentmanagementservice.core.domain.PaymentDomain;

public interface PaymentPort {
    PaymentDomain save(PaymentDomain accountDomain);
}
