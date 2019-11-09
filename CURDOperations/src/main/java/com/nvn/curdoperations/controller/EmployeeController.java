package com.nvn.curdoperations.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nvn.curdoperations.model.Employee;
import com.nvn.curdoperations.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/")
	public String getEmployees(Model model) {
		List<Employee> allEmployees = employeeService.getAllEmloyees();
		System.out.println(allEmployees);
		model.addAttribute("employees", allEmployees);
		model.addAttribute("employee", new Employee());
		model.addAttribute("title", "Employees");
		model.addAttribute("isAdd", true);
		return "view/employees";
	}

	@PostMapping(value = "/save")
	public String save(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes, Model model) {
		employee.setCreatedDate(LocalDateTime.now());
		employee.setUpdatedDate(LocalDateTime.now());
		System.out.println("local date time :::: "+LocalDateTime.now());
		Employee emp = employeeService.save(employee);
		if (emp != null) {
			redirectAttributes.addFlashAttribute("successmessage", "Employee is saved successfully..");
			return "redirect:/";
		} else {
			model.addAttribute("errormessage", "employee is not save, Please try again..!");
			model.addAttribute("employee", employee);
			return "view/employees";
		}
	}

	@GetMapping(value = "/getEmployee/{id}")
	public String getEmployee(@PathVariable Long id, Model model) {

		Employee employee = employeeService.findById(id);

		List<Employee> allEmployees = employeeService.getAllEmloyees();

		model.addAttribute("employees", allEmployees);
		model.addAttribute("employee", employee);
		model.addAttribute("title", "Edit Employee");
		model.addAttribute("isAdd", false);
		return "view/employees";
	}

	@PostMapping(value = "/update")
	public String update(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes, Model model) {

		Employee emp = employeeService.update(employee);
		if (emp != null) {
			redirectAttributes.addFlashAttribute("successmessage", "Employee is updated successfully..");
			return "redirect:/";
		} else {
			model.addAttribute("errormessage", "employee is not updated, Please try again..!");
			model.addAttribute("employee", employee);
			return "view/employees";
		}
	}

	@GetMapping(value = "deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		System.out.println("selected emp id ::: " + id);
		employeeService.delete(id);
		redirectAttributes.addFlashAttribute("successmessage", "Employee is deleted successfully..");
		return "redirect:/";
	}
}
