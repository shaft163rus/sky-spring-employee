package pro.sky.skyspringemployee.repository;

import org.springframework.stereotype.Repository;
import pro.sky.skyspringemployee.model.Employee;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeBookRepository {


    private final Map<String, Employee> employees = new HashMap<>();


    public Employee saveEmployee(Employee employee) {
        if (employees.containsKey(employee.getName()))
            throw new RuntimeException("Employee already exists");

        employees.put(employee.getName(), employee);
        return employee;
    }

    public Employee removeEmployeeByName(String name) {
        if (employees.containsKey(name)) {
            throw new RuntimeException("Employee does not exists");
        }

        return employees.get(name);
    }

    public Employee findEmployeeByName(String name) {
        if (!employees.containsKey(name)) {
            throw new RuntimeException("Employee is not in database");
        }

        return employees.get(name);

    }


}
