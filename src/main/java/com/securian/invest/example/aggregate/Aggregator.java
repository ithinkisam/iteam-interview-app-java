package com.securian.invest.example.aggregate;

import java.util.List;

public interface Aggregator<I, O> {

    List<O> doAggregate(List<I> input);

}
