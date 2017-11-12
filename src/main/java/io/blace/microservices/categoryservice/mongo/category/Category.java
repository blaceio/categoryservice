package io.blace.microservices.categoryservice.mongo.category;

import org.springframework.data.annotation.Id;

public class Category {
	
	@Id
	private String id;
	
	private String description;	
	private String division;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", description=" + description + ", division=" + division + "]";
	}

}
