package com.ttyc.security.mapper;

import com.ttyc.security.model.User;

public interface UserMapper {

    public User getByUsername(String username);
}
