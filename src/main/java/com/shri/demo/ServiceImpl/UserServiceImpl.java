package com.shri.demo.ServiceImpl;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shri.demo.Model.SystemUser;
import com.shri.demo.Repository.UserRepo;
import com.shri.demo.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public List<SystemUser> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public String createUser(SystemUser user) {
		// TODO Auto-generated method stub
		SystemUser uobj = new SystemUser();
		uobj.setUserName(user.getUserName());
		uobj.setEmailId(user.getEmailId());
		String encodedPass = Base64.getEncoder().encodeToString(user.getUserPwd().getBytes());
		uobj.setUserPwd(encodedPass);
		uobj.setUserRole("Guest");
		uobj.setUserStatus("Prohibited");
		userRepo.save(uobj);
		String str = "User created Successfully...";
		return str;
	}

	@Override
	public String login(SystemUser user) {
		// TODO Auto-generated method stub
		String output = "";
		try {
		SystemUser existUser = userRepo.findByUserName(user.getUserName());
		
		
		if(existUser!=null) {
			String clientPwd = user.getUserPwd();
			byte[] pwdBytes = Base64.getDecoder().decode(existUser.getUserPwd().getBytes());
			String decodedPwd = new String(pwdBytes);
			if(decodedPwd.equals(clientPwd)) {
				output = "login successfull";
			}else {
				output = "Your password is incorrect";
			}
		}else {
			output = "user not found in db";
		}
		}catch(Exception e) {
			e.printStackTrace();
			output = e.toString();
		}
		
		return output;
	}

}
