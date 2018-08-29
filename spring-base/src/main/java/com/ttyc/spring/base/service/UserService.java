package com.ttyc.spring.base.service;

import com.ttyc.spring.base.dao.UserDao;
import com.ttyc.spring.base.error.ServiceException;
import com.ttyc.spring.base.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    NotifyService notifyService;

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
                notifyService.sendMail("send a mail");
            }

        });
        if (true) throw new RuntimeException("fail insert");
        return Boolean.FALSE;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean commit() {
        try {
            User jack = User.builder().name("mike").phone("120").build();
            userDao.save(jack);
            this.judge();
            return Boolean.TRUE;
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        return Boolean.FALSE;
    }

    private void judge() {
        if (true) {
            throw new ServiceException("wrong");
        }
    }

}
