package springbootresapi.springbootapiservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springbootresapi.springbootapiservice.dao.User;
import springbootresapi.springbootapiservice.repository.UserRepository;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/add")
	public String addUser(){
		User newUser = new User(1, "Hiren", "hiren.vaghasiya@yahoo.com");
		userRepository.save(newUser);
		return "user created";
	}
}
