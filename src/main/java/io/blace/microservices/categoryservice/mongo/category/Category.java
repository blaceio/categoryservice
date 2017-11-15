package io.blace.microservices.categoryservice.mongo.category;

import org.springframework.data.annotation.Id;

public class Category {
	
	@Id
	private String id;
	
	private String description;	
	
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
	@Override
	public String toString() {
		return "Category [id=" + id + ", description=" + description + "]";
	}

}
