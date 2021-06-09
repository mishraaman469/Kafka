package com.mindtree.user.service;

import java.util.List;

import com.mindtree.user.entity.User;

public interface UserService {

	User getUserData(int id);

	List<User> getUserData();

	void saveUserData(List<User> userUpdated);

}
