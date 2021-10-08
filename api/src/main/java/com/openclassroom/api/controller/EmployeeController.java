package com.openclassroom.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.openclassroom.api.model.Employee;
import com.openclassroom.api.service.EmployeeService;

import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Read - Get all employees
     * @return - An Iterable object of Employee full filled
     */
    @GetMapping("/employees")
    public Iterable<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @RequestMapping(value="/employees/{ID}", method=RequestMethod.GET)
    public Optional<Employee> getAnEmployee(@PathVariable(value="ID") Long id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/addEmployee")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee createdEmployee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(createdEmployee), HttpStatus.CREATED);
    }

    @PatchMapping("/UpdateEmployees")
    public ResponseEntity<Employee> patchAnEmployee(@RequestBody Employee createdEmployee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(createdEmployee), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/employees/{ID}")
    public void deleteAnEmployee(@PathVariable(value="ID") Long id){
        employeeService.deleteEmployee(id);
    }


}