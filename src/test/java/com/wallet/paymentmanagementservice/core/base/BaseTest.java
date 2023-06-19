package com.wallet.paymentmanagementservice.core.base;

import com.wallet.paymentmanagementservice.adapter.consumer.dto.PaymentRabbitDtoRequest;
import com.wallet.paymentmanagementservice.core.domain.PaymentDomain;
import com.wallet.paymentmanagementservice.core.enumerated.PaymentStatus;

import java.math.BigDecimal;

public class BaseTest {

    public static final String ACCOUNT = "account";
    public static final String BARCODE = "XPTO";
    public static final String TAX_ID = "1234567890";

    private BaseTest() {
    }

    public static PaymentRabbitDtoRequest getPaymentRabbitDtoRequest() {
        return new PaymentRabbitDtoRequest(ACCOUNT, BigDecimal.ZERO, BARCODE, TAX_ID);
    }

    public static PaymentDomain getDomain() {
        return new PaymentDomain(BARCODE, BigDecimal.ZERO, TAX_ID, ACCOUNT, PaymentStatus.PROCESSED);
    }
}
