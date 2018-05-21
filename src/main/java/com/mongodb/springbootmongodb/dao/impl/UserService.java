package com.mongodb.springbootmongodb.dao.impl;

import com.mongodb.springbootmongodb.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wangbowen
 * @Description TODO
 * @Date 2018/5/21 11:38
 */
@Component
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    public UserEntity findByUserName(String userName){
        UserEntity byUserName = userRepository.findByUserName(userName);
        return byUserName;
    }
}
