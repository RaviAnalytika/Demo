package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Projects;
import com.demo.repository.ProjectRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProjectController {

	@Autowired
	private ProjectRepository projectRepo;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAllProject")
	public List<Projects> getAllProjects() {		
		List<Projects> ee=  projectRepo.findAll();
		
		if(ee == null) {
			System.out.println("No Project Found");
		}		
		return ee;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getProjectById/{pid}")
	public Optional<Projects> getProjectsById(@PathVariable("pid") int pid) {	
		
		Optional<Projects> p = projectRepo.findById(pid);	
		if(p == null) {
			System.out.println("No Detail Found");
		}		
		return p;
	}
	
}