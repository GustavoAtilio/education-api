package com.education.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.education.dto.OccurrenceDto;
import com.education.error.AppError;
import com.education.models.OccurrenceModel;
import com.education.models.StudentModel;
import com.education.models.TeacherModel;
import com.education.repositories.OccurrenceRepository;
import com.education.repositories.StudentRepository;
import com.education.repositories.TeacherRepository;

@Service
public class OccurrenceService {
    @Autowired
	private OccurrenceRepository occurrenceRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    
    public OccurrenceModel getById(Long id) {
    	return occurrenceRepository.findById(id).orElseThrow(
				()-> new AppError("Ocorrencia não encontrado id: "+id, HttpStatus.NOT_FOUND));
    }
    
    public OccurrenceModel create(OccurrenceDto occurrence, Long idStudent, Long idTeacher) {
    	StudentModel student = studentRepository.findById(idStudent).orElseThrow(
				()-> new AppError("Aluno não encontrado id: "+idStudent, HttpStatus.NOT_FOUND));
    	
    	TeacherModel teacher =  teacherRepository.findById(idTeacher).orElseThrow(
				()-> new AppError("Professora não encontrado id: "+idTeacher, HttpStatus.NOT_FOUND));
    	
    	return occurrenceRepository.save(new OccurrenceModel(
    			teacher, 
    			student, 
    			occurrence.getDescription(),
    			Instant.now().toString()));
    }
}
