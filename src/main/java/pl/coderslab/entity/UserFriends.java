package pl.coderslab.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user_friend")
public class UserFriends {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private    User firstUser;
	@ManyToOne
	private    User secondUser;
	
	
	
	
	
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getFirstUser() {
		return firstUser;
	}
	public void setFirstUser(User firstUser) {
		this.firstUser = firstUser;
	}
	public User getSecondUser() {
		return secondUser;
	}
	public void setSecondUser(User secondUser) {
		this.secondUser = secondUser;
	}
	
	
	
	

	
}
