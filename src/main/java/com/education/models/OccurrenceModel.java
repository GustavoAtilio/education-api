package com.education.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class OccurrenceModel {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private TeacherModel teacher;
	
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private StudentModel student;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String dateDescription;
}
