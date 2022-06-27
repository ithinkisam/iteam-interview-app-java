package com.securian.invest.example.aggregate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.securian.invest.example.domain.SummaryRecord;
import com.securian.invest.example.domain.TradeData;

class TradeDataAggregatorTest {
    
	TradeDataAggregator classUnderTest;
	
	List<TradeData> tradeDataList;
	TradeData tradeData;
	
	String issuer;
	String security;
	LocalDate settlementDate;
	String tranType;

	@BeforeEach
	void setup() {
		issuer = "cmdjeibnz";
		security = "wiqnaxc";
		settlementDate = LocalDate.of(2022, 06, 24);
		tranType = "C";
		
		tradeData = TradeData.builder()
				.issuer(issuer)
				.id(security)
				.settledOn(settlementDate)
				.transactionType(tranType)
				.amount(new BigDecimal(10))
				.build();
	}
	
	@Test 
	void issuerAggregateIdHasExpectedValue() {
		// Given
		classUnderTest = new IssuerAggregator();
		
		// When
		String result = classUnderTest.getAggregateId(tradeData);
		
		// Then
		assertEquals(issuer,result);
    }

	@Test 
	void securityAggregateIdHasExpectedValue() {
		// Given
		classUnderTest = new SecurityAggregator();
		
		// When
		String result = classUnderTest.getAggregateId(tradeData);
		
		// Then
		assertEquals(security,result);
    }

	@Test 
	void monthAggregateIdHasExpectedValue() {
		// Given
		classUnderTest = new MonthAggregator();
		
		// When
		String result = classUnderTest.getAggregateId(tradeData);
		
		// Then
		assertEquals("JUNE",result);
    }

	@Test 
	void transactionTypeAggregateIdHasExpectedValue() {
		// Given
		classUnderTest = new TransactionTypeAggregator();
		
		// When
		String result = classUnderTest.getAggregateId(tradeData);
		
		// Then
		assertEquals(tranType,result);
    }

	@Test 
	void tradeDataAggregatorReturnsEmptyList() {
		// Given
		classUnderTest = new TransactionTypeAggregator();
		
		// When
		List<SummaryRecord> result = classUnderTest.doAggregate(new ArrayList<>());
		
		// Then
		assertEquals(0,result.size());
    }

	@Test 
	void tradeDataAggregatorProcessesOneItem() {
		//TODO
    }

	@Test 
	void tradeDataAggregatorProcessesSimilarItems() {
		//TODO
    }

	@Test 
	void tradeDataAggregatorProcessesUnsimilarItems() {
		//TODO
    }

}
