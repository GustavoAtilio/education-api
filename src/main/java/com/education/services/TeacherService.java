package com.education.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.education.dto.TeacherDto;
import com.education.error.AppError;
import com.education.models.TeacherModel;
import com.education.repositories.TeacherRepository;

@Service
public class TeacherService {
    
	@Autowired
	private TeacherRepository teacherRepository;
	
	public TeacherModel create(TeacherDto teacher) {
		return teacherRepository.save(new TeacherModel(
				teacher.getName(), 
				teacher.getLastName(), 
				teacher.getOffice()));
	}
	
	public TeacherModel getById(Long id) {
		return teacherRepository.findById(id).orElseThrow(
				()-> new AppError("Professora não encontrado id: "+id, HttpStatus.NOT_FOUND));
	}
	
	public List<TeacherModel> getAll(){
		return teacherRepository.findAll();
	}
	
	public TeacherModel deleteById(Long id) {
		TeacherModel teacher = getById(id);
		teacherRepository.deleteById(id);
		return teacher;
	}
	public TeacherModel update(Long id, TeacherDto teacher) {
		TeacherModel teacherData = getById(id);
		teacherData.setName(teacher.getName());
		teacherData.setLastName(teacher.getLastName());
		teacherData.setOffice(teacher.getOffice());
		teacherRepository.save(teacherData);
		return teacherData;
	}
}
