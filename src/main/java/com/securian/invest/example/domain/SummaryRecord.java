package com.securian.invest.example.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SummaryRecord {

    private String aggregateId;
    private List<TradeData> trades = new ArrayList<>();
    private BigDecimal netAmount = BigDecimal.ZERO;

}
