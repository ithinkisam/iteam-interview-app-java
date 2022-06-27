package com.securian.invest.example;

import lombok.Data;

@Data
public class Configuration {

    private String input;
    private String output;
    private ReportType reportType;

    private Configuration() {
        // private constructor
    }

    public static Configuration parseArgs(String[] args) {
        Configuration config = new Configuration();
        config.setInput(args[0]);
        config.setOutput(args[1]);
        config.setReportType(ReportType.valueOf(args[2]));
        return config;
    }

    public enum ReportType {
        BY_ISSUER,
        BY_SECURITY,
        BY_MONTH,
        BY_TRANSACTION_TYPE;
    }
}
