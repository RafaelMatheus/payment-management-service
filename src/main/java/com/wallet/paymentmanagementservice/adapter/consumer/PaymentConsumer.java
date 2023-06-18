package com.wallet.paymentmanagementservice.adapter.consumer;

import com.wallet.paymentmanagementservice.adapter.consumer.dto.PaymentRabbitDtoRequest;
import com.wallet.paymentmanagementservice.core.helper.Mapper;
import com.wallet.paymentmanagementservice.core.service.PaymentService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {
    private final PaymentService service;

    public PaymentConsumer(PaymentService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${payment.rabbit.queue-name}")
    public void transactionConsumer(PaymentRabbitDtoRequest payment) {
        service.processPayment(Mapper.toDomain(payment));
    }
}
