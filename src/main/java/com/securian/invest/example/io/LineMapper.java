package com.securian.invest.example.io;

public interface LineMapper<T> {
	
	String[] mapLine(T item);
	
}
