package com.NIIT.DemoLoginSpringBoot_C3.service;


import com.NIIT.DemoLoginSpringBoot_C3.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {

    Map<String, String> generateToken(User user);
}

