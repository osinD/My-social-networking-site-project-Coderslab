package pl.coderslab.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "tweeter_user")
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Column(unique=true)
	private String firstName;
	@NotNull
	private String lastName;
	@Email
	@Column(unique=true)
	private String email;
	@NotBlank
	private String password;
	@OneToMany(mappedBy    = "user", fetch =FetchType.EAGER)
    private List<Tweet> tweets;
	@OneToMany
	private List<UserFriends> freinds;
	@OneToMany
	private List<UserMessages> userMessages;
	
	
	


	


	@Override
	public String toString() {
		return firstName  ;
	}


	public User() {
		
	}
	
	
	public User(String firstName, String lastName, String email, String password, List<Tweet> tweets) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.tweets = tweets;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isPasswordCorrect(String password) {
		return  this.password.equals(password);
	}
	public List<Tweet> getTweets() {
		return tweets;
	}
	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}
	public List<UserFriends> getFreinds() {
		return freinds;
	}


	public void setFreinds(List<UserFriends> freinds) {
		this.freinds = freinds;
	}

	public List<UserMessages> getUserMessages() {
		return userMessages;
	}


	public void setUserMessages(List<UserMessages> userMessages) {
		this.userMessages = userMessages;
	}
	

}
