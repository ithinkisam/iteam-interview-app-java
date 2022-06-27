package com.securian.invest.example.aggregate;

import com.securian.invest.example.domain.TradeData;

public class IssuerAggregator extends TradeDataAggregator {

	@Override
	public String getAggregateId(TradeData tradeData) {
		return tradeData.getIssuer();
	}

}
