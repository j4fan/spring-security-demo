package com.j4fan.springsecuritydemo.repository;

import com.j4fan.springsecuritydemo.domin.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserInfo, Integer> {

    boolean existsByEmail(String email);

    UserInfo getByUserName(String userName);
}
