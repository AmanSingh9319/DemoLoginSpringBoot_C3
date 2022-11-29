package com.NIIT.DemoLoginSpringBoot_C3.service;

import com.NIIT.DemoLoginSpringBoot_C3.domain.User;
import com.NIIT.DemoLoginSpringBoot_C3.exception.Usernotfoundexception;

import java.util.List;
import java.util.Optional;

public interface IuserService {
    public User saveUser(User user);

    public List<User> getAllUsers();

    public User logincheck(String username, String password) throws Usernotfoundexception;

    public Optional<User> getbyUserId(int uid);
}
