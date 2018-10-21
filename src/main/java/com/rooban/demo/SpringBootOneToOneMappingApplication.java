package com.rooban.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rooban.demo.model.User;
import com.rooban.demo.model.UserProfile;
import com.rooban.demo.repository.UserProfileRepository;
import com.rooban.demo.repository.UserRepository;

@SpringBootApplication
public class SpringBootOneToOneMappingApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserProfileRepository userProfileRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOneToOneMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//userProfileRepository.deleteAllInBatch();
        //userRepository.deleteAllInBatch();
        
        User user = new User("admin@gmail.com","password");
        UserProfile userProfile = new UserProfile("testing");
        
        user.setUserProfile(userProfile);
        userProfile.setUser(user);
        userRepository.save(user);
        
        User userResponse = userRepository.getOne((long) 10);
        UserProfile userprofileResponse = userResponse.getUserProfile();
        
        System.out.println(userprofileResponse.getId());
        System.out.println(userprofileResponse.getCountry());
        System.out.println(userResponse.getId());
        
	}
}
