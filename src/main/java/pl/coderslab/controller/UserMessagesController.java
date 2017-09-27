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

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserFriends;
import pl.coderslab.entity.UserMessages;
import pl.coderslab.repository.UserFriendsRepository;
import pl.coderslab.repository.UserMessagesRepository;
import pl.coderslab.repository.UserRepository;

@Controller
public class UserMessagesController extends SessionedController{

	
	
	@Autowired
	UserRepository repoUser;
	
	@Autowired
	UserMessagesRepository usrMsgRepo;
	
	@Autowired
	UserFriendsRepository usrFrRepo;
	
	
	
	@RequestMapping("/createMessage")
	public String createMessage(Model m) {
		
		
		UserMessages um = new UserMessages();
		m.addAttribute("usermessage", um);
		
	///////////////////////////////////////	
		
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
		
		if(friends.isEmpty()) {
			
		}else {
		m.addAttribute("avaiableFriends",friends);
		}
		
	///////////////////////////////////////	
		
		return "createMessage";
	}
	
	@ModelAttribute("avaiableUsers")
	public List<User> getUsers(){
		List<User> users = this.repoUser.findAll();
		return users;
	}
	
	
	@PostMapping("/createMessage")
//	@ResponseBody
	public String postCreateMessage(@ModelAttribute @Valid UserMessages um, BindingResult result, Model m) {
		
		
		String a =session().getAttribute("user").toString();
		User mainUser= repoUser.findByFirstName(a);
		um.setUserSender(mainUser);
		if (result.hasErrors()) {
			return "Valid data";
		}
		usrMsgRepo.save(um);
		
		
		List<UserMessages> chat =usrMsgRepo.findAll();
		List<UserMessages> sended = usrMsgRepo.findByUserSender(mainUser);
		
		
		/////////////////////////////////////////////////////////////////////////////////////
		
		List<UserFriends> users = this.usrFrRepo.findAll();
		List<User> friends = new ArrayList<User>();
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
		//////////////////////////////////////////////////////////////////////////////////////
		
		
		List<UserMessages> recived2 = new ArrayList<UserMessages>();
//		List<UserMessages> sended2 = new ArrayList<UserMessages>();
		for(UserMessages wiadomosc : chat) {
			if(wiadomosc.getUserReciver().getId()==mainUser.getId()) {
				recived2.add(wiadomosc);
			}
	
			
		}
		
		List<UserMessages> recived3 = new ArrayList<UserMessages>();
		for(int i=(recived2.size()-1);i>=0;i--) {
			recived3.add(recived2.get(i));
		}
		List<UserMessages> sended3 = new ArrayList<UserMessages>();
		for(int i=(sended.size()-1);i>=0;i--) {
			sended3.add(sended.get(i));
		}
		
		m.addAttribute("avaiableFriends", friends);
		m.addAttribute("recivedMessages", recived3);
		m.addAttribute("sendedMessages", sended3);
		
		return "showMessage";
	}
	
	
	
	@RequestMapping("/Messages")
	public String showMessages(Model m) {
		
		
		String a =session().getAttribute("user").toString();
		User mainUser= repoUser.findByFirstName(a);
		List<UserMessages> chat =usrMsgRepo.findAll();
		List<UserMessages> sended = usrMsgRepo.findByUserSender(mainUser);
		
		
		/////////////////////////////////////////////////////////////////////////////////////
		
		List<UserFriends> users = this.usrFrRepo.findAll();
		List<User> friends = new ArrayList<User>();
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
		//////////////////////////////////////////////////////////////////////////////////////
		
		
		List<UserMessages> recived2 = new ArrayList<UserMessages>();
		for(UserMessages wiadomosc : chat) {
			if(wiadomosc.getUserReciver().getId()==mainUser.getId()) {
				recived2.add(wiadomosc);
			}
			
			
		}
	
		List<UserMessages> recived3 = new ArrayList<UserMessages>();
		for(int i=(recived2.size()-1);i>=0;i--) {
			recived3.add(recived2.get(i));
		}
		List<UserMessages> sended3 = new ArrayList<UserMessages>();
		for(int i=(sended.size()-1);i>=0;i--) {
			sended3.add(sended.get(i));
		}
		
		m.addAttribute("avaiableFriends", friends);
		m.addAttribute("recivedMessages", recived3);
		m.addAttribute("sendedMessages", sended3);
		
		return "showMessage";
	}
	
}
