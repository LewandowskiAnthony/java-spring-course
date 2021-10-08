package com.openclassroom.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.openclassroom.api.model.Employee;
import com.openclassroom.api.repository.EmployeeRepository;

import lombok.Data;

@Data
@Service
public class EmployeeService {

    // Récupération de l'interface permettant l'utilisation de CrudRepository
    // Voir la Javadoc de Crud Repository pour le listing des méthodes

    @Autowired
    EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployee(final long id){
        return employeeRepository.findById(id);
    }

    public Iterable<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee;
    }

    public void deleteEmployee(Long employeeID) {
        employeeRepository.deleteById(employeeID);
    }

}
