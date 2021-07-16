package com.thirdmonth.employeemanagement.modules.service;

import com.thirdmonth.employeemanagement.modules.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeesService {

    EmployeesRepository employeesRepository;

    @Autowired
    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

//    getAll

//    save

//    delete

//    update

}
