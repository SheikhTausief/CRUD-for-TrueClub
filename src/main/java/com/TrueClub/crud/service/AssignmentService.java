package com.TrueClub.crud.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.TrueClub.crud.entity.Assignment;
import com.TrueClub.crud.repository.AssignmentRepository;

@Service
public class AssignmentService
	{

	@Autowired
	private AssignmentRepository repository;
	
	
	public Assignment saveStudent(Assignment student)
	{
		return repository.save(student);
	}
	
	public Optional<Assignment> getStudentById(int id)
	{
		return repository.findById(id);
	}
	
	public Assignment updateStudent(int id, Assignment student)
	{
		Assignment existingStudent=repository.findById(id).get();
		existingStudent.setName(student.getName());
		existingStudent.setAddress(student.getAddress());
		existingStudent.setPincode(student.getPincode());
		existingStudent.setState(student.getState());
//		existingStudent.setRow_creation_timestamp(student.getRow_creation_timestamp());
		return repository.save(existingStudent);
	}
	
	public Assignment updateStudentByFields(int id, Map<String, Object> fields)
	{
		Optional<Assignment> existingStudent=repository.findById(id);
		
		if(existingStudent.isPresent())
		{
			fields.forEach((key,value)->{
				Field field=ReflectionUtils.findRequiredField(Assignment.class, key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, existingStudent.get(), value);
			});
			return repository.save(existingStudent.get());
		}
		return null;
	}
	
	public String deleteStudent(int id)
	{
		repository.deleteById(id);
		return "student deleted successfully id "+id;
	}
	
	public List<Assignment> getAllStudents()
	{
		return repository.findAll();
	}
}
