package com.john.openfinance.adapters.in.web.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RawBankTransaction
        (
                String transactionId,
                String bankCode, // Ex: "341" (Itaú), "000" (Nubank)
                BigDecimal amount,
                String description,
                LocalDateTime timestamp,
                String type // Ex: "PIX", "TED", "DEBITO"
        )
{}
