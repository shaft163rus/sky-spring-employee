package pro.sky.skyspringemployee.services.api;

import pro.sky.skyspringemployee.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    int maxSalaryByDepartment(String department);
    int minSalaryByDepartment(String department);
    int sumSalaryByDepartment(String department);

    List<Employee> getAllEmployeesByDepartment(String department);

    Map<String, List<Employee>> getAllEmployeesSortedByDepartments();
}
