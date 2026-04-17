package com.anjan.labs.groupby.counting;

import com.anjan.labs.filterandmap.dao.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
public class GroupingByAndCountingBasicsTest {

    @Test
    public void problem_6_test() {

        List<Student> students = List.of(
                new Student("Alice", 85.0, "CS"),
                new Student("Bob", 45.0, "CS"),
                new Student("Charlie", 92.0, "Math"),
                new Student("David", 30.0, "Bio"),
                new Student("Eve", 88.0, "Math")
        );
        GroupingByAndCountingBasics groupingByAndCountingBasics = new GroupingByAndCountingBasics();
        groupingByAndCountingBasics.problem_6(students);
    }

    @Test
    public void problem_7_test() {

        List<Student> students = List.of(
                new Student("Alice", 85.0, "CS"),
                new Student("Bob", 45.0, "CS"),
                new Student("Charlie", 92.0, "Math"),
                new Student("David", 30.0, "Bio"),
                new Student("Eve", 88.0, "Math")
        );
        GroupingByAndCountingBasics groupingByAndCountingBasics = new GroupingByAndCountingBasics();
        groupingByAndCountingBasics.problem_7(students);
    }

    @Test
    public void problem_8_test() {

        List<Student> students = List.of(
                new Student("Alice", 85.0, "CS"),
                new Student("Bob", 45.0, "CS"),
                new Student("Charlie", 92.0, "Math"),
                new Student("David", 30.0, "Bio"),
                new Student("Eve", 88.0, "Math")
        );
        GroupingByAndCountingBasics groupingByAndCountingBasics = new GroupingByAndCountingBasics();
        groupingByAndCountingBasics.problem_8(students);
    }

    @Test
    public void problem_9_test() {

        List<Student> students = List.of(
                new Student("Alice", 85.0, "CS"),
                new Student("Bob", 45.0, "CS"),
                new Student("Charlie", 92.0, "Math"),
                new Student("David", 30.0, "Bio"),
                new Student("Eve", 88.0, "Math")
        );
        GroupingByAndCountingBasics groupingByAndCountingBasics = new GroupingByAndCountingBasics();
        groupingByAndCountingBasics.problem_9(students);
    }
}
