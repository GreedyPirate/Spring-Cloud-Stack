package com.ttyc.spring.base.service;

import com.ttyc.spring.base.dao.UserDao;
import com.ttyc.spring.base.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Transactional
    public Boolean regist() {
        User jack = User.builder().name("jack").phone("110").build();
        userDao.save(jack);

        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public int getOrder() {
                return 1;
            }

            @Override
            public void afterCommit() {
                System.out.println("send a mail");
            }
        });
        if (true) throw new RuntimeException("fail insert");
        return Boolean.FALSE;
    }
}
