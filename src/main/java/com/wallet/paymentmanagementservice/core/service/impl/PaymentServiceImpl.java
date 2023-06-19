package com.wallet.paymentmanagementservice.core.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet.paymentmanagementservice.adapter.config.PropertiesConfiguration;
import com.wallet.paymentmanagementservice.core.domain.PaymentDomain;
import com.wallet.paymentmanagementservice.core.dto.TransactionRabbitMqDomain;
import com.wallet.paymentmanagementservice.core.enumerated.TransactionType;
import com.wallet.paymentmanagementservice.core.port.PaymentPort;
import com.wallet.paymentmanagementservice.core.port.RabbitMqPort;
import com.wallet.paymentmanagementservice.core.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessagePropertiesBuilder;

public class PaymentServiceImpl implements PaymentService {
    private final Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);

    private final RabbitMqPort rabbitMqPort;
    private final PaymentPort repositoryPort;
    private final PropertiesConfiguration propertiesConfiguration;

    public PaymentServiceImpl(RabbitMqPort rabbitMqPort, PaymentPort repositoryPort, PropertiesConfiguration propertiesConfiguration1) {
        this.rabbitMqPort = rabbitMqPort;
        this.repositoryPort = repositoryPort;
        this.propertiesConfiguration = propertiesConfiguration1;
    }

    @Override
    public void processPayment(PaymentDomain paymentDomain) {
        log.info("m=processPayment");
        try {
            var message = toPaymentRabbitMqDomain(paymentDomain);
            rabbitMqPort.send(renderMensagemFila(message), propertiesConfiguration.getTransaction().getRabbit().getRoutingKey(),
                    propertiesConfiguration.getTransaction().getRabbit().getExchangeName());
            repositoryPort.save(paymentDomain);
        } catch (JsonProcessingException e) {
            log.error("m=processPayment", e);
            throw new RuntimeException(e);
        }
    }

    private TransactionRabbitMqDomain toPaymentRabbitMqDomain(PaymentDomain paymentDomain) {
        return new TransactionRabbitMqDomain(TransactionType.PAYMENT, paymentDomain.getAccountNumber(),
                paymentDomain.getAmount(), paymentDomain.getBarcode(), paymentDomain.getTaxId());
    }

    private Message renderMensagemFila(Object dto) throws JsonProcessingException {
        var mapperObj = new ObjectMapper();

        return MessageBuilder.withBody(mapperObj.writeValueAsBytes(dto))
                .andProperties(MessagePropertiesBuilder.newInstance().setContentType("application/json")
                        .setContentEncodingIfAbsent("UTF-8").build())
                .build();
    }
}
