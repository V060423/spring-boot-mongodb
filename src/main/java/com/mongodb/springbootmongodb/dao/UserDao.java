package com.mongodb.springbootmongodb.dao;

import com.mongodb.springbootmongodb.domain.UserEntity;

/**
 * @author wangbowen
 * @Description TODO
 * @Date 2018/5/21 11:05
 */
public interface UserDao {

     void saveUser(UserEntity user);

     UserEntity findUserByUserName(String userName);

     int updateUser(UserEntity user);

     void deleteUserById(Long id);

}
