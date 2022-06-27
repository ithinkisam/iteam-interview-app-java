package com.securian.invest.example.aggregate;

import com.securian.invest.example.domain.TradeData;
import com.securian.invest.example.domain.SummaryRecord;

public class AggregatorFactory {

    public Aggregator<TradeData, SummaryRecord> getAggregator(String reportType) {
        
    	switch (reportType) {
    		case "BY_ISSUER":
        		return new IssuerAggregator();
    		case "BY_SECURITY":
        		return new SecurityAggregator();
    		case "BY_TRANSACTION_TYPE":
    		case "BY_MONTH":
        		return new MonthAggregator();
    		default:
    			return null;
    	}
    }

}
