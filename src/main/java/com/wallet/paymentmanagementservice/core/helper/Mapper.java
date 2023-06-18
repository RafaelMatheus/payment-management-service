package com.wallet.paymentmanagementservice.core.helper;

import com.wallet.paymentmanagementservice.adapter.consumer.dto.PaymentRabbitDtoRequest;
import com.wallet.paymentmanagementservice.adapter.entity.PaymentEntity;
import com.wallet.paymentmanagementservice.core.domain.PaymentDomain;
import com.wallet.paymentmanagementservice.core.enumerated.PaymentStatus;

import java.time.LocalDateTime;

public class Mapper {
    private Mapper() {
    }

    public static PaymentDomain toDomain(PaymentRabbitDtoRequest request) {
        return new PaymentDomain(request.getBarcode(), request.getAmount(), request.getTaxId(), request.getOriginAccount(), PaymentStatus.PROCESSED);
    }

    public static PaymentEntity toEntity(PaymentDomain domain) {
        return new PaymentEntity(null, domain.getBarcode(), domain.getAmount(),
                domain.getTaxId(), domain.getAccountNumber(), PaymentStatus.PROCESSED, LocalDateTime.now());
    }

    public static PaymentDomain toDomain(PaymentEntity domain) {
        return new PaymentDomain(domain.getBarcode(), domain.getAmount(),
                domain.getTaxId(), domain.getAccountNumber(), PaymentStatus.PROCESSED);
    }
}
