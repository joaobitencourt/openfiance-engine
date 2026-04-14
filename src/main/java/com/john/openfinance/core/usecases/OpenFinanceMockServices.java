package com.john.openfinance.core.usecases;

import com.john.openfinance.core.domain.AccountBalance;
import com.john.openfinance.core.domain.BankTransaction;
import com.john.openfinance.core.domain.Institution;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service // Usamos o @Service para o Spring injetar isso no Controller automaticamente
public class OpenFinanceMockServices {
    public List<Institution> listAvailableBanks() {
        return List.of(
                new Institution("341", "Itaú Unibanco S.A."),
                new Institution("000", "Nubank S.A."),
                new Institution("033", "Banco Santander (Brasil) S.A.")
        );
    }

    public AccountBalance getBalanceForBank(String bankCode) {
        // Num cenário real, aqui usaríamos o bankCode para buscar no banco de dados
        return new AccountBalance("BRL", new BigDecimal("1545.50"));
    }

    public List<BankTransaction> getTransactionsForBank(String bankCode) {
        return List.of(
                new BankTransaction("tx-1", LocalDateTime.now().minusDays(1), new BigDecimal("-45.90"), "UBER *TRIP"),
                new BankTransaction("tx-2", LocalDateTime.now().minusDays(2), new BigDecimal("5000.00"), "SALARIO MENSAL")
        );
    }
}
