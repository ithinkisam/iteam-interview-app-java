package com.securian.invest.example.aggregate;

import com.securian.invest.example.domain.TradeData;

public class TransactionTypeAggregator extends TradeDataAggregator {

	@Override
	String getAggregateId(TradeData tradeData) {
		return tradeData.getTransactionType();
	}

}
