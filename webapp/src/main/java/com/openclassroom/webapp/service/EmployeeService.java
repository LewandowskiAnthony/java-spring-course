package com.openclassroom.webapp.service;

import com.openclassroom.webapp.model.Employee;
import com.openclassroom.webapp.repository.EmployeeProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class EmployeeService {

    @Autowired
    EmployeeProxy EMPX;

    public Employee getEmployee(final Long id){
        return EMPX.getAnEmployee(id);
    }

    public Iterable<Employee> getEmployees(){
        return EMPX.getEmployees();
    }

    public Employee saveEmployee(Employee anEmployee){
        if(anEmployee.getId() == null){
            return EMPX.postEmployee(anEmployee);
        } else {
            return EMPX.updateEmployee(anEmployee);
        }
    }

    public void deleteEmployee(Long id){
        EMPX.removeAnEmployee(id);
    }
}
