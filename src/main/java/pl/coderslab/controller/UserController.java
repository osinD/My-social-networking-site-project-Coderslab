package pl.coderslab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

@Controller

public class UserController {

	@Autowired
	UserRepository repoUser;

	@RequestMapping("/user/add")
	public String addUser(Model m) {
		User user = new User();
		m.addAttribute("user", user);
		return "userAddForm";
	}

	@PostMapping("/user/add")

	public String registerPost(@ModelAttribute @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "/valid";
	}
		repoUser.save(user);
		return "/home";
	}
	
	@RequestMapping("/valid")
	public String validData() {
		return "/invalidData";
	}

}
