package com.anjan.labs.groupby.counting;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApiCounting {

    /**
     * Basic Frequency Count (Strings)
     * <p>
     * Count the occurrence of the words from the below list
     */

    public Map<String, Long> basicFrequencyCount(List<String> listOfWords) {

        Map<String,Long> resultMap = listOfWords.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return resultMap;
    }
}
