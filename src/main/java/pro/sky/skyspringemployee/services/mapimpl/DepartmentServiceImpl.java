package pro.sky.skyspringemployee.services.mapimpl;

import org.springframework.stereotype.Service;
import pro.sky.skyspringemployee.model.Employee;
import pro.sky.skyspringemployee.repository.EmployeeBookRepository;
import pro.sky.skyspringemployee.services.api.DepartmentService;

import java.util.List;
import java.util.Map;
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeBookRepository employeeDepartmentRepository;

    public DepartmentServiceImpl(EmployeeBookRepository employeeDepartmentRepository) {
        this.employeeDepartmentRepository = employeeDepartmentRepository;
    }

    @Override
    public int maxSalaryByDepartment(String department) {
        return employeeDepartmentRepository.maxSalaryByDepartment(department);
    }

    @Override
    public int minSalaryByDepartment(String department) {
        return employeeDepartmentRepository.minSalaryByDepartment(department);
    }

    @Override
    public int sumSalaryByDepartment(String department) {
        return employeeDepartmentRepository.sumSalaryByDepartment(department);
    }

    @Override
    public List<Employee> getAllEmployeesByDepartment(String department) {
        return employeeDepartmentRepository.getEmployeesByDepartment(department);
    }

    @Override
    public Map<String, List<Employee>> getAllEmployeesSortedByDepartments() {
        return employeeDepartmentRepository.getAllEmployeesSortedByDepartments();
    }
}
