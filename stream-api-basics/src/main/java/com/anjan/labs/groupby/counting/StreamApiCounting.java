package com.anjan.labs.groupby.counting;

import com.anjan.labs.groupby.counting.dao.Employee;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class StreamApiCounting {

    /**
     * Basic Frequency Count (Strings)<br/>
     * <p>
     * Problem Statement: Given a list of words, find the frequency of each unique word in the list.<br/>
     * Count the occurrence of the words from the below list<br/>
     */

    public Map<String, Long> basicFrequencyCount(List<String> listOfWords) {

        Map<String, Long> resultMap = listOfWords.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        log.info(" ======== basicFrequencyCountTest :: resultMap = {} ", resultMap);
        return resultMap;
    }


    /**
     * Problem Statement:<br/>
     * 1. You have a list of Employee objects. Group them by their Department and count how many employees are in each department<br/>
     * 2. get list of names by department<br/>
     * 3. calculate which department paying max total salary<br/>
     */

    public void groupObjectByProperty(List<Employee> employees) {

        // 1. Group them by their Department and count how many employees are in each department
        log.info(" ===  1. Group them by their Department and count how many employees are in each department === ");
        Map<String, Long> mapEmployeeCountByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        log.info(" === groupObjectByProperty_mapEmployeeCountByDepartment: mapEmployeeCountByDepartment = {} === ", mapEmployeeCountByDepartment);

        // 2. get list of names by department
        log.info(" ===  2. get list of names by department === ");
        Map<String, List<String>> listOfEmployeeNamesByDepartMent =
                employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
        log.info(" === groupObjectByProperty_listOfEmployeeNamesByDepartMent: traditionalForLoopMap = {} === ", listOfEmployeeNamesByDepartMent);


        // 3. calculate which department paying max total salary
        // using for each loop
        log.info(" === 3. calculate which department paying max total salary === ");
        log.info(" groupObjectByProperty_departmentNameWithMaxTotalSalary : using for each loop ");
        Map<String, Double> traditionalForLoopMap = new HashMap<>();
        for (Employee employee : employees) {
            if (traditionalForLoopMap.get(employee.getDepartment()) != null) {
                traditionalForLoopMap.put(employee.getDepartment(), traditionalForLoopMap.get(employee.getDepartment()) + Double.parseDouble(employee.getSalary()));
            } else {
                traditionalForLoopMap.put(employee.getDepartment(), Double.parseDouble(employee.getSalary()));
            }
        }
        log.info(" === groupObjectByProperty_departmentNameWithMaxTotalSalary: traditionalForLoopMap = {} === ", traditionalForLoopMap);

        // using stream
        Map<String, Double> departmentTotalSalaryMap =
                employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingDouble(emp -> Double.parseDouble(emp.getSalary()))));

        log.info(" === groupObjectByProperty_departmentNameWithMaxTotalSalary using Stream API : departmentTotalSalaryMap = {} === ", departmentTotalSalaryMap);

        Map<String, Double> departmentWithMaxTotalSalary =
                employees.stream().collect(
                                Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(emp -> Double.parseDouble(emp.getSalary())))
                        ).entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .map(entry -> Map.of(entry.getKey(), entry.getValue()))
                        .orElseThrow();

        log.info(" === groupObjectByProperty_departmentNameWithMaxTotalSalary using Stream API : departmentWithMaxTotalSalary = {} === ", departmentWithMaxTotalSalary);

    }


}
