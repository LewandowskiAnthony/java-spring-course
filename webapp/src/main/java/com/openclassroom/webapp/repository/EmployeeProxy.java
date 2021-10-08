package com.openclassroom.webapp.repository;

import com.openclassroom.webapp.PropertiesConfiguration;
import com.openclassroom.webapp.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.client.RestTemplate;

@Repository
@Slf4j
public class EmployeeProxy {

    @Autowired
    PropertiesConfiguration properties;

    public Employee postEmployee(Employee e){
        String rootApiUrl = properties.getApiUrl();
        String employeesUrl = rootApiUrl + "/addEmployee";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Employee> request = new HttpEntity<Employee>(e);
        ResponseEntity<Employee> response = restTemplate.exchange(
                employeesUrl,
                HttpMethod.POST,
                request,
                Employee.class
        );

        log.debug("Get Employees call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Employee updateEmployee(Employee e){
        String rootApiUrl = properties.getApiUrl();
        String employeesUrl = rootApiUrl + "/updateEmployee";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Employee> request = new HttpEntity<Employee>(e);
        ResponseEntity<Employee> response = restTemplate.exchange(
                employeesUrl,
                HttpMethod.PATCH,
                request,
                Employee.class
        );

        log.debug("Get Employees call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public void removeAnEmployee(Long id){
        String rootApiUrl = properties.getApiUrl();
        String employeesUrl = rootApiUrl + "/employees/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> response = restTemplate.exchange(
                employeesUrl,
                HttpMethod.DELETE,
                null,
                Employee.class
        );

        log.debug("Get Employees call " + response.getStatusCode().toString());

    }

    /*
     *
     * Récupère les informations depuis l'API et les mets dans un objets Iterable en créant un nouvel objet employé à chaque fois
     * Importance de mettre la classe employée en common ?
     *
     */


    public Employee getAnEmployee(Long id){
        String rootApiUrl = properties.getApiUrl();
        String employeesUrl = rootApiUrl + "/employees/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> response = restTemplate.exchange(
                employeesUrl,
                HttpMethod.GET,
                null,
                Employee.class
        );

        log.debug("Get Employees call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Iterable<Employee> getEmployees(){
        String rootApiUrl = properties.getApiUrl();
        String employeesUrl = rootApiUrl + "/employees";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Employee>> response = restTemplate.exchange(
                employeesUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Employee>>() {}
        );

        log.debug("Get Employees call " + response.getStatusCode().toString());

        return response.getBody();
    }
}
