package com.amit.streamOperation;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/* Use of AbstractMap.SimpleEntry
Asked in Publicis Sapient
Map<Department, List<Employee>> Filter all the employees whose age>50 and group them based on department id
Input :
Map created in the below main method
Map<Department, List<Employee>>

Output :
{ME=[Sheetal, Rashmi], IT=[Kamal]}
 */
public class HashMapOfObjectandListOfObject {
    public static void main(String[] args) {
        Employee emp1 = new Employee(12, "Amit", 40);
        Employee emp2 = new Employee(13, "Sumit", 50);
        Employee emp3 = new Employee(14, "Kamal", 60);
        Employee emp4 = new Employee(15, "Sheetal", 55);
        Employee emp5 = new Employee(16, "Rashmi", 57);

        Department dept1 = new Department(1, "IT");
        Department dept2 = new Department(2, "ME");

        Map<Department, List<Employee>> hm = new HashMap<>();
        hm.put(dept1, Arrays.asList(emp1, emp2, emp3));
        hm.put(dept2, Arrays.asList(emp4, emp5));

        Map<String, List<String>> collect = hm.entrySet()
                .stream()
                .flatMap(entry -> entry.getValue().stream().filter(x -> x.getAge() > 50)
                        .map(employee -> new AbstractMap.SimpleEntry<>(entry.getKey().deptName, employee.getName())))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
        System.out.println(collect);
    }
}

@Data
class Employee {
    int id;

    String name;

    int age;

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

@Data
class Department {

    int deptId;

    String deptName;

    public Department(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }
}