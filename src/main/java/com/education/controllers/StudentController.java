package com.education.controllers;
import com.education.dto.StudentDto;
import com.education.services.StudentService;
import com.education.models.StudentModel;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	
	@GetMapping
	public ResponseEntity<List<StudentModel>> getStudents() {
		return  ResponseEntity.ok(studentService.getAll());
	}
	
	@PostMapping
	public ResponseEntity<StudentModel> create(@RequestBody @Validated StudentDto student) {
		return new ResponseEntity<StudentModel>(studentService.create(student), HttpStatus.CREATED);
		
	}
}
