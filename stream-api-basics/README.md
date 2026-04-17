# Java Stream API: Basics to Advanced Aggregation

This module is a comprehensive guide to mastering the Java Stream API, ranging from basic filtering and mapping to advanced data aggregation using the `Collectors` API.

## Overview

The project provides practical, problem-based implementations of common data processing scenarios. It is designed to help developers move from simple stream operations to complex grouping, partitioning, and reduction techniques.

## Project Structure

The exercises are divided into three main categories:

1.  **Basic Operations**: Filtering, mapping, sorting, and basic statistics.
    - Located in: `src/main/java/com/anjan/labs/filterandmap/FilterMapBasics.java`
2.  **Advanced Aggregations**: Grouping, counting, averaging, and partitioning using `Student` models.
    - Located in: `src/main/java/com/anjan/labs/groupby/counting/GroupingByAndCountingBasics.java`
3.  **Real-world Scenarios**: Frequency counting, employee department analysis, and derived criteria grouping.
    - Located in: `src/main/java/com/anjan/labs/groupby/counting/StreamApiCounting.java`

## Detailed Problem Descriptions

A complete list of all problems implemented in this project, including scenarios, goals, and expected results, can be found in the separate documentation file:

👉 **[Problem Descriptions (problem_description.md)](problem_description.md)**

## Features Covered

- **Filtering & Mapping**: Transforming data based on predicates and functions.
- **Reductions**: Using `.reduce()` for custom aggregations and `.collect(Collectors.joining())` for string concatenation.
- **Statistics**: Calculating averages and squared values using primitive stream specializations (`mapToDouble`, `average`).
- **Basic Grouping**: Grouping objects by property using `Collectors.groupingBy`.
- **Downstream Collectors**: Combining `groupingBy` with `counting()`, `averagingDouble()`, `summingDouble()`, and `mapping()`.
- **Partitioning**: Splitting data into two groups based on a boolean condition using `Collectors.partitioningBy`.
- **Frequency Analysis**: Counting occurrences of items in a list.

## Data Models

The exercises utilize the following data structures:
- **Student**: A Java Record containing `name`, `grade`, and `department`.
- **Employee**: A class containing `id`, `name`, `department`, and `salary`.
- **StudentSummary**: A lightweight DTO used for transformed results.

## Technologies

- **Java 21+** (utilizing Records)
- **Lombok** (for SLF4J logging, builders, and boilerplate reduction)
- **SLF4J** for logging results
- **JUnit 5** for testing implementations

---
*This is part of the Engineering Labs - Java Deep Dive Practice series.*
