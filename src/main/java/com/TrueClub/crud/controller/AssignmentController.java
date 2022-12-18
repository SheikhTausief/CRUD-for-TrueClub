package com.TrueClub.crud.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TrueClub.crud.entity.Assignment;
import com.TrueClub.crud.service.AssignmentService;

@RestController
public class AssignmentController {

	@Autowired
	private AssignmentService service;
	
	@PostMapping("/addStudent")
	public Assignment addStudent(@RequestBody Assignment student)
	{
		return service.saveStudent(student);
	}
	
	@GetMapping("/student/{id}")
	public Optional<Assignment> findStudentById(@PathVariable int id)
	{
		return service.getStudentById(id);
	}
	
	@PutMapping("/update/{id}")
	public Assignment updateStudent(@PathVariable int id, @RequestBody Assignment student)
	{
		return service.updateStudent(id, student);
	}
	
	@PatchMapping("update/{id}")
	public Assignment updateStudentFields(@PathVariable int id, @RequestBody Map<String, Object> fields)
	{
		return service.updateStudentByFields(id, fields);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id)
	{
		return service.deleteStudent(id);
	}
	
	@GetMapping("/students")
	public List<Assignment> findAllStudents()
	{
		return service.getAllStudents();
	}
}
