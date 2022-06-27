package com.securian.invest.example.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TradeData {

    private String id;
    private String issuer;
    private LocalDate tradedOn;
    private LocalDate settledOn;
    private String transactionType;
    private BigDecimal shares;
    private BigDecimal amount;

}
