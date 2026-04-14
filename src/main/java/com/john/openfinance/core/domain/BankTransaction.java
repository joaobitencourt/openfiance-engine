package com.john.openfinance.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BankTransaction(String id, LocalDateTime timestamp, BigDecimal amount, String Description) {
}
