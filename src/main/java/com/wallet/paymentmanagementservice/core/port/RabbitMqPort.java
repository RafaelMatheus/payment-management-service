package com.wallet.paymentmanagementservice.core.port;

import org.springframework.amqp.core.Message;

public interface RabbitMqPort {
    void send(Message message, String routingKey, String exchange);
}
