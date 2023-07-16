package pro.sky.skyspringemployee.services.api;

public interface EmployeeBookService {

    String addEmployee(String name, int salary, String department);

    String removeEmployeeByName(String name);

    String findEmployeeByName(String name);

}
