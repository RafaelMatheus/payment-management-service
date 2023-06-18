package com.wallet.paymentmanagementservice.adapter.repository;

import com.wallet.paymentmanagementservice.adapter.entity.PaymentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<PaymentEntity, String> {
}
