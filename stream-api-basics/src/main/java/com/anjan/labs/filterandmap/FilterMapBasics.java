package com.anjan.labs.filterandmap;

import com.anjan.labs.filterandmap.dao.Student;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class FilterMapBasics {

    /**
     * Problem 1: Filtering and Mapping (Basic)
     * Scenario: You have a list of strings representing names: ["Anna", "Bob", "Alexander", "Brian", "Alice"].
     * <p>
     * Goal: Use the Stream API to find all names that start with the letter "A", convert them to uppercase, and collect them into a new list.
     * <p>
     * Expected Result: ["ANNA", "ALEXANDER", "ALICE"]
     */
    public List<String> problem_1(List<String> names) {

        log.info(" Problem 1: Filtering and Mapping (Basic) ");
        log.info(" Scenario: You have a list of strings representing names: [\"Anna\", \"Bob\", \"Alexander\", \"Brian\", \"Alice\"]. ");
        log.info(" Goal: Use the Stream API to find all names that start with the letter \"A\", convert them to uppercase, and collect them into a new list.");

        List<String> nameStartsWithAtoUpperCase = names.stream().filter(name -> name.startsWith("A")).map(String::toUpperCase).toList();

        log.info("Expected Result: [\"ANNA\", \"ALEXANDER\", \"ALICE\"]");
        log.info("Actual Result: {} ", nameStartsWithAtoUpperCase);
        return nameStartsWithAtoUpperCase;
    }

    /**
     * Problem 2: Filtering and Sorting (Easy-Medium)
     * Scenario: You have a list of integers: [15, 2, 8, 25, 4, 10, 1]
     * <p>
     * Goal:
     * 1.  Filter out the numbers less than 5.
     * 2.  Sort the remaining numbers in descending order.
     * 3.  Collect the result into a List.
     * <p>
     * Expected Result: [25, 15, 10, 8]
     */
    public void problem_2(List<Integer> integerList) {

        log.info("Problem 2: Filtering and Sorting (Easy-Medium) ");
        log.info(" Scenario: You have a list of integers: [15, 2, 8, 25, 4, 10, 1] ");
        log.info("     * Goal:\n" +
                "     * 1.  Filter out the numbers less than 5.\n" +
                "     * 2.  Sort the remaining numbers in descending order.\n" +
                "     * 3.  Collect the result into a List.\n");
        List<Integer> resultAscendingOrder = integerList.stream()
                .filter(member -> member >= 5)
                .sorted()
                .toList();

        List<Integer> resultDescendingOrder = integerList.stream()
                .filter(member -> member >= 5)
                .sorted(Comparator.reverseOrder())
                .toList();

        log.info("Expected Result: [25, 15, 10, 8]");
        log.info("Actual result : {} ", resultDescendingOrder);

    }


    /**
     * Problem 3: Basic Statistics (Medium)
     * Now let's try moving from just collecting lists to calculating values.
     * Scenario: You have a list of integers: [10, 20, 30, 40, 50]
     * Goal:
     * 1.  Square each number (multiply it by itself).
     * 2.  Calculate the average of those squared numbers.
     * 3.  The result should be a double.
     * <p>
     * Hint: Look into mapToInt() and average().
     * Expected Result: 1100.0 ($(100 + 400 + 900 + 1600 + 2500) / 5 = 1100$)
     */
    public void problem_3(List<Integer> integerList) {

        log.info(" Problem 3: Basic Statistics (Medium) ");
        log.info(" Scenario: You have a list of integers: [10, 20, 30, 40, 50] ");
        log.info("   Goal:\n" +
                "      1.  Square each number (multiply it by itself).\n" +
                "      2.  Calculate the average of those squared numbers.\n" +
                "      3.  The result should be a double.");

        double result = integerList.stream()
                .mapToDouble(member -> Math.pow(member, 2))
                .average()
                .getAsDouble();

        log.info(" Expected Result: 1100.0 ((100 + 400 + 900 + 1600 + 2500) / 5 = 1100) ");
        log.info(" Actual input : {} and result : {} ", integerList, result);

        result = IntStream.rangeClosed(0, integerList.size() - 1)
                .mapToDouble(index -> Math.pow(integerList.get(index), 2))
                .average()
                .orElse(0.0);

        log.info(" Actual input : {} and result using IntStream : {} ", integerList, result);
    }

    /**
     * Problem 4: The reduce operation
     * Scenario: List of strings: ["Java", "Python", "JavaScript", "C++"]
     * Goal: Concatenate them with a hyphen (-) using .reduce().
     * <p>
     * Think of reduce as a folding operation.
     * It takes the first two elements, combines them, then takes that result and combines it with the third, and so on.
     * <p>
     * Structure: .reduce((accumulator, element) -> ...)
     */
    public void problem_4(List<String> stringList) {

        log.info(" Problem 4: The reduce operation ");
        log.info(" Scenario: List of strings: [\"Java\", \"Python\", \"JavaScript\", \"C++\"] ");
        log.info(" Goal: Concatenate them with a hyphen (-) using .reduce(). ");

        String result = stringList.stream()
                .reduce((s1, s2) -> s1 + "-" + s2)
                .map(String::valueOf)
                .orElse("");

        log.info(" Actual input : {} and result using reduce : {} ", stringList, result);

    }

    /**
     * Problem 5: Moving to Objects (Medium)
     * data :
     * List<Student> students = List.of(
     *     new Student("Alice", 85.0, "CS"),
     *     new Student("Bob", 45.0, "CS"),
     *     new Student("Charlie", 92.0, "Math"),
     *     new Student("David", 30.0, "Bio")
     * );
     *
     * The Goal: 1. Filter students who have a grade greater than 50 (passing).
     * 2. Get only their names.
     * 3. Join the names into a single String separated by a comma and a space (", ").
     *
     * Hint: While you could use reduce for joining, Java has a built-in collector called Collectors.joining(", ") that is much cleaner!
     *
     */
    public void problem_5(List<Student> students){

        log.info (" Problem 5: Moving to Objects (Medium) ");

        String result =  students.stream()
                .filter(student -> student.grade() > 50)
                .map(Student::name)
                .reduce((s1, s2) -> s1 + ", " + s2)
                .orElse("No students found");

        log.info(" Actual input : {} and result using reduce : {} ", students, result);

        result =  students.stream()
                .filter(student -> student.grade() > 50)
                .map(Student::name)
                .collect(Collectors.joining(", "));

        log.info(" Actual input : {} and result using Collectors.joining : {} ", students, result);
    }
}
