package com.education.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.education.dto.StudentDto;
import com.education.error.AppError;
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
	
	public StudentModel update(StudentDto student, Long id) {
		StudentModel studentData = studentRepository.findById(id).orElseThrow(
				()-> new AppError("Aluno não encontrado id: ", HttpStatus.NOT_FOUND));
		
		return studentRepository.save(new StudentModel(
				student.getName(),
				student.getLastName(), 
				student.getCPF(),
				student.getDateOfBirth(), 
				student.getFather(),
				student.getMother()));
	}
}
