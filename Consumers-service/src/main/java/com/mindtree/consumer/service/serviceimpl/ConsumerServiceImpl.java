package com.mindtree.consumer.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.consumer.entity.User;
import com.mindtree.consumer.repository.ConsumerRepository;
import com.mindtree.consumer.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService {
		
	@Autowired
	private ConsumerRepository  consumerRepository;

	@Override
	public void saveUserData(User user) {
		this.consumerRepository.save(user);
		
	}

	@Override
	public void saveUserData(List<User> user) {
		this.consumerRepository.saveAll(user);	
	}	
	
}
