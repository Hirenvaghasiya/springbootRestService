package springbootresapi.springbootapiservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springbootresapi.springbootapiservice.dao.User;
import springbootresapi.springbootapiservice.repos.UserRepository;

@Controller
@RequestMapping(path="/user")
public class UserController {

	@Autowired
	public UserRepository userRepository;
	
	@RequestMapping("/add")
	public @ResponseBody String addUser(@RequestParam String name, @RequestParam String email){
		User newUser = new User();
		newUser.setName(name);
		newUser.setEmail(email);
		userRepository.save(newUser);
		return "user created";
	}
	
	@RequestMapping("/all")
	public @ResponseBody Iterable<User> getAllUser(){
		return userRepository.findAll();
	}
}
