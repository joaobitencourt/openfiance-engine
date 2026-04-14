package com.john.openfinance.adapters.in.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OpenFinanceDtos {

    public record BankResponse(
            @Schema(description = "Código de compensação (COMPE) da instituição", example = "341")
            String bankCode,

            @Schema(description = "Nome fantasia da instituição", example = "Itaú Unibanco S.A.")
            String name
    ) {}

    public record BalanceResponse(
            @Schema(description = "Moeda da conta", example = "BRL")
            String currency,

            @Schema(description = "Saldo disponível atual", example = "1545.50")
            BigDecimal availableAmount
    ) {}

    public record TransactionResponse(
            @Schema(description = "ID único da transação", example = "tx-998877")
            String transactionId,

            @Schema(description = "Data e hora da transação", example = "2026-03-24T10:30:00")
            LocalDateTime timestamp,

            @Schema(description = "Valor da transação (negativo para saídas)", example = "-45.90")
            BigDecimal amount,

            @Schema(description = "Descrição ou histórico", example = "UBER *TRIP")
            String description
    ) {}

}
