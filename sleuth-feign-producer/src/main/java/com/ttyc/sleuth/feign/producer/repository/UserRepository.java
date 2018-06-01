package com.ttyc.sleuth.feign.producer.repository;

import com.ttyc.sleuth.feign.producer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
