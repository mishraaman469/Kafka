package com.mindtree.user.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.user.entity.User;
import com.mindtree.user.exception.NullCheckException;
import com.mindtree.user.repository.UserRepository;
import com.mindtree.user.service.UserService;



@Service
public class UserServiceImpl implements UserService {

		@Autowired
		private UserRepository userRepository;

		@Override
		public User getUserData(int id) {
			return this.userRepository.findById(id).orElseThrow(()-> new NullCheckException("Null data Can not be retireved"));
		}

		@Override
		public List<User> getUserData() {
			return this.userRepository.findAll();
		}

		@Override
		public void saveUserData(List<User> userUpdated) {
			this.userRepository.saveAll(userUpdated);
			
		}
		
}
