package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserMessages;

public interface UserMessagesRepository extends JpaRepository<UserMessages,Long>{

	List<UserMessages> findByUserReciver(User userSender);
	List<UserMessages> findByUserSender(User userReciver);
}
