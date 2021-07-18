package com.thirdmonth.employeemanagement.modules.controller;

import com.thirdmonth.employeemanagement.modules.models.EmployeesModel;
import com.thirdmonth.employeemanagement.modules.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<EmployeesModel> all() {
        return employeesService.all();
    }

    //    POST /  TODO ** do i really need this? **
    //    registers a model object
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public EmployeesModel save(EmployeesModel employeesModel) {
        return employeesService.save(employeesModel);
    }

    //    DELETE /{id}
    //    deletes a object by its given id
    //    TODO @RequestParam
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Long delete(@PathVariable Long id) {
        return employeesService.delete(id);
    }


    //    GET /form
    //    shows the empty form ready to be filled
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String getForm(Model model) {
        model.addAttribute("employee", new EmployeesModel());
        return "";
    }


    //    POST /form
    //    registers a new model object
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public EmployeesModel postForm(EmployeesModel employeesModel) {
        return employeesService.save(employeesModel);
    }

    //    PUT /form
    //    updates a existing object
    @RequestMapping(value = "/form", method = RequestMethod.PUT)
    public EmployeesModel putForm(EmployeesModel employeesModel) {
        return employeesService.update(employeesModel);
    }

}
