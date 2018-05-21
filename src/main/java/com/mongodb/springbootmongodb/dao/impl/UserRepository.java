package com.mongodb.springbootmongodb.dao.impl;

import com.mongodb.springbootmongodb.domain.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wangbowen
 * @Description TODO
 * @Date 2018/5/21 11:33
 */
@Repository
public interface UserRepository  extends MongoRepository<UserEntity,Long> {

    UserEntity findByUserName(String userName);
}
