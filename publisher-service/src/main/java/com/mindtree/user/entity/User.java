package com.mindtree.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	private int id;
	private String name;
	private String status;

	
}
