package com.thirdmonth.employeemanagement.modules.controller;

import com.thirdmonth.employeemanagement.modules.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("api/v1/employees")
@RequestMapping("/employees")
public class EmployeesController {
    EmployeesService employeesService;

    @Autowired
    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

//    GET /
//    shows all data in a list

//    POST /  ** do i need this? **
//    registers a model object

//    DELETE /{id}
//    deletes a object by its given id

//    PUT /form
//    updates a existing object

//    GET /form
//    shows the empty form ready to be filled


//    POST /form
//    registers a new model object

}
