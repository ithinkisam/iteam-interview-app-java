package com.securian.invest.example.io;

import com.securian.invest.example.domain.SummaryRecord;

public class SummaryRecordLineMapper implements LineMapper<SummaryRecord> {

	public String[] mapLine(SummaryRecord summary) {
		String[] lineItems = {
			summary.getAggregateId(), 
			summary.getNetAmount().toString(), 
			String.valueOf(summary.getTrades().size()) 
		};

		return lineItems;
	}

}
