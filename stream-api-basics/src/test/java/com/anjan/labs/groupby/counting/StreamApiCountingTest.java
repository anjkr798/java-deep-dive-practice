package com.anjan.labs.groupby.counting;

import com.anjan.labs.groupby.counting.dao.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
public class StreamApiCountingTest {


    @Test
    public void basicFrequencyCountTest(){
        log.info(" ======== basicFrequencyCountTest :: started ");

        List<String> listOfWords = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");

        log.info(" ======== basicFrequencyCountTest :: listOfWords = {} ", listOfWords);

        StreamApiCounting streamApiCounting = new StreamApiCounting();

        Map<String,Long> resultMap = streamApiCounting.basicFrequencyCount(listOfWords);

        log.info(" ======== basicFrequencyCountTest :: completed ");

    }

    @Test
    public void groupObjectByPropertyTest(){

        log.info(" ======== groupObjectByPropertyTest :: started ");

        List<Employee> employees = Arrays.asList(
                new Employee(101, "Alice", "HR", "10000"),
                new Employee(102, "Bob", "IT", "20000"),
                new Employee(103, "Charlie", "IT", "15000"),
                new Employee(104, "David", "Finance", "25000"),
                new Employee(105, "Eve", "HR", "20000")
        );
        StreamApiCounting streamApiCounting = new StreamApiCounting();

        streamApiCounting.groupObjectByProperty(employees);

        log.info(" ======== groupObjectByPropertyTest :: completed ");
    }
}
