package com.education.controllers;

import java.util.List;

import org.hibernate.engine.spi.Resolution;
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

import com.education.dto.OccurrenceDto;
import com.education.dto.TeacherDto;
import com.education.models.OccurrenceModel;
import com.education.models.TeacherModel;
import com.education.services.OccurrenceService;

@RestController
@RequestMapping("/occurrences")
public class OccurrenceController {
	@Autowired
	private OccurrenceService occurrenceService;
	
	@PostMapping("/student/{idStudent}/teacher/{idTeacher}")
	public ResponseEntity<OccurrenceModel> create(
			@RequestBody @Validated  OccurrenceDto occurrence,
			@PathVariable Long idStudent,
			@PathVariable Long idTeacher
			){
		      return new ResponseEntity<>(occurrenceService.create(occurrence, idStudent, idTeacher), HttpStatus.CREATED);
	        }
	@GetMapping("/{id}")
    public ResponseEntity<List<OccurrenceModel>> getByStudent(@PathVariable Long id){
		return ResponseEntity.ok(occurrenceService.getByStudantId(id));
    }
	
	
}
