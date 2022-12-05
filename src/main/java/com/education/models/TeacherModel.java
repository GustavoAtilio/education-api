package com.education.models;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class TeacherModel {
	public TeacherModel( String name, String lastName, String office) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.office = office;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany
	private List<OccurrenceModel> Occurrences;
	
	@Column(nullable = false)
    private String name;
	
	@Column(nullable = false)
    private String lastName;
	
	@Column(nullable = false)
    private String office;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TeacherModel(){}
	public TeacherModel(Long id, String name, String lastName, String office) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.office = office;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeacherModel other = (TeacherModel) obj;
		return Objects.equals(id, other.id);
	}
    
    
}
