package com.anjan.labs.filterandmap;

import com.anjan.labs.filterandmap.dao.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class FilterMapBasicsTest {

    @Test
    public void problem_1_test() {

        List<String> list = Arrays.asList("Anna", "Bob", "Alexander", "Brian", "Alice");
        FilterMapBasics filterMapBasics = new FilterMapBasics();
        filterMapBasics.problem_1(list);
    }

    @Test
    public void problem_2_test() {

        List<Integer> list = Arrays.asList(15, 2, 8, 25, 4, 10, 1);
        FilterMapBasics filterMapBasics = new FilterMapBasics();
        filterMapBasics.problem_2(list);
    }

    @Test
    public void problem_3_test() {

        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        FilterMapBasics filterMapBasics = new FilterMapBasics();
        filterMapBasics.problem_3(list);
    }

    @Test
    public void problem_4_test() {

        List<String> list = Arrays.asList("Java", "Python", "JavaScript", "C++");
        FilterMapBasics filterMapBasics = new FilterMapBasics();
        filterMapBasics.problem_4(list);
    }

    @Test
    public void problem_5_test() {
        List<Student> students = List.of(
                new Student("Alice", 85.0, "CS"),
                new Student("Bob", 45.0, "CS"),
                new Student("Charlie", 92.0, "Math"),
                new Student("David", 30.0, "Bio")
        );
        FilterMapBasics filterMapBasics = new FilterMapBasics();
        filterMapBasics.problem_5(students);
    }
}
