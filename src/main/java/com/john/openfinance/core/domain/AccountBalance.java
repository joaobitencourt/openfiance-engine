package com.john.openfinance.core.domain;

import java.math.BigDecimal;

public record AccountBalance(String currency, BigDecimal amount) {
}
