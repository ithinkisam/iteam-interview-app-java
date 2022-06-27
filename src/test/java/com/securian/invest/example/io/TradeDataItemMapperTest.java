package com.securian.invest.example.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.securian.invest.example.domain.TradeData;

public class TradeDataItemMapperTest {
	
	TradeDataItemMapper classUnderTest;
	
	String dateFormat = "uuuu-MM-dd";
	
	int expectedColumnCount;
	
	String id;
	String issuer;
	String tradeDate;
	String settlementDate;
	String tranType;
	String amount;
	String shares;
	
	@BeforeEach
	void setup() {
		classUnderTest = new TradeDataItemMapper(dateFormat);
		expectedColumnCount = TradeDataItemMapper.getExpectedColumnCount();
		
		id = "id";
		issuer = "issuer";
		tradeDate = "2022-01-01";
		settlementDate = "2022-01-01";
		tranType = "tranType";
		amount = "101";
		shares = "202";
	}

	@Test
	void mapRowHappyPath() throws Exception {
		// Given
		String[] lineItems = {
			id,
			issuer,
			tradeDate,
			settlementDate,
			tranType,
			amount,
			shares
		};
		
		// When
		TradeData result = classUnderTest.mapRow(lineItems);
		
		// Then
		assertEquals(id,result.getId());
		assertEquals(issuer,result.getIssuer());
		assertEquals(tradeDate,result.getTradedOn().toString());
		assertEquals(settlementDate,result.getSettledOn().toString());
		assertEquals(tranType,result.getTransactionType());
		assertEquals(amount,result.getAmount().toString());
		assertEquals(shares,result.getShares().toString());
	}
	
	@Test
	void tooManyColumnsThrowsException() throws Exception {
		// Given
		String[] lineItems = {
			id,
			issuer,
			tradeDate,
			settlementDate,
			tranType,
			amount,
			shares,
			""
		};
		
		// When/Then
		assertThrows(Exception.class, () -> {
			classUnderTest.mapRow(lineItems);
		});
	}
	
	@Test
	void notEnoughColumnsThrowsException() throws Exception {
		// Given
		String[] lineItems = {
			id,
			issuer,
			tradeDate,
			settlementDate,
			tranType,
			amount
		};
		
		// When/Then
		assertThrows(Exception.class, () -> {
			classUnderTest.mapRow(lineItems);
		});
	}
}
