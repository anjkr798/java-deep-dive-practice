package com.anjan.labs.groupby.counting;

import com.anjan.labs.filterandmap.dao.Student;
import com.anjan.labs.filterandmap.dao.StudentSummary;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class GroupingByAndCountingBasics {


    /**
     * Problem 6: Grouping (Advanced)
     * record Student(String name, double grade, String department) {}
     * <p>
     * List<Student> students = List.of(
     * new Student("Alice", 85.0, "CS"),
     * new Student("Bob", 45.0, "CS"),
     * new Student("Charlie", 92.0, "Math"),
     * new Student("David", 30.0, "Bio"),
     * new Student("Eve", 88.0, "Math")
     * );
     * <p>
     * Goal: Group the students by their department.
     * The result should be a Map<String, List<Student>> where the key is the department name and the value is a list of students in that department.
     * <p>
     * Expected Result:
     * CS -> [Alice, Bob]
     * Math -> [Charlie, Eve]
     * Bio -> [David]
     * <p>
     * Hint: Use Collectors.groupingBy() inside the .collect() method.
     */
    public void problem_6(List<Student> students) {

        log.info(" Problem 6: Grouping (Advanced) ");

        Map<String, List<Student>> result =
                students.stream()
                        .collect(Collectors.groupingBy(Student::department));

        log.info("Actual input: = {} ", students);
        log.info("Actual Result: {} ", result);
    }

    /**
     * Problem 7: Grouping and Counting (Advanced+)
     * <p>
     * Scenario: Same Student list.
     * Goal: Create a Map<String, Long> where the key is the department and the value is the number of students in that department.
     * Hint: groupingBy can take a second argument called a "downstream collector." You'll want to use Collectors.counting() as that second argument.
     * <p>
     * Expected Result:
     * CS -> 2
     * Math -> 2
     * Bio -> 1
     */
    public void problem_7(List<Student> students) {

        Map<String, Long> result = students.stream().collect(Collectors.groupingBy(Student::department, Collectors.counting()));
        log.info("Actual input: = {} ", students);
        log.info("Actual Result: {} ", result);
    }

    /**
     * Problem 8: Grouping and Averaging (Complex)
     * Let's push the complexity one notch higher. This is a very common real-world data processing task.
     * <p>
     * Scenario: Same Student list.
     * Goal: Find the average grade for each department.
     * <p>
     * The result should be a Map<String, Double>, where the key is the department and the value is the average grade of students in that department.
     * <p>
     * Hint: Instead of counting(), you’ll need a collector that can look at the grade property and calculate an average. Check out Collectors.averagingDouble().
     */
    public void problem_8(List<Student> students) {

        Map<String, Double> result = students.stream()
                .collect(Collectors.groupingBy(Student::department, Collectors.averagingDouble(Student::grade)));
        log.info("Actual input: = {} ", students);
        log.info("Actual Result: {} ", result);
    }

    /**
     * Problem 9: Partitioning (The "Boolean" Group)
     * <p>
     * Sometimes you don't need a full grouping by a string; you just need to split a list into two groups:
     * those who match a condition and those who don't.Scenario: Same Student list.
     * <p>
     * Goal: Split the students into two groups: "Passed" (grade $\geq$ 60) and "Failed" (grade < 60).
     * The result should be a Map<Boolean, List<Student>>.
     * Hint: While you could use groupingBy,
     * there is a specialized collector called Collectors.partitioningBy() that is designed specifically for boolean conditions.
     * <p>
     * Data Reminder:
     * Alice (85), Bob (45), Charlie (92), David (30), Eve (88)
     * <p>
     * Expected Result:
     * true -> [Alice, Charlie, Eve]
     * false -> [Bob, David]
     */
    public void problem_9(List<Student> students) {

        Map<Boolean, List<Student>> result = students
                .stream()
                .collect(Collectors.partitioningBy(student -> student.grade() > 60, Collectors.toList()));
        log.info("Actual input: = {} ", students);
        log.info("Actual Result: {} ", result);

        Map<String, List<String>> result1 = students
                .stream()
                .collect(Collectors.groupingBy(student -> student.grade() > 60 ? "PASSED" : "FAILED",
                        Collectors.mapping(Student::name, Collectors.toList())));

        log.info("Actual input: = {} ", students);
        log.info("Actual Result: {} ", result1);

        Map<String, List<StudentSummary>> result2 = students
                .stream()
                .collect(Collectors.groupingBy(student -> student.grade() > 60 ? "PASSED" : "FAILED",
                        Collectors.mapping(student -> StudentSummary.builder().name(student.name()).department(student.department()).build()
                                , Collectors.toList()
                        )));

        log.info("Actual input: = {} ", students);
        log.info("Actual Result: {} ", result2);
    }
}
