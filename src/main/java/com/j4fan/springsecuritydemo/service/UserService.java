package com.j4fan.springsecuritydemo.service;

import com.j4fan.springsecuritydemo.domin.Role;
import com.j4fan.springsecuritydemo.domin.UserDTO;
import com.j4fan.springsecuritydemo.domin.UserInfo;
import com.j4fan.springsecuritydemo.exception.EmailExistsException;
import com.j4fan.springsecuritydemo.repository.RoleRepository;
import com.j4fan.springsecuritydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public UserDTO saveUser(UserDTO userDTO) {
        if (checkEmailExists(userDTO.getEmail())) {
            throw new EmailExistsException("邮箱[" + userDTO.getEmail() + "]已存在");
        }
        UserInfo userInfo = userDTO.convertToUser();
        userRepository.save(userInfo);
        UserDTO output = userDTO.convertFor(userInfo);
        return output;
    }

    private boolean checkEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userRepository.getByUserName(username);
        if (userInfo == null) {
            throw new RuntimeException("未查询到该用户:" + username);
        }
        Integer userId = userInfo.getId();

        List<Role> roles = roleRepository.getRolesByUserId(userId);
        userInfo.setRoles(roles);
        return userInfo;
    }
}
