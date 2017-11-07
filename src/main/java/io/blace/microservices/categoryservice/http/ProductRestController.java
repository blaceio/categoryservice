package io.blace.microservices.categoryservice.http;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.blace.microservices.categoryservice.mongo.category.Category;
import io.blace.microservices.categoryservice.mongo.category.CategoryRepository;

@RestController
public class ProductRestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CategoryRepository categoryrepo;
	
    @CrossOrigin
    @RequestMapping(value = "category")
    public ResponseEntity<List<Category>> getallcategories() {
    		logger.info("getallcategories requested");
        return new ResponseEntity<List<Category>>(categoryrepo.findAll(), HttpStatus.OK);
    }
    
    @CrossOrigin
    @RequestMapping(value = "category", params = {"id"})
    public ResponseEntity<Category> getbyid(@RequestParam("id") String id){
    		logger.info("getbyid requested for " +  id);
        return new ResponseEntity<Category>(categoryrepo.findById(id), HttpStatus.OK);
    }   
    
    @CrossOrigin
    @RequestMapping(value = "category", params = {"division"})
    public ResponseEntity<List<Category>> getbydivision(@RequestParam("division") String division){
    		logger.info("getbydivision requested for " +  division);
        return new ResponseEntity<List<Category>>(categoryrepo.findByDivisionsRef(division), HttpStatus.OK);
    }    
    
    @CrossOrigin
    @PostMapping("/category")
    public ResponseEntity<Category> createcategory(@RequestBody Category category) {
    		logger.info("createcategory requested for " +  category.toString());
    		categoryrepo.save(category);
        return new ResponseEntity<Category>(HttpStatus.CREATED);
    }
    
    @CrossOrigin
    @DeleteMapping(value = "/category")
    public ResponseEntity<Category> deletecategory(@RequestParam("deleteid") String deleteid) {
		logger.info("deletecategory requested for " +  deleteid);
    		Category category = categoryrepo.findById(deleteid);
    		categoryrepo.delete(category);
    		return new ResponseEntity<Category>(HttpStatus.ACCEPTED);
    }
	
}
