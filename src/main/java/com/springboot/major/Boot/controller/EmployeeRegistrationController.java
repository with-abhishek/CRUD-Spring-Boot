package com.springboot.major.Boot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.springboot.major.Boot.model.Employee;
import com.springboot.major.Boot.service.EmployeeService;

@Controller
public class EmployeeRegistrationController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRegistrationController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/searchEmp")
    public String searchEmployee(@RequestParam int id, Model model) {
        Employee emp = employeeService.getEmployeeById(id);
        if (emp != null) {
            model.addAttribute("emp", emp);
            return "done";
        }
        model.addAttribute("id", id);
        return "error";
    }

    @RequestMapping("/find")
    public String searchMethod() {
        return "search";
    }

    @RequestMapping("/viewEmp")
    public String listEmps(Model model) {
        List<Employee> list = employeeService.listEmployees();
        model.addAttribute("list", list);
        return "viewEmp";
    }

    @RequestMapping("/deleteEmp/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.removeEmployee(id);
        return "redirect:/viewEmp";
    }

    @RequestMapping("/updateEmp/{id}")
    public String updateEmployee(@PathVariable int id, Model model) {
        Employee emp = employeeService.getEmployeeById(id);
        System.out.println(emp);
        model.addAttribute("emp", emp);
        return "update";
    }

    @RequestMapping("/updateSave/{id}")
    public String updateSave(@ModelAttribute("emp") Employee emp,@PathVariable int id) {
    	 employeeService.updateEmployee(emp, id);
        return "redirect:/viewEmp";
    }

    @RequestMapping("/registration-form")
    public String registrationForm(Model model) {
        model.addAttribute("emp", new Employee());
        return "registration";
    }

    @RequestMapping("/registerEmp")
    public String registered(@ModelAttribute Employee emp) {
        employeeService.addEmployee(emp);
        return "registered"; 
    }
}