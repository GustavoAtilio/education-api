package com.education.dto;

import java.util.Objects;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class TeacherDto {
	@NotNull(message = "Nome Não pode ser nulo")
	@NotEmpty(message = "Nome não pode ser Vazio")
    private String name;
	@NotNull(message = "Nome Não pode ser nulo")
	@NotEmpty(message = "Nome não pode ser Vazio")
    private String lastName;
	@NotNull(message = "Formação Não pode ser nulo")
	@NotEmpty(message = "Formação pode ser Vazio")
    private String office;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		name = name;
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
		return Objects.hash(name, lastName, office);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeacherDto other = (TeacherDto) obj;
		return Objects.equals(name, other.name) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(office, other.office);
	}
	
}
