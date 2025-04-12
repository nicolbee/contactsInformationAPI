package com.example.api.Contacts.service;

import com.example.api.Contacts.api.model.User;
import com.example.api.Contacts.api.UserRepository.UserRepository; // Assuming you're using a repository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll(); // MongoDB fetch all users
    }

    // Get user by ID (using String for MongoDB ObjectId)
    public User getUser(String id) {
        return userRepository.findById(id).orElse(null);  // MongoDB find user by String ID
    }

    // Add user
    public User addUser(User user) {
        return userRepository.save(user);  // Save user to MongoDB
    }

	
	public User updateUserPartial(String id, User partialUser) {
		    return userRepository.findById(id).map(existingUser -> {
		        if (partialUser.getName() != null) {
		            existingUser.setName(partialUser.getName());
		        }
		        if (partialUser.getAge() != 0) { // assuming 0 means "not provided"
		            existingUser.setAge(partialUser.getAge());
		        }
		        if (partialUser.getEmail() != null) {
		            existingUser.setEmail(partialUser.getEmail());
		        }
		        return userRepository.save(existingUser);
		    }).orElse(null);
	}
}
