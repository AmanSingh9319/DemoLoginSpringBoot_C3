package com.NIIT.DemoLoginSpringBoot_C3.repository;

import com.NIIT.DemoLoginSpringBoot_C3.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUsernameAndPassword(String username, String password);
}
