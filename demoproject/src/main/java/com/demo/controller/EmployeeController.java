package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employees;
import com.demo.repository.EmployeeRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAllEmployee")
	public List<Employees> getAllEmployee() {		
		List<Employees> ee=  employeeRepository.findAll();
		
		if(ee == null) {
			System.out.println("No record Found");
		}		
		return ee;
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getEmployeeById/{eid}")
	public Optional<Employees> getEmployeeNyId(@PathVariable("eid") int eid) {		
		System.out.println(eid + "----");
		Optional<Employees> y = employeeRepository.findById(eid);		
		if(y == null) {
			System.out.println("No record Found");
		}		
		return y;
	}
	
	
	@PostMapping("/saveEmployee")
	public String saveEmployee() {
		Employees ee = new Employees();
		ee.setName("Test");
		ee.setAddress("Indo");
		employeeRepository.save(ee);
		System.out.println(ee.toString());
		
		return "Success";
	}
}