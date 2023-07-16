package pro.sky.skyspringemployee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyspringemployee.services.api.EmployeeBookService;

@RestController

public class EmployeeBookController {

    private final EmployeeBookService employeeBookService;

    public EmployeeBookController(EmployeeBookService employeeBookService) {
        this.employeeBookService = employeeBookService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("name") String name,
                              @RequestParam("salary") int salary,
                              @RequestParam("department") String department) {
        return employeeBookService.addEmployee(name, salary, department);
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("name") String name) {
        return employeeBookService.removeEmployeeByName(name);
    }

    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("name") String name) {
        return employeeBookService.findEmployeeByName(name);
    }
}
