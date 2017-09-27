package pl.coderslab.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tweet")
public class Tweet {
	
	@Id
	@GeneratedValue
	private long id;
	@Length(min=5,max=50)
	@NotNull
	private String title;
	@NotNull
	@Length(max=100)
	private String tweet_text ;
	@CreationTimestamp
	private Date created;
	@ManyToOne(cascade=CascadeType.MERGE, fetch =FetchType.EAGER)
    private    User user;
	
	
	
	
	public Tweet() {
		
	}
	
	public Tweet(String title, String tweet_text, Date created, User user) {
		super();
		this.title = title;
		this.tweet_text = tweet_text;
		this.created = created;
		this.user = user;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTweet_text() {
		return tweet_text;
	}
	public void setTweet_text(String tweet_text) {
		this.tweet_text = tweet_text;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
