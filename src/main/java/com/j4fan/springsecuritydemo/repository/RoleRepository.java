package com.j4fan.springsecuritydemo.repository;

import com.j4fan.springsecuritydemo.domin.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    List<Role> getRolesByUserId(Integer userId);
}
