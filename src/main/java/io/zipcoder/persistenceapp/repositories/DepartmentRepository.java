package io.zipcoder.persistenceapp.repositories;

import io.zipcoder.persistenceapp.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
