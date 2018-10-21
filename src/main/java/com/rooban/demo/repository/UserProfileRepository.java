package com.rooban.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rooban.demo.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long>{

}
