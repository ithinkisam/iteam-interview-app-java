package com.securian.invest.example.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.securian.invest.example.domain.SummaryRecord;
import com.securian.invest.example.domain.TradeData;

public class SummaryRecordLineMapperTest {
	
	SummaryRecordLineMapper classUnderTest;
	
	SummaryRecord summaryRecord;
	
	
	String tranType = "C";
	BigDecimal netAmount = BigDecimal.TEN;
	
	@BeforeEach
	void setup() {
		classUnderTest = new SummaryRecordLineMapper();
	}
	
	@Test
	void mapLineHappyPath() {
		// Given
		List<TradeData> tradeDataList = new ArrayList<>();
		TradeData tradeData = TradeData.builder().build();
		TradeData tradeData2 = TradeData.builder().build();
		tradeDataList.add(tradeData);
		tradeDataList.add(tradeData2);
		
		summaryRecord = new SummaryRecord();
		summaryRecord.setAggregateId(tranType);
		summaryRecord.setNetAmount(netAmount);
		summaryRecord.setTrades(tradeDataList);
		
		// When
		String[] result = classUnderTest.mapLine(summaryRecord);
		
		// Then
		assertEquals(tranType, result[0]);
		assertEquals(netAmount.toString(), result[1]);
		assertEquals(String.valueOf(tradeDataList.size()), result[2]);
	}
	
}
