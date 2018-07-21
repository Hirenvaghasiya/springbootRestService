package springbootresapi.springbootapiservice.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springbootresapi.springbootapiservice.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
