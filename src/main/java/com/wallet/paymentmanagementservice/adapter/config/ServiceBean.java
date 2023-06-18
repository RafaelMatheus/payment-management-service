package com.wallet.paymentmanagementservice.adapter.config;

import com.wallet.paymentmanagementservice.adapter.repository.PaymentRepository;
import com.wallet.paymentmanagementservice.core.port.PaymentPort;
import com.wallet.paymentmanagementservice.core.port.RabbitMqPort;
import com.wallet.paymentmanagementservice.core.port.impl.PaymentPortRepository;
import com.wallet.paymentmanagementservice.core.port.impl.RabbitMqPortImpl;
import com.wallet.paymentmanagementservice.core.service.PaymentService;
import com.wallet.paymentmanagementservice.core.service.impl.PaymentServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ServiceBean {
    @Bean
    public PaymentService paymentService(RabbitMqPort rabbitMqPort, PaymentPort repositoryPort, PropertiesConfiguration propertiesConfiguration) {
        return new PaymentServiceImpl(rabbitMqPort, repositoryPort, propertiesConfiguration);
    }

    @Bean
    public PaymentPort paymentPort(PaymentRepository repository) {
        return new PaymentPortRepository(repository);
    }

    @Bean
    public RabbitMqPort rabbitMqPort(RabbitTemplate rabbitTemplate) {
        return new RabbitMqPortImpl(rabbitTemplate);
    }
}
