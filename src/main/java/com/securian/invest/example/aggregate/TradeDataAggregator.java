package com.securian.invest.example.aggregate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.securian.invest.example.domain.TradeData;
import com.securian.invest.example.domain.SummaryRecord;

public abstract class TradeDataAggregator implements Aggregator<TradeData,SummaryRecord>{

	@Override
	public List<SummaryRecord> doAggregate(List<TradeData> tradeDataList) {
		Map<String,SummaryRecord> summaryRecordMap = new HashMap<>();
		
		for (TradeData tradeData : tradeDataList) {
			String aggregateId = getAggregateId(tradeData);
			
			SummaryRecord summaryRecord;
			if (summaryRecordMap.containsKey(aggregateId)) {
				summaryRecord = summaryRecordMap.get(aggregateId);
			} else {
				summaryRecord = new SummaryRecord();
				summaryRecord.setAggregateId(aggregateId);
			}
			
			summaryRecord.getNetAmount().add(tradeData.getAmount());
			summaryRecord.getTrades().add(tradeData);

			summaryRecordMap.put(aggregateId, summaryRecord);
		}
		
		return new ArrayList<>(summaryRecordMap.values());
	}

	abstract String getAggregateId(TradeData tradeData);
	
}
