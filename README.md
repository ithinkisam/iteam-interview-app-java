# Investment Systems Interview Java Application

Thank you for your interest in the Enterpise Technology Investments Team at Securian Financial! As part of our process to get to know you, we built this coding exercise that resembles real problems we solve as members of this team. Please read the sections below for an introduction to this application, details you need to know to get started, and finally, what we would like to see you do!

## System Requirements

### IDE

Use whichever IDE you are most comfortable with. We use Eclipse and Visual Studio Code. Both are free. Visual Studio Code is lighterweight and requires less setup, but can be pickier when it comes to setting up and running a Java project. Eclipse has been around longer and may be more familiar to you.

### Java

Most of our applications run on Java 8, so you'll need a [Java JDK](https://www.oracle.com/java/technologies/downloads/#java8) in order to work on this exercise. If you already have a more recent version of the JDK installed, that should work as well.

### Gradle

Gradle is one of the most popular build automation tools used by Java developers. This project leverages a Gradle wrapper within the project, so you shouldn't need to install it, but here is the install link if the need arises. This project is using Gradle v7.4.2.

[Gradle installation instructions](https://gradle.org/install/)

### Lombok

Lombok is a code generation tool used to generate boilerplate code for Java applications (getters, setters, constructors, toString, etc.). We rely on this library to keep our code base clean and to eliminate human error. Follow the [installation instructions](https://projectlombok.org/download) for your IDE to get it set up locally.

The latest version of the Lombok JAR is provided in this project at `/extra/lombok.jar`.

Getting Lombok working in your IDE can be time consuming if it does not work right away. We've provided versions of the `SummaryRecord` and `TradeData` classes with the Lombok dependency removed. You can find them under `src/main/resources/delombok`. Copy the two files to the "domain" package, delete the existing files, and then remove the ".txt" extension.

## Overview

The purpose of this application is to:

1. Read in a file containing detailed trade data,
2. Aggregate the data based on an input parameter, and finally
3. Write out to a file with the summarized data

The application takes three arguments, in this order.

1. A path to the input file (e.g. `src/main/resources/input/trade-data.csv`)
2. A path to the output summary file (e.g. `src/main/resources/output/summary.csv`)
3. The type of aggregation to perform; must be one of `BY_ISSUER`, `BY_SECURITY`, `BY_TRANSACTION_TYPE`, or `BY_MONTH`.

Use the Gradle `run` task to run the application.

```sh
# bash
./gradlew run --args="src/main/resources/input/trade-data.csv src/main/resources/output/summary.csv BY_ISSUER"
```

```ps1
# Windows (Powershell, cmd)
gradlew.bat run --args="src/main/resources/input/trade-data.csv src/main/resources/output/summary.csv BY_ISSUER"
```

## Application Details

#### Reading

| File                                                                    | Description                                                               |
| ----------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `src/main/resources/input/trade-data.csv`                               | Input file containing test input data                                     |
| `src/main/java/com/securian/invest/domain/TradeData.java`               | POJO that stores trade data                                               |
| `src/main/java/com/securian/invest/example/io/ItemMapper.java`          | Interface for mapping a line of data from a csv file into a POJO          |
| `src/main/java/com/securian/invest/example/io/TradeDataItemMapper.java` | Implementation of a `ItemMapper`; Maps csv data into a `TradeData` object |

#### Aggregating

| File                                                                                 | Description                                                                                                   |
| ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------- |
| `src/main/java/com/securian/invest/example/aggregate/Aggregator.java`                | Interface for aggregating data                                                                                |
| `src/main/java/com/securian/invest/example/aggregate/TradeDataAggregator.java`       | Implementation of an `Aggregator`; Aggregates trade amounts, grouping by field determined via input parameter |
| `src/main/java/com/securian/invest/example/aggregate/AggregatorFactory.java`         | Class to determine which field to aggregate by                                                                |
| `src/main/java/com/securian/invest/example/aggregate/IssuerAggregator.java`          | Tells `TradeDataAggregaator` to aggregate by Issuer                                                           |
| `src/main/java/com/securian/invest/example/aggregate/MonthAggregator.java`           | Tells `TradeDataAggregaator` to aggregate by Month                                                            |
| `src/main/java/com/securian/invest/example/aggregate/SecurityAggregator.java`        | Tells `TradeDataAggregaator` to aggregate by Security Id                                                      |
| `src/main/java/com/securian/invest/example/aggregate/TransactionTypeAggregator.java` | Tells `TradeDataAggregaator` to aggregate by Transaction Type                                                 |

#### Writing

| File                                                                        | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `src/main/resources/output/summary.csv`                                     | Output file containing results of running the application                   |
| `src/main/java/com/securian/invest/example/domain/SummaryRecord.java`       | POJO that stores summary data records                                       |
| `src/main/java/com/securian/invest/example/io/LineMapper.java`              | Interface for mapping a POJO to a line of a csv file                        |
| `src/main/java/com/securian/invest/example/io/SummaryRecordLineMapper.java` | Implementation of a `LineMapper`; Maps a `SummaryRecord` object to csv data |

#### Executing

| File                               | Description                                                  |
| ---------------------------------- | ------------------------------------------------------------ |
| `src/main/java/App.java`           | Contains the `main()` function that executes the application |
| `src/main/java/Configuration.java` | POJO that parses and stores the input parameters             |

#### Testing

| File                                                                               | Description                              |
| ---------------------------------------------------------------------------------- | ---------------------------------------- |
| `src/test/java/com/securian/invest/example/aggregate/TradeDataAggregatorTest.java` | Test class for `TradeDataAggregator`     |
| `src/test/java/com/securian/invest/example/io/SummaryRecordLineMapperTest.java`    | Test class for `SummaryRecordLineMapper` |
| `src/test/java/com/securian/invest/example/io/TradeDataItemMapperTest.java`        | Test class for `TradeDataItemMapper`     |

## Challenge #1

Uh oh! The application keeps failing during the read step! Troubleshoot your way to figure out the root cause, and then put a solution in place.

## Challenge #2

Whoops! The output file doesn't seem to have the correct net amounts. What went wrong? Find and fix the bug!

## Challenge #3

Hmmm.. The input parameter 'BY_TRANSACTION_TYPE' doesn't seem to work just right. Can you resolve this issue, too?

## Bonus Challenge!

Write unit tests to one or more test classes to validate your changes from Challenges 2 and 3 are working as expected.
