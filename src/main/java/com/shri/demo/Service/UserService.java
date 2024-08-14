package com.shri.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shri.demo.Model.SystemUser;

@Service
public interface UserService {

	List<SystemUser> getAllUsers();

	String createUser(SystemUser user);

	String login(SystemUser user);

}
