package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import pl.coderslab.entity.UserFriends;

public interface UserFriendsRepository extends JpaRepository<UserFriends,Long>{

}
