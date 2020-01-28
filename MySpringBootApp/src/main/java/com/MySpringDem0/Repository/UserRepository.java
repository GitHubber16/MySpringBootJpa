package com.MySpringDem0.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.MySpringDemo.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUserNameAndPassword(String userName,String password);
}
