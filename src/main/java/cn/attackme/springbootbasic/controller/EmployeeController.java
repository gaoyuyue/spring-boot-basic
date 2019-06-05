package cn.attackme.springbootbasic.controller;

import cn.attackme.springbootbasic.model.Employee;
import cn.attackme.springbootbasic.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employees")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @PostMapping("/")
    public void add(@RequestBody Employee employee) {
        employeeService.add(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.deleteById(id);
    }

    @PutMapping("/")
    public void update(@RequestBody Employee employee) {
        employeeService.update(employee);
    }
}
