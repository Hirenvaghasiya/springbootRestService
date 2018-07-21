package springbootresapi.springbootapiservice.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springbootresapi.springbootapiservice.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

	public Category findByCategoryName(@Param("category_name") String name);
}
