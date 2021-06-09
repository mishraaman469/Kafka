package com.mindtree.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.consumer.entity.User;

@Repository
public interface ConsumerRepository extends JpaRepository<User, Integer> {

}
