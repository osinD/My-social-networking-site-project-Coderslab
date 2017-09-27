package pl.coderslab.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_messages")
public class UserMessages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private    User userSender;
	@ManyToOne
	private    User userReciver;
	
	private String userMessage;

	
	
	
	public UserMessages() {
		
	}
	
	
	public UserMessages(User userSender, User userReciver, String userMessage) {
		super();
		this.userSender = userSender;
		this.userReciver = userReciver;
		this.userMessage = userMessage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUserSender() {
		return userSender;
	}

	public void setUserSender(User userSender) {
		this.userSender = userSender;
	}

	public User getUserReciver() {
		return userReciver;
	}

	public void setUserReciver(User userReciver) {
		this.userReciver = userReciver;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
}
