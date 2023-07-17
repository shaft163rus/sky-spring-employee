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

        return String.valueOf(employeeRepository.saveEmployee(employee));
    }


    @Override
    public String removeEmployeeByName(String name) {

        return String.valueOf(employeeRepository.removeEmployeeByName(name));
    }

    @Override
    public String findEmployeeByName(String name) {

        return String.valueOf(employeeRepository.findEmployeeByName(name));
    }


}
