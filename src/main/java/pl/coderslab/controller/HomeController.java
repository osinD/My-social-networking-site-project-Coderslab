package pl.coderslab.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.entity.UserMessages;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserFriendsRepository;
import pl.coderslab.repository.UserMessagesRepository;
import pl.coderslab.repository.UserRepository;

@Controller
public class HomeController extends SessionedController{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	TweetRepository tweetRepo;
	//////////////////
	@Autowired
	UserRepository repoUser;
	
	@Autowired
	UserMessagesRepository usrMsgRepo;
	
	@Autowired
	UserFriendsRepository usrFrRepo;
	///////////////////
	@RequestMapping("")
	public String home(){
		return "home";
	}
	
	
	@RequestMapping("/show/{id}")
	public String showFriend(@PathVariable Long id, Model m) {
		
		User user = userRepo.getById(id);
		List<Tweet> userTweets= tweetRepo.findByUserId(user.getId());
		m.addAttribute("friendName" ,user);
		m.addAttribute("friendTweets", userTweets);
		return "showFriendTweet";
	}
	
	
	@RequestMapping("/signOut")
	public String signOut() {
		session().removeAttribute("user");
		session().removeAttribute("Tweets");
		session().invalidate();
		
		return "home";
	}
	
	
	/////////////////////////////////////////////////
	@RequestMapping("/showMessages/{id}")
	public String messenger(@PathVariable Long id ,Model m) {
		String a =session().getAttribute("user").toString();
		User mainUser= repoUser.findByFirstName(a);
		
		User reciver =repoUser.getById(id);
		List<UserMessages> chat =usrMsgRepo.findAll();
		List<UserMessages> sended = usrMsgRepo.findByUserSender(mainUser);
		List<UserMessages> result1 =new ArrayList<UserMessages>();
		List<UserMessages> result2 =new ArrayList<UserMessages>();
		for(UserMessages uM : chat) {
			if(uM.getUserReciver().equals(reciver)&&uM.getUserSender().equals(mainUser)) {
				result1.add(uM);
			}
			if(uM.getUserReciver().equals(mainUser)&&uM.getUserSender().equals(reciver)) {
				result2.add(uM);
			}
		}
		m.addAttribute("getted", reciver.getFirstName());
		m.addAttribute("messagesFrom", result2);
		m.addAttribute("MessageTo", result1);
		
		return "messenger";
	}
	/////////////////////////////////////////////////
}
