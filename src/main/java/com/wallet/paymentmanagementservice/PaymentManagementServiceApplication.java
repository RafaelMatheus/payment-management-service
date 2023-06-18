package com.wallet.paymentmanagementservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class PaymentManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentManagementServiceApplication.class, args);
	}

}
