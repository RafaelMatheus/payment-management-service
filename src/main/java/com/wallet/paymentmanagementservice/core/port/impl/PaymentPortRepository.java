package com.wallet.paymentmanagementservice.core.port.impl;

import com.wallet.paymentmanagementservice.adapter.repository.PaymentRepository;
import com.wallet.paymentmanagementservice.core.domain.PaymentDomain;
import com.wallet.paymentmanagementservice.core.helper.Mapper;
import com.wallet.paymentmanagementservice.core.port.PaymentPort;

public class PaymentPortRepository implements PaymentPort {
    private final PaymentRepository paymentRepository;

    public PaymentPortRepository(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public PaymentDomain save(PaymentDomain paymentDomain) {
        var entity = Mapper.toEntity(paymentDomain);
        return Mapper.toDomain(paymentRepository.save(entity));
    }
}
