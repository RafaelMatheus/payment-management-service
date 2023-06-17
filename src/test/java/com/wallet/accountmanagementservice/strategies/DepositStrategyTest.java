package com.wallet.accountmanagementservice.strategies;

import com.wallet.accountmanagementservice.core.domain.AccountDomain;
import com.wallet.accountmanagementservice.core.port.RabbitMqPort;
import com.wallet.accountmanagementservice.core.port.impl.AccountPortRepository;
import com.wallet.accountmanagementservice.core.strategy.DepositStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static com.wallet.accountmanagementservice.base.BaseTestFactory.ACCOUNT_NUMBER;
import static com.wallet.accountmanagementservice.base.BaseTestFactory.getAccountDomain;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepositStrategyTest {
    @InjectMocks
    private DepositStrategy depositStrategy;
    @Mock
    private AccountPortRepository accountPortRepository;
    @Mock
    private RabbitMqPort rabbitMqPort;

    @Test
    void shouldCalculateDepositAndSendToRabbitMq() {
        var domain = getAccountDomain();
        when(accountPortRepository.findByAccountNumber(any())).thenReturn(domain);
        doNothing().when(rabbitMqPort).send(any(), any());

        depositStrategy.process(ACCOUNT_NUMBER, null, BigDecimal.TEN);

        ArgumentCaptor<AccountDomain> accountDomainArgumentCaptor = ArgumentCaptor.forClass(AccountDomain.class);

        verify(accountPortRepository).save(accountDomainArgumentCaptor.capture());

        var valueFromCapture = accountDomainArgumentCaptor.getValue();

        assertAll(() -> assertEquals(domain.getAccountNumber(), valueFromCapture.getAccountNumber()),
                () -> assertEquals(domain.getBalance(), valueFromCapture.getBalance()),
                () -> assertEquals(domain.getHolderName(), valueFromCapture.getHolderName()),
                () -> assertEquals(domain.getPhoneNumber(), valueFromCapture.getPhoneNumber()),
                () -> assertEquals(domain.getHolderTaxId(), valueFromCapture.getHolderTaxId()));
    }

}
