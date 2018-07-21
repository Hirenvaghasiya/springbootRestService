package springbootresapi.springbootapiservice.controller;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springbootresapi.springbootapiservice.model.Category;
import springbootresapi.springbootapiservice.repos.CategoryRepository;

@RestController
@RequestMapping(path="/api")
public class CategoryController {
	public static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
	@Autowired
	private CategoryRepository categoryRepository;
	HttpHeaders headers = new HttpHeaders();
	
	
	@GetMapping("/category")
	public @ResponseBody Iterable<Category> listAllCategory(){
		return categoryRepository.findAll();
	}
	@GetMapping("/{id}")
	public @ResponseBody Optional<Category> category(@PathVariable("id") int id){
		return categoryRepository.findById(id);
	}
	
	@PostMapping("/category")
	public ResponseEntity<?> addCategory(@RequestBody Category category){
		LOGGER.info("{}",category);
		categoryRepository.save(category);
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/category/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable("id") int id, @RequestBody Category category){
		Category currentCategory = categoryRepository.findById(id).get();
		if(currentCategory == null){
			LOGGER.error("Unable to update. category with {} id not found.",id);
			
			return new ResponseEntity<String>(headers,HttpStatus.NOT_FOUND);
		}
		
		currentCategory.setCategoryName(category.getCategoryName());
		categoryRepository.save(currentCategory);
		
		return new ResponseEntity<Category>(currentCategory, HttpStatus.OK); 
	}
	
	@DeleteMapping("/category/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable("id")int id){
		Category delCategory = categoryRepository.findById(id).get();
		if(delCategory == null){
			LOGGER.error("Unable to find category with id {}.",id);
			return new ResponseEntity<String>(headers,HttpStatus.NOT_FOUND);
		}
		
		LOGGER.info("Deleting catedory with id {}", id);
		categoryRepository.deleteById(id);
		return new ResponseEntity<Category>(delCategory,HttpStatus.NO_CONTENT);
		
	}
}
