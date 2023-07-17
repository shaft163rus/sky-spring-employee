package pro.sky.skyspringemployee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyspringemployee.model.Employee;
import pro.sky.skyspringemployee.services.api.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")

public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{departmentName}/employees")
    public List<Employee> getAllEmployeesByDepartment(@PathVariable String departmentName){
        return departmentService.getAllEmployeesByDepartment(departmentName);    }

    @GetMapping(path = "/{departmentName}/salary/sum")
    public int sumSalaryByDepartment(@PathVariable String departmentName){
        return departmentService.sumSalaryByDepartment(departmentName);
    }

    @GetMapping(path = "/{departmentName}/salary/max")
    public int maxSalaryByDepartment(@PathVariable String departmentName){
        return departmentService.maxSalaryByDepartment(departmentName);
    }

    @GetMapping(path = "/{departmentName}/salary/min")
    public int minSalaryByDepartment(@PathVariable String departmentName){
        return departmentService.minSalaryByDepartment(departmentName);
    }

    @GetMapping(path = "/employees")
    public Map<String, List<Employee>> getAllEmployeesSortedByDepartment(){
        return departmentService.getAllEmployeesSortedByDepartments();
    }
}
