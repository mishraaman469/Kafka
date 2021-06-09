package com.mindtree.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.consumer.entity.User;
import com.mindtree.consumer.service.ConsumerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ConsumerController {
	
		@Autowired
		private ConsumerService consumerService;
		
		@StreamListener("input")
		public void userData(User user) {
			log.info(" Consume PayLoad "+user);
			this.consumerService.saveUserData(user);
		}
		
		
		/*@StreamListener("input")
		public void userData(List<User> user) {
			log.info(" Consume PayLoad "+user);
			this.consumerService.saveUserData(user);
		}*/
		
}
