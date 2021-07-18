package com.thirdmonth.employeemanagement.modules.service;

import com.thirdmonth.employeemanagement.modules.models.EmployeesModel;
import com.thirdmonth.employeemanagement.modules.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService {

    EmployeesRepository employeesRepository;

    @Autowired
    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    //    getAll
    public List<EmployeesModel> all() {
        return employeesRepository.findAll();
    }

    //    save
    public EmployeesModel save(EmployeesModel employeesModel) {
        return employeesRepository.save(employeesModel);
    }

    //    delete
    public Long delete(Long id) {
        Optional<EmployeesModel> employeesModel = employeesRepository.findById(id);
        if (employeesModel.isPresent()) {
            employeesRepository.delete(employeesModel.get());
        }
        return Long.valueOf(-1);
    }

//    update

}
