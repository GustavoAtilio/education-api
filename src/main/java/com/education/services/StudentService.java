package com.education.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.dto.StudentDto;
import com.education.models.StudentModel;
import com.education.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public List<StudentModel> getAll(){
		return studentRepository.findAll();
	}
	
	public StudentModel create(StudentDto student) {
		return studentRepository.save(new StudentModel(
				student.getName(),
				student.getLastName(), 
				student.getCPF(),
				student.getDateOfBirth(), 
				student.getFather(),
				student.getMother()));
	}
}
