package com.anjan.labs.groupby.counting;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class StreamApiCountingTest {

    private final static Logger log = LoggerFactory.getLogger(StreamApiCountingTest.class);

    @Test
    public void basicFrequencyCountTest(){

        List<String> listOfWords = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");

        log.info(" ======== basicFrequencyCountTest :: listOfWords = {} ", listOfWords);

        StreamApiCounting streamApiCounting = new StreamApiCounting();

        Map<String,Long> resultMap = streamApiCounting.basicFrequencyCount(listOfWords);

        log.info(" ======== basicFrequencyCountTest :: resultMap = {} ", resultMap);

    }
}
