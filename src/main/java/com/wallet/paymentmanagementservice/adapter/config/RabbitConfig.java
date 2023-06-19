package com.wallet.paymentmanagementservice.adapter.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    private final PropertiesConfiguration env;

    public RabbitConfig(PropertiesConfiguration env) {
        this.env = env;
    }

    @Bean
    public DirectExchange exchange() {
        return ExchangeBuilder.directExchange(env.getPayment().getRabbit().getExchangeName())
                .build();
    }

    @Bean
    public DirectExchange deadLetterExchange() {
        return ExchangeBuilder
                .directExchange(env.getPayment().getRabbit().getDeadLetterExchange())
                .build();
    }

    @Bean
    public Queue transactionQueue() {
        return QueueBuilder.durable(env.getPayment().getRabbit().getQueueName())
                .deadLetterExchange(env.getPayment().getRabbit().getDeadLetterExchange())
                .deadLetterRoutingKey(env.getPayment().getRabbit().getDeadLetterRoutingKey())
                .build();
    }

    @Bean
    public Queue deadLetterQueue() {
        return QueueBuilder.durable(env.getPayment().getRabbit().getDeadLetterQueueName())
                .build();
    }

    @Bean
    public Binding deadLetterBiding() {
        return BindingBuilder.bind(deadLetterQueue()).to(deadLetterExchange()).with(env.getPayment().getRabbit().getDeadLetterRoutingKey());
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(transactionQueue()).to(exchange()).with(env.getPayment().getRabbit().getRoutingKey());
    }


    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
}
