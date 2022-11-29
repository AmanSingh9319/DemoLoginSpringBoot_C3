/*
 *Author Name: Aman Singh
 *Date:29-11-2022
 *Created With: Intellij IDEA Community Edition
 */
package com.NIIT.DemoLoginSpringBoot_C3.controller;

import com.NIIT.DemoLoginSpringBoot_C3.domain.User;
import com.NIIT.DemoLoginSpringBoot_C3.exception.Usernotfoundexception;
import com.NIIT.DemoLoginSpringBoot_C3.service.SecurityTokenGenerator;
import com.NIIT.DemoLoginSpringBoot_C3.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class controller {
    private UserServiceImpl userServiceImpl;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public controller(UserServiceImpl userServiceImpl, SecurityTokenGenerator securityTokenGenerator) {
        this.userServiceImpl = userServiceImpl;
        this.securityTokenGenerator = securityTokenGenerator;
    }


    @PostMapping("/register")
    public ResponseEntity<?> saveFun(@RequestBody User user) {
        return new ResponseEntity<>(userServiceImpl.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/fetchAll")
    public ResponseEntity<?> fetchFun() {
        return new ResponseEntity<>(userServiceImpl.getAllUsers(), HttpStatus.FOUND);
    }

    @GetMapping("/api/v1/fetchById/{userId}")
    public ResponseEntity<?> fetchFunction(@PathVariable int userId) {
        return new ResponseEntity<>(userServiceImpl.getbyUserId(userId), HttpStatus.FOUND);
    }

    @GetMapping("/login")
    public ResponseEntity<?> fetchFunction1(@RequestBody User user) throws Usernotfoundexception {
        try {

            userServiceImpl.logincheck(user.getUsername(), user.getPassword());
            Map<String, String> secretary = new HashMap<>();
            secretary = securityTokenGenerator.generateToken(user);
            return new ResponseEntity<>(secretary, HttpStatus.FOUND);
        } catch (Usernotfoundexception exception) {
            throw new Usernotfoundexception();
        } catch (Exception ex) {
            return new ResponseEntity<>(" Network Error!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}


