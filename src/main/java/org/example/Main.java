package org.example;

import org.example.entity.Employee;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static List<Employee> findDuplicates(List<Employee> employeeList) {
        Set<Employee> seenEmployees = new HashSet<>();
        List<Employee> duplicatesList = new LinkedList<>();

        for (Employee employee : employeeList) {
            if (employee != null) {
                if (!seenEmployees.add(employee)) {
                    duplicatesList.add(employee);
                }
            }
        }
        return duplicatesList;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employeeList) {
        Map<Integer, Employee> uniqueMap = new HashMap<>();
        Set<Employee> seen = new HashSet<>();
        Set<Employee> duplicates = new HashSet<>();

        for (Employee employee : employeeList) {
            if (employee != null) {
                if (!seen.add(employee)) {
                    duplicates.add(employee);
                }
            }
        }

        for (Employee employee : employeeList) {
            if (employee != null) {
                if (!duplicates.contains(employee)) {
                    uniqueMap.put(employee.getId(), employee);
                } else {
                    if (!uniqueMap.containsKey(employee.getId())) {
                        uniqueMap.put(employee.getId(), employee);
                    }
                }
            }
        }
        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employeeList) {
        Set<Employee> seenOnce = new HashSet<>();
        Set<Employee> seenMoreThanOnce = new HashSet<>();

        for (Employee employee : employeeList) {
            if (employee != null) {
                if (!seenOnce.add(employee)) {
                    seenMoreThanOnce.add(employee);
                }
            }
        }

        List<Employee> result = new LinkedList<>();
        for (Employee employee : employeeList) {
            if (employee != null && !seenMoreThanOnce.contains(employee)) {
                result.add(employee);
            }
        }
        return result;
    }
}