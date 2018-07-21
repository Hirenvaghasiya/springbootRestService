package springbootresapi.springbootapiservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springbootresapi.springbootapiservice.model.Category;
import springbootresapi.springbootapiservice.repos.CategoryRepository;

@RestController
@RequestMapping(path="/category")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping("/add")
	public @ResponseBody String add(@RequestParam String categoryName){
		Category newCategory = new Category();
		newCategory.setCategoryName(categoryName);
		categoryRepository.save(newCategory);
		return "Category "+categoryName+" added";
	}
	
	@GetMapping("")
	public @ResponseBody Iterable<Category> allCategory(){
		return categoryRepository.findAll();
	}
	@GetMapping("/{id}")
	public @ResponseBody Optional<Category> category(@PathVariable("id") int id){
		return categoryRepository.findById(id);
	}
}
