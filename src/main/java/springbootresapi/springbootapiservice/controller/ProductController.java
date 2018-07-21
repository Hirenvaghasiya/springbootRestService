package springbootresapi.springbootapiservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springbootresapi.springbootapiservice.model.Category;
import springbootresapi.springbootapiservice.model.Product;
import springbootresapi.springbootapiservice.repos.CategoryRepository;
import springbootresapi.springbootapiservice.repos.ProductRepository;

@RestController
@RequestMapping(path="/product")
public class ProductController {
	
	@Autowired
	private ProductRepository product;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping("/add")
	public @ResponseBody String add(@RequestParam String name, @RequestParam String category){
		Product newProduct = new Product();
		newProduct.setName(name);
		Category productCategory = categoryRepository.findByCategoryName(category);
		System.out.println(productCategory.getCategoryName());
		newProduct.setCategory(productCategory);
		product.save(newProduct);
		return "Product "+name+" added"; 
	}
}
