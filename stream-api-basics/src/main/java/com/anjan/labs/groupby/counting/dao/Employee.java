package com.anjan.labs.groupby.counting.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee implements Serializable {

    private long employeeCode;
    private String name;
    private String department;
    private String salary;

}
