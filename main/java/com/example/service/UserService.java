
package com.example.service;

import java.util.List;

import com.example.model.User;


public interface UserService {
	
	User register(User user) ;

	
	 User login(User u) ;
	 
	 List<User> viewUser();
	 
	 User findById(int id);
	 
	 void update(User user);


	User viewProfile(String email);


	void deleteUser(int parseInt);


	boolean checkEmail(String email);


	int updatePass(String email , String pass);
	

}
