package com.mindtree.logger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.logger.entity.User;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@EnableBinding(Source.class)
public class LoggerController {
	
		@Autowired
		private MessageChannel output;
	
		@StreamListener("input")
		public void getUserData(User user) {
			log.info("User Status "+user);
			user.setStatus("completed");
			output.send(MessageBuilder.withPayload(user).build());
		}
		
	
		
}
