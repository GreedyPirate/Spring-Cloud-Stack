package com.ttyc.security.service.impl;

import com.ttyc.mq.common.exception.ServiceException;
import com.ttyc.security.error.SecurityError;
import com.ttyc.security.mapper.UserMapper;
import com.ttyc.security.model.User;
import com.ttyc.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 查询账号是否存在
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getByUsername(username);
        if(user == null){
           throw new SecurityException(new ServiceException(SecurityError.INVALID_USERNAME));
        }
        return user;
    }
}
