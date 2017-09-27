package pl.coderslab.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entity.LoginData;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.entity.UserFriends;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserFriendsRepository;
import pl.coderslab.repository.UserRepository;


@Controller
public class LoginController extends SessionedController{

	
	@Autowired
	UserRepository repoUser;
	
	@Autowired
	TweetRepository repoTweet;
	
	@Autowired
	UserFriendsRepository usrFrRepo;
	
	@GetMapping("/login") //Tak jest
	public String register(Model m) {
		LoginData login = new LoginData();
		m.addAttribute("login", login);
	
		
		return "login";
	}
	
	
	
	@PostMapping("/login") //Tak jest
	public String postLogin(LoginData user , Model m) {
		
		User u  = this.repoUser.findByEmail(user.getEmail());
		if(u==null) {
		m.addAttribute("msg", "Enater valid data");
		return "/home";
		}
		
		///Sprawdzamy poprawnosc hasla 
		if(u.isPasswordCorrect(user.getPassword())) {
			session().setAttribute("user", u);
			List<Tweet> tweets = repoTweet.findByUserId(u.getId());
			session().setAttribute("Tweets", tweets);
			
			
			
			
			
			////////////////wyswietlanie znajomych uzytkownika
			List<UserFriends> users = this.usrFrRepo.findAll();
			List<User> friends = new ArrayList<User>();
			
			String a =session().getAttribute("user").toString();
			User mainUser= repoUser.findByFirstName(a);
			
			for( UserFriends usr: users) {
				User first =usr.getFirstUser();
				User second =usr.getSecondUser();
				if(first.getId()==mainUser.getId()){
					
					friends.add(second);
				}else {
					if( second.getId()==mainUser.getId()) {
						friends.add(first);
					}
				}
			}
			
		//	if(friends.isEmpty()) {
				
			//	m.addAttribute("avaiableFriends","Forevel alone bitch");
		//	}else {
			m.addAttribute("avaiableFriends",friends);
		//	}
			/////////////////////////////////////////////////////////
		}
		return "logged";
	}
	
	
	
	@ModelAttribute("avaiableUsers")
	public List<User> getUsers(){
		List<User> users = this.repoUser.findAll();
		return users;
	}
	
	
	
	@RequestMapping("/logged")
	public String logged(Model m) {
		
		List<UserFriends> users = this.usrFrRepo.findAll();
		List<User> friends = new ArrayList<User>();
		
		String a =session().getAttribute("user").toString();
		User mainUser= repoUser.findByFirstName(a);
		//////////////////////////Tutaj
		List<Tweet> tweets = repoTweet.findByUserId(mainUser.getId());
		session().setAttribute("Tweets", tweets);
		////////////////////////////
		for( UserFriends usr: users) {
			User first =usr.getFirstUser();
			User second =usr.getSecondUser();
			if(first.getId()==mainUser.getId()){
				
				friends.add(second);
			}else {
				if( second.getId()==mainUser.getId()) {
					friends.add(first);
				}
			}
		}
		
		if(friends.isEmpty()) {
			
		//	m.addAttribute("avaiableFriends","Forevel alone bitch");
		}else {
		m.addAttribute("avaiableFriends",friends);
		}
		
		return "logged";
	}
	
	
	
	
	
	
	
	
	
	
	
}
