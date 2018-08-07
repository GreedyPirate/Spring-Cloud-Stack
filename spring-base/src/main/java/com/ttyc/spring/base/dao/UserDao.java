package com.ttyc.spring.base.dao;

import com.ttyc.spring.base.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Long>{

}
