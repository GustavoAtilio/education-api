package com.education.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

import org.hibernate.validator.constraints.br.CPF;


public class StudentDto {
	@NotNull(message = "Nome Não pode ser nulo")
	@NotEmpty(message = "Nome não pode ser Vazio")
	private String name;
	@NotNull(message = "Sobre Nome Não pode ser nulo")
	@NotEmpty(message = "Sobre Nome não pode ser Vazio")
	private String lastName;
	@CPF(message = "CPF Invalido")
	private String CPF;
	private String dateOfBirth;
	@Override
	public int hashCode() {
		return Objects.hash(CPF);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentDto other = (StudentDto) obj;
		return Objects.equals(CPF, other.CPF);
	}
	private String father;
	private String mother;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public String getMother() {
		return mother;
	}
	public void setMother(String mother) {
		this.mother = mother;
	}
}
