package pro.sky.skyspringemployee.repository;

import org.springframework.stereotype.Repository;
import pro.sky.skyspringemployee.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Repository
public class EmployeeBookRepository {

    private Stream<Employee> buildDepartmentStream(String department){
        return employees.values().stream()
                .filter(employee -> employee.getDepartment().equals(department));
    }


    private final Map<String, Employee> employees = new HashMap<>();


    public Employee addEmployee(Employee employee) {
        if (employees.containsKey(employee.getName()))
            throw new RuntimeException("Employee already exists");

        employees.put(employee.getName(), employee);
        return employee;
    }

    public Employee removeEmployeeByName(String name) {
        if (!employees.containsKey(name)) {
            throw new RuntimeException("Employee does not exists");
        }

        return employees.remove(name);
    }

    public Employee findEmployeeByName(String name) {
        if (!employees.containsKey(name)) {
            throw new RuntimeException("Employee is not in database");
        }

        return employees.get(name);

    }

    public int sumSalaryByDepartment(String department) {
        return buildDepartmentStream(department).mapToInt(Employee::getSalary).sum();
    }

    public int minSalaryByDepartment(String department) {
        return buildDepartmentStream(department)
                .filter(e -> e.getDepartment().contains(department))
                .map(Employee::getSalary)
                .min(Integer::compare)
                .orElseThrow(() -> new RuntimeException("Employee with min salary is not found"));
    }

    public int maxSalaryByDepartment(String department) {
        return buildDepartmentStream(department)
                .filter(e -> e.getDepartment().contains(department))
                .map(Employee::getSalary)
                .max(Integer::compare)
                .orElseThrow(() -> new RuntimeException("Employee with max salary is not found"));
    }


    public Map<String, List<Employee>> getAllEmployeesSortedByDepartments() {
        return employees.values().stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return buildDepartmentStream(department)
                .collect(Collectors.toList());
    }



}
