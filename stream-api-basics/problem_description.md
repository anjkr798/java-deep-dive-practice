# Problem Descriptions

This file lists all the problems and exercises implemented in this project, organized by category.

## Part 1: Filtering, Mapping, and Basic Reductions
Located in `FilterMapBasics.java`

### Problem 1: Filtering and Mapping (Basic)
- **Scenario:** A list of strings representing names: `["Anna", "Bob", "Alexander", "Brian", "Alice"]`.
- **Goal:** Find all names that start with the letter "A", convert them to uppercase, and collect them into a new list.
- **Expected Result:** `["ANNA", "ALEXANDER", "ALICE"]`

### Problem 2: Filtering and Sorting (Easy-Medium)
- **Scenario:** A list of integers: `[15, 2, 8, 25, 4, 10, 1]`.
- **Goal:** Filter out numbers less than 5, sort the remaining numbers in descending order, and collect into a list.
- **Expected Result:** `[25, 15, 10, 8]`

### Problem 3: Basic Statistics (Medium)
- **Scenario:** A list of integers: `[10, 20, 30, 40, 50]`.
- **Goal:** Square each number and calculate the average of those squared numbers.
- **Expected Result:** `1100.0`

### Problem 4: The reduce operation
- **Scenario:** List of strings: `["Java", "Python", "JavaScript", "C++"]`.
- **Goal:** Concatenate them with a hyphen (-) using `.reduce()`.
- **Expected Result:** `"Java-Python-JavaScript-C++"`

### Problem 5: Moving to Objects (Medium)
- **Scenario:** A list of `Student` objects.
- **Goal:** Filter students with a grade > 50, get their names, and join them into a single string separated by ", ".
- **Expected Result:** A string of names like `"Alice, Charlie"`.

---

## Part 2: Grouping and Counting (Advanced)
Located in `GroupingByAndCountingBasics.java`

### Problem 6: Grouping (Advanced)
- **Goal:** Group students by their department.
- **Data Structure:** Result is a `Map<String, List<Student>>`.
- **Expected Result:** Departments mapping to lists of students.

### Problem 7: Grouping and Counting (Advanced+)
- **Goal:** Create a map where the key is the department and the value is the number of students in that department.
- **Data Structure:** Result is a `Map<String, Long>`.
- **Hint:** Use `Collectors.groupingBy` with `Collectors.counting()` as a downstream collector.

### Problem 8: Grouping and Averaging (Complex)
- **Goal:** Find the average grade for each department.
- **Data Structure:** Result is a `Map<String, Double>`.
- **Hint:** Use `Collectors.averagingDouble()`.

### Problem 9: Partitioning (The "Boolean" Group)
- **Goal:** Split students into two groups: "Passed" (grade >= 60) and "Failed" (grade < 60).
- **Data Structure:** Result is a `Map<Boolean, List<Student>>`.
- **Hint:** Use `Collectors.partitioningBy()`.
- **Extended:** Also demonstrates mapping within partitions to return names or summary records.

---

## Part 3: Real-world Grouping and Aggregation Scenarios
Located in `StreamApiCounting.java`

### Basic Frequency Count (Strings)
- **Scenario:** A list of words like `["apple", "banana", "apple", "cherry", "banana", "apple"]`.
- **Goal:** Find the frequency of each unique word in the list.
- **Technique:** `Collectors.groupingBy(Function.identity(), Collectors.counting())`.

### Employee Grouping by Property
- **Scenario:** A list of `Employee` objects with `id`, `name`, `department`, and `salary`.
- **Goals:**
    1. Count employees in each department.
    2. Get a list of employee names for each department.
    3. Identify the department with the maximum total salary.
- **Techniques:** `Collectors.groupingBy` with `Collectors.counting()`, `Collectors.mapping()`, and `Collectors.summingDouble()`.

### Grouping by Derived Criteria
- **Scenario:** A list of strings of varying lengths.
- **Goal:** Group strings by their length and count them, or list the strings of each length.
- **Technique:** `Collectors.groupingBy(String::length, ...)` with downstream collectors.
