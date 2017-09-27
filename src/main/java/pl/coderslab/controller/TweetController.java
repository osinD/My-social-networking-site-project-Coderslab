package pl.coderslab.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

@Controller
//@RequestMapping("/Tweets")
public class TweetController extends SessionedController{

	@Autowired
	TweetRepository repoTweet;
	@Autowired
	UserRepository repoUser;
	
	@RequestMapping("/Tweets/add")
	public String addTweet(Model m) {
		Tweet tweet = new Tweet();
		m.addAttribute("tweet", tweet);
		return "tweetAddForm";
	}
	
	@ModelAttribute("avaiableUsers")
	public List<User> getUsers(){
		List<User> users = this.repoUser.findAll();
		return users;
	}
	
	
	@PostMapping("/Tweets/add")
	//@ResponseBody
	public String registerPost(@ModelAttribute @Valid Tweet tweet, BindingResult result,Model m) {
		String a =session().getAttribute("user").toString();
		User user= repoUser.findByFirstName(a);
		tweet.setUser(user);
		if (result.hasErrors()) {
			return "Valid data";
	}
		
		repoTweet.save(tweet);
		////////////////////////////////////////////////////////////
		//List<Tweet> tweets = repoTweet.findAll();
		
		return "/returnToLogged";
	}


}
