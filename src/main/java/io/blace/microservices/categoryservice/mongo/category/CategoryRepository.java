package io.blace.microservices.categoryservice.mongo.category;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {

	Category findById(String id);
	
	List<Category> findAll();
	
}
