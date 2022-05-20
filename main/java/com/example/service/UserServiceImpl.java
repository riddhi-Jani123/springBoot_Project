
package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDAO;
import com.example.model.Address;
import com.example.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDao;

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub

		List<Integer> addressList = new ArrayList<Integer>();
		System.out.println("in service");
		for (Address address : user.getAddress()) {
			address.setUser(user);
		}
		
	
		
		System.out.println("user in update "+user);
		System.out.println(user.getAddress());
		
		if(user.getUserId()!=0) {
			
			for (Address address : user.getAddress()) {
				addressList.add(address.getAddressId());
			}
			userDao.deleteByUserId(addressList);
		}
		return userDao.save(user);
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub

		
		User users = userDao.findByUserEmailAndUserPass(user.getUserEmail(),user.getUserPass());

		return users;
	}

	@Override
	public List<User> viewUser() {
		// TODO Auto-generated method stub

		List<User> user = userDao.findAll();

		return user;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		User user = userDao.findByuserId(id);

		return user;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
		
		userDao.save(user);
	}

	@Override
	public User viewProfile(String email) {
		// TODO Auto-generated method stub
		
		User users = userDao.findByUserEmail(email);

		return users;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
		userDao.deleteById(id);
		
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		boolean isExist = false;
	
		User user = userDao.findByUserEmail(email);
		
		if(user!=null) {
		
			isExist = true;
		}
		return isExist;
	}

	@Override
	public int updatePass(String email , String pass) {
		// TODO Auto-generated method stub
		
		int result = userDao.updateByuserEmail(email, pass);
		
		return result;
	}
	
	

}
