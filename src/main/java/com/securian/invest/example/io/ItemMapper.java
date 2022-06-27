package com.securian.invest.example.io;

public interface ItemMapper<T> {

    T mapRow(String[] lineItems) throws Exception;

}
