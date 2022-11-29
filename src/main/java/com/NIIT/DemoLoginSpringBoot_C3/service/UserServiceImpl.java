/*
 *Author Name: Aman Singh
 *Date:29-11-2022
 *Created With: Intellij IDEA Community Edition
 */
package com.NIIT.DemoLoginSpringBoot_C3.service;

import com.NIIT.DemoLoginSpringBoot_C3.domain.User;
import com.NIIT.DemoLoginSpringBoot_C3.exception.Usernotfoundexception;
import com.NIIT.DemoLoginSpringBoot_C3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IuserService {
    public UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User logincheck(String username, String password) throws Usernotfoundexception {
        User userobj = userRepository.findByUsernameAndPassword(username, password);
        if (userobj == null) {
            throw new Usernotfoundexception();
        }
        return userobj;
    }

    @Override
    public Optional<User> getbyUserId(int uid) {
        return userRepository.findById(uid);
    }

}
