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
import springbootresapi.springbootapiservice.model.Product;
import springbootresapi.springbootapiservice.repos.CategoryRepository;
import springbootresapi.springbootapiservice.repos.ProductRepository;

@RestController
@RequestMapping(path="/api")
public class ProductController {
	public static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;
		
	@GetMapping("/product")
	public @ResponseBody Iterable<Product> listAllProduct(){
		return productRepository.findAll();
	}
	
	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@RequestBody Product product){
		LOGGER.info("{}", product);
		Category cat = product.getCategory();
		Optional<Category> cat1 = categoryRepository.findById(cat.getId());
		product.setCategory(cat1.get());
		productRepository.save(product);
		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<String>(header,HttpStatus.CREATED);
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable("id") int id, @RequestBody Product product){
		LOGGER.info("Update user with id {}",id);
		Product currentProduct = productRepository.findById(id).get();
		if(currentProduct == null){
			LOGGER.error("unable to update. Product with {} id not found.",id);
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<String>(headers,HttpStatus.NOT_FOUND);
		}
		
		currentProduct.setName(product.getName());
		currentProduct.setCategory(product.getCategory());
		
		productRepository.save(currentProduct);
		return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") int id){
		LOGGER.info("Deleting product with id {}",id);
		Product delProduct = productRepository.findById(id).get();
		if(delProduct == null){
			LOGGER.error("Unable to find product with id {}.",id);
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<String>(headers,HttpStatus.NOT_FOUND);
		}
		
		productRepository.deleteById(id);
		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		
	}
}
