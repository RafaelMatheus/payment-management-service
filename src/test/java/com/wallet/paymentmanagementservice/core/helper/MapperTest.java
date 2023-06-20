package com.wallet.paymentmanagementservice.core.helper;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.wallet.paymentmanagementservice.core.base.BaseTest.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MapperTest {

    @Test
    void fromGetPaymentRabbitDtoRequestToDomain() {
        var paymentRabbit = getPaymentRabbitDtoRequest();
        var response = Mapper.toDomain(paymentRabbit);

        assertAll(() -> assertEquals(ACCOUNT, response.getAccountNumber()),
                () -> assertEquals(BARCODE, response.getBarcode()),
                () -> assertEquals(TAX_ID, response.getTaxId()),
                () -> assertEquals(BigDecimal.ZERO, response.getAmount())
        );
    }

    @Test
    void toEntity() {
        var paymentRabbit = getDomain();
        var response = Mapper.toEntity(paymentRabbit);

        assertAll(() -> assertEquals(ACCOUNT, response.getAccountNumber()),
                () -> assertEquals(BARCODE, response.getBarcode()),
                () -> assertEquals(TAX_ID, response.getTaxId()),
                () -> assertEquals(BigDecimal.ZERO, response.getAmount())
        );
    }
}