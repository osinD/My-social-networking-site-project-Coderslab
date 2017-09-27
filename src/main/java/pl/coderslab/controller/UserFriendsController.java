package pl.coderslab.controller;

import java.util.ArrayList;
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
import pl.coderslab.entity.UserFriends;
import pl.coderslab.repository.UserFriendsRepository;
import pl.coderslab.repository.UserRepository;

@Controller

public class UserFriendsController extends SessionedController{

	@Autowired
	UserFriendsRepository ufRepo;
	
	@Autowired
	UserRepository repoUser;
	@Autowired
	UserFriendsRepository usrFrRepo;
	
	@RequestMapping("/addfriend")
	public String addFriend(Model m) {
		
		UserFriends uf = new UserFriends();
		/////////////////////////////////
List<User> users1 = this.repoUser.findAll();
		
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
		
		List<User> toAdd= new ArrayList<User>();
		int flag=0;
		for(User usr : users1) {
			flag=0;
			for(User fri : friends) {
				if(fri.equals(usr)) {
					flag=1;
				}
			}
			if(flag==0&&!(usr.equals(mainUser))) {
				toAdd.add(usr);
			}
		}
		
		
		if(toAdd.isEmpty()) {
			return "friendly";
		}
		/////////////////////////////////
		m.addAttribute("userfriend", uf);
		return "addFriend";
	}
	
	@ModelAttribute("avaiableUsers")
	public List<User> getUsers(){
		List<User> users1 = this.repoUser.findAll();
		
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
		List<User> toAdd= new ArrayList<User>();
		
		int flag=0;
		for(User usr : users1) {
			flag=0;
			for(User fri : friends) {
				if(fri.equals(usr)) {
					flag=1;
				}
			}
			if(flag==0&&!(usr.equals(mainUser))) {
				toAdd.add(usr);
			}
		}
		
		
		
		
		//////////////////////////////////////////
		
		/*
		for(int i=0;i<users1.size();i++) {
			int flag=0;
			User usr1= users1.get(i);
			for(int j=0;j<friends.size();i++) {
				User usr2 =friends.get(j);
				if(usr1.equals(usr2)) {
					flag=1;
				}
			}
			if(flag==0) {
				toAdd.add(users1.get(i));
			}
		}
		
		*/
		
		
		
		
		return toAdd;
	}
	
	
	@PostMapping("/addfriend")
	//@ResponseBody
	public String postAddFriend(@ModelAttribute @Valid UserFriends uf, BindingResult result,Model m) {
		
		String a =session().getAttribute("user").toString();
		User user= repoUser.findByFirstName(a);
		uf.setFirstUser(user);
		if (result.hasErrors()) {
			return "Valid data";
		}
		/////////////////////
		/////////////////////////////////
		List<User> users1 = this.repoUser.findAll();

		List<UserFriends> users = this.usrFrRepo.findAll();
		List<User> friends = new ArrayList<User>();

		String b = session().getAttribute("user").toString();
		User mainUser = repoUser.findByFirstName(b);

		for (UserFriends usr : users) {
			User first = usr.getFirstUser();
			User second = usr.getSecondUser();
			if (first.getId() == mainUser.getId()) {

				friends.add(second);
			} else {
				if (second.getId() == mainUser.getId()) {
					friends.add(first);
				}
			}
		}

		List<User> toAdd = new ArrayList<User>();
		int flag = 0;
		for (User usr : users1) {
			flag = 0;
			for (User fri : friends) {
				if (fri.equals(usr)) {
					flag = 1;
				}
			}
			if (flag == 0 && !(usr.equals(mainUser))) {
				toAdd.add(usr);
			}
		}
		
		
		if(toAdd.isEmpty()) {
			return "/friendly";
		}
		/////////////////////////////////else {
	//	m.addAttribute("avaiableUsers", toAdd);
	//}
		////////////////////
		ufRepo.save(uf);
		return "/returnToLogged";
	}
	
	
	
}
