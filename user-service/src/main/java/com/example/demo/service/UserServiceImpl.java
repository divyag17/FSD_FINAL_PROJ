package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	@Override
	public List<User> findByusername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByusername(username);
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(bcrypt.encode(user.getPassword() ));
		userRepository.save(user);
		return user;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public List<User> findBylocation(String ulocation) {
		// TODO Auto-generated method stub
		return userRepository.findByulocation(ulocation);
	}

	@Override
	 public List<User> findByavailability(String avialability) {
		// TODO Auto-generated method stub
		return userRepository.findByavialability(avialability);
	}

	@Override
	public List<User> findByemail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByemail(email);
	}

	@Override
	public List<User> findBydomain(String udomain) {
		// TODO Auto-generated method stub
		return userRepository.findByudomain(udomain);
	}

}
