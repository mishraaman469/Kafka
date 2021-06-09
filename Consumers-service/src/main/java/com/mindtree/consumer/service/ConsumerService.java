package com.mindtree.consumer.service;

import java.util.List;

import com.mindtree.consumer.entity.User;

public interface ConsumerService {

	void saveUserData(User user);

	void saveUserData(List<User> user);

}
