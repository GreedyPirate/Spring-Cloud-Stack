package com.ttyc.security.service.impl;

import com.ttyc.mq.common.exception.ServiceException;
import com.ttyc.security.error.SecurityError;
import com.ttyc.security.mapper.UserMapper;
import com.ttyc.security.model.User;
import com.ttyc.security.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    /**
     * 查询账号是否存在
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getByUsername(username);
        if (user == null) {
            logger.info("无效的用户名：" + username);
            throw new SecurityException(new ServiceException(SecurityError.INVALID_USERNAME));
        }
        String password = user.getPassword();
        return new org.springframework.security.core.userdetails.User(username, password, AuthorityUtils.createAuthorityList("ADMIN"));
    }
}
