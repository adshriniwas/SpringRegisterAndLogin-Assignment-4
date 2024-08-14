package com.shri.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shri.demo.Model.SystemUser;
import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<SystemUser, String> {
	public SystemUser findByUserName(String userName);
}
