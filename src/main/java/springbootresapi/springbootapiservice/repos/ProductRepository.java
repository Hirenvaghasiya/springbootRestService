package springbootresapi.springbootapiservice.repos;

import org.springframework.data.repository.CrudRepository;

import springbootresapi.springbootapiservice.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
