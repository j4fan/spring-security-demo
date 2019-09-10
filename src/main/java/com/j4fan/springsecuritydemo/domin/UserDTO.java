package com.j4fan.springsecuritydemo.domin;

import com.j4fan.springsecuritydemo.annotations.PasswordMatcher;
import com.j4fan.springsecuritydemo.annotations.ValidEmail;
import com.j4fan.springsecuritydemo.converter.DTOConvert;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@PasswordMatcher
public class UserDTO {

    @NotNull
    @NotEmpty
    private String userName;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String matchPassword;

    @NotNull
    @NotEmpty
    private String mobile;

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;


    public UserInfo convertToUser() {
        return new UserInfoConverter().doForward(this);
    }

    public UserDTO convertFor(UserInfo userInfo) {
        return new UserInfoConverter().doBackward(userInfo);
    }

    private static class UserInfoConverter implements DTOConvert<UserDTO, UserInfo> {

        @Override
        public UserInfo doForward(UserDTO userDTO) {
            UserInfo userInfo = new UserInfo();
            BeanUtils.copyProperties(userDTO, userInfo);
            return userInfo;
        }

        @Override
        public UserDTO doBackward(UserInfo userInfo) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userInfo, userDTO);
            return userDTO;
        }
    }

}
