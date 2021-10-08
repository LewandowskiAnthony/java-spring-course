package com.openclassroom.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.api.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    // Class crud repository en héritage
    // Permet la récupération dé méthodes avec le passag via généricité du type de données gérée et du type de l'ID
}
