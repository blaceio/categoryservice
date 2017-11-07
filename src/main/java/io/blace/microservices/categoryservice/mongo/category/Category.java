package io.blace.microservices.categoryservice.mongo.category;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Category {
	
	@Id
	private String id;
	
	private String description;	
	private List<Reference> divisions;
	
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
	public List<Reference> getDivisions() {
		return divisions;
	}
	public void setDivisions(List<Reference> divisions) {
		this.divisions = divisions;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", description=" + description + ", divisions=" + divisions + "]";
	}

	

}
