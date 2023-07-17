package pro.sky.skyspringemployee.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.skyspringemployee.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeBookRepositoryTest {
    private EmployeeBookRepository employeeBookRepository;

    private Employee expectedEmployee;
    private Employee expectedEmployee2;
    private Employee expectedEmployee3;

    @BeforeEach
    public void setUp() {
        employeeBookRepository = new EmployeeBookRepository();
        expectedEmployee = new Employee("John", 2000, "Managers");
        expectedEmployee2 = new Employee("Victor", 3000, "Managers");
        expectedEmployee3 = new Employee("Dina", 5000, "Managers");

    }

    @Test
    void shouldReturnCorrectSumSalaryByDepartment() {
        employeeBookRepository.addEmployee(expectedEmployee);
        employeeBookRepository.addEmployee(expectedEmployee2);
        employeeBookRepository.addEmployee(expectedEmployee3);

        int result = employeeBookRepository.sumSalaryByDepartment("Managers");
        assertEquals(
                expectedEmployee.getSalary() +
                        expectedEmployee2.getSalary() +
                        expectedEmployee3.getSalary(), result);
    }

    @Test
    void shouldReturnCorrectMinSalaryByDepartment() {
        employeeBookRepository.addEmployee(expectedEmployee);
        employeeBookRepository.addEmployee(expectedEmployee2);


        int result = employeeBookRepository.minSalaryByDepartment("Managers");
        assertEquals(Math.min(expectedEmployee.getSalary(), expectedEmployee2.getSalary()), result);
    }

    @Test
    void shouldReturnCorrectMaxSalaryByDepartment() {
        employeeBookRepository.addEmployee(expectedEmployee);
        employeeBookRepository.addEmployee(expectedEmployee2);


        int result = employeeBookRepository.maxSalaryByDepartment("Managers");
        assertEquals(Math.max(expectedEmployee.getSalary(), expectedEmployee2.getSalary()), result);
    }


    @Test
    void shouldReturnCorrectAllEmployeesSortedByDepartments() {
        employeeBookRepository.addEmployee(expectedEmployee);
        employeeBookRepository.addEmployee(expectedEmployee2);
        employeeBookRepository.addEmployee(expectedEmployee3);

        Map<String, List<Employee>> result = employeeBookRepository.getAllEmployeesSortedByDepartments();

        Map<String, List<Employee>> sortedResult = new TreeMap<>(employeeBookRepository.getAllEmployeesSortedByDepartments());

        assertEquals(3, result.get("Managers").size());

        assertEquals(sortedResult.get("Managers").get(0).getName(), result.get("Managers").get(0).getName());
        assertEquals(sortedResult.get("Managers").get(1).getName(), result.get("Managers").get(1).getName());
        assertEquals(sortedResult.get("Managers").get(2).getName(), result.get("Managers").get(2).getName());
    }

    @Test
    void shouldReturnCorrectEmployeesByDepartment() {
        employeeBookRepository.addEmployee(expectedEmployee);
        employeeBookRepository.addEmployee(expectedEmployee2);
        employeeBookRepository.addEmployee(expectedEmployee3);

        List<Employee> result = employeeBookRepository.getEmployeesByDepartment("Managers");

        List<Employee> sortedResult = new ArrayList<>(employeeBookRepository.getEmployeesByDepartment("Managers"));

        assertEquals(3, result.size());

        assertEquals(sortedResult.get(0).getName(), result.get(0).getName());
        assertEquals(sortedResult.get(1).getName(), result.get(1).getName());
        assertEquals(sortedResult.get(2).getName(), result.get(2).getName());
    }





}
