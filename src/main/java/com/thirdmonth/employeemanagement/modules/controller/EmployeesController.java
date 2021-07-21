package com.thirdmonth.employeemanagement.modules.controller;

import com.thirdmonth.employeemanagement.modules.models.EmployeesModel;
import com.thirdmonth.employeemanagement.modules.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String all(Model model) {
        model.addAttribute("employees", employeesService.all());
        return "employees-list";
    }

    //    GET /delete TODO try with <form>, not the <a>
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("employee_id") Long id) {

//        delete the employee
        employeesService.delete(id);

//        redirect to /employees/
        return "redirect:/employees/";
    }


    //    GET /form
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String getForm(Model model) {
        model.addAttribute("employee", new EmployeesModel());
        return "employees-form";
    }


    //    POST /form
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String postForm(EmployeesModel employeesModel) {
        employeesService.save(employeesModel);
        return "redirect:/employees/";
    }


    //    PUT /form
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String putForm(@RequestParam("employee_id") Long id, Model model) {
//        get the emploee from the service
        EmployeesModel employeesModel = employeesService.findById(id);

//        set the employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employeesModel);

//        send over to our form
        return "employees-form";
    }

}
