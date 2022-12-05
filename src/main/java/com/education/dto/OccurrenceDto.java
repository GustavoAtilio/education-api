package com.education.dto;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class OccurrenceDto {
	@NotNull(message = "Descrição Não pode ser nulo")
	@NotEmpty(message = "Descrição não pode ser Vazio")
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OccurrenceDto other = (OccurrenceDto) obj;
		return Objects.equals(description, other.description);
	}
	
	
	
}
