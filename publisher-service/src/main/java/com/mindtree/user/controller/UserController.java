package com.mindtree.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.user.entity.User;
import com.mindtree.user.service.UserService;

@RestController
@EnableBinding(Source.class)
public class UserController {
	
		static int id=1;
		@Autowired
		private UserService userService;
		
		@Autowired
		private MessageChannel output;
		
		
		static List<User> userUpdated=new ArrayList<>();
		

  		/*@Scheduled(cron="0/30 * * * * *")
		public void getUserData() {
		
			User user=this.userService.getUserData(id);
			output.send(MessageBuilder.withPayload(user).build());
			id++;
		}*/
		
		
		@Scheduled(cron="0/30 * * * * *")
		public void getUserData() {
		
			List<User> user=this.userService.getUserData();
			System.out.println(user);
			for(User users:user) {
				if(users.getStatus().equals("new")) {
					users.setStatus("Queue");
					output.send(MessageBuilder.withPayload(users).build());
					userUpdated.add(users);
				}
			}
			saveUserData();
		
		}


		private void saveUserData() {
			if(userUpdated.isEmpty()) {
			}else {
			this.userService.saveUserData(userUpdated);
			
			}
		}
		
		
		
		
		
}
