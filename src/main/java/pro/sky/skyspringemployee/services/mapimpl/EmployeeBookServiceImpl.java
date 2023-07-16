package pro.sky.skyspringemployee.services.mapimpl;

import org.springframework.stereotype.Service;
import pro.sky.skyspringemployee.model.Employee;
import pro.sky.skyspringemployee.repository.EmployeeBookRepository;
import pro.sky.skyspringemployee.services.api.EmployeeBookService;


@Service
public class EmployeeBookServiceImpl implements EmployeeBookService {

    private final EmployeeBookRepository employeeRepository;

    public EmployeeBookServiceImpl(EmployeeBookRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public String addEmployee(String name, int salary, String department) {

        Employee employee = new Employee(name, salary, department);

        return employeeRepository.saveEmployee(employee).toString();
    }


    @Override
    public String removeEmployeeByName(String name) {

        return employeeRepository.removeEmployeeByName(name).toString();
    }

    @Override
    public String findEmployeeByName(String name) {

        return employeeRepository.findEmployeeByName(name).toString();
    }


}
