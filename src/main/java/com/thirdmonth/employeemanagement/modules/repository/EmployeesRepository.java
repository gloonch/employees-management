package com.thirdmonth.employeemanagement.modules.repository;

import com.thirdmonth.employeemanagement.modules.models.EmployeesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeesModel, Long> {

}
