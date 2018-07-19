package springbootresapi.springbootapiservice.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springbootresapi.springbootapiservice.dao.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
