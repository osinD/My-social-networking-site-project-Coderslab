package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import pl.coderslab.entity.Tweet;


public interface TweetRepository extends JpaRepository<Tweet,Long>{

	List<Tweet> findByUserId(Long id);
}
