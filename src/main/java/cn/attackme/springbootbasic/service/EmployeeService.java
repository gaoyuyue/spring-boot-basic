package cn.attackme.springbootbasic.service;

import cn.attackme.springbootbasic.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static List<Employee> employees = new ArrayList<>();

    public List<Employee> getAll() {
        return employees;
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void deleteById(Long id) {
        employees.removeIf(e -> e.getId().equals(id));
    }

    public void update(Employee employee) {
        Employee old = employees.stream().filter(e -> e.getId().equals(employee.getId())).findFirst().get();
        old.setAge(employee.getAge());
        old.setGender(employee.getGender());
        old.setName(employee.getName());
    }
}
