package com.ttyc.doc.cache.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Cacheable("allUsers")
    public List<User> query(){
        return userRepository.query();
    }

    @CacheEvict("allUsers")
    public void insert(User user){
        userRepository.insert(user);
    }
}
