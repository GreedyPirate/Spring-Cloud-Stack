package com.ttyc.doc.cache.helper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRepository {
    @Select("select * from user")
    List<User> query();
}
