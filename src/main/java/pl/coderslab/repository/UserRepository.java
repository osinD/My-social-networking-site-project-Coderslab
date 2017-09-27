package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.User;


public interface UserRepository extends JpaRepository<User,Long>{

	User getById(Long parseLong);
	User findByEmail(String email);
	User findByFirstName(String firstName);
//	User findById(Long id);
	
}
