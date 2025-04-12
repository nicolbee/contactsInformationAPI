package com.example.api.Contacts.api.UserRepository;


import com.example.api.Contacts.api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    // This will allow you to work with MongoDB's _id field as String
}

