package com.education.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.dto.StudentDto;
import com.education.dto.TeacherDto;
import com.education.models.StudentModel;
import com.education.models.TeacherModel;
import com.education.services.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	@GetMapping
	public ResponseEntity<List<TeacherModel>> getAll(){
		return ResponseEntity.ok(teacherService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TeacherModel> getById(@PathVariable Long id){
		return ResponseEntity.ok(teacherService.getById(id));
	}
	@PostMapping
	public ResponseEntity<TeacherModel> create(
			@RequestBody @Validated TeacherDto teacher
			){
		return new ResponseEntity<TeacherModel>(teacherService.create(teacher), HttpStatus.CREATED);
	}
	
}
