package com.securian.invest.example.io;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import com.securian.invest.example.domain.TradeData;
import lombok.Getter;

public class TradeDataItemMapper implements ItemMapper<TradeData> {

	@Getter
    private static final int expectedColumnCount = 7;

    private String dateFormat;

    public TradeDataItemMapper(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public TradeData mapRow(String[] lineItems) throws Exception {
        if (lineItems.length != expectedColumnCount) {
            throw new Exception("Expected "+ expectedColumnCount +" columns in input, got "+ lineItems.length +" columns. Invalid record: " + Arrays.toString(lineItems));
        }

        TradeData record = TradeData.builder()
                .id(lineItems[0])
                .issuer(lineItems[1])
                .tradedOn(LocalDate.parse(lineItems[2], DateTimeFormatter.ofPattern(dateFormat)))
                .settledOn(LocalDate.parse(lineItems[3], DateTimeFormatter.ofPattern(dateFormat)))
                .transactionType(lineItems[4])
                .amount(new BigDecimal(lineItems[5]))
                .shares(new BigDecimal(lineItems[6]))
                .build();
        return record;
    }

}
