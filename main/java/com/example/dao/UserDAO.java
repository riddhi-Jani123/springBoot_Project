package com.example.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.User;

@Repository
@Transactional
public interface UserDAO extends JpaRepository<User, Integer> {
	
	
	User findByUserEmailAndUserPass(String userEmail , String userPass);
	

	
	User findByUserEmail(String userEmail);
	
	User findByuserId(int userId);
	
	
	@Modifying
	@Query("Delete from Address addr where addr.addressId NOT IN (:addressId) ")
	void deleteByUserId(@Param("addressId") List<Integer> addressId);

	@Modifying
	@Query("UPDATE  User SET userPass = :userPass  WHERE  userEmail = :userEmail ")
	int updateByuserEmail(@Param("userEmail") String userEmail,@Param("userPass") String userPass);
	
}
