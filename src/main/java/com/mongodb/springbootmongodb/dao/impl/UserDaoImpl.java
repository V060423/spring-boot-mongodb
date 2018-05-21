package com.mongodb.springbootmongodb.dao.impl;

import com.mongodb.client.result.UpdateResult;
import com.mongodb.springbootmongodb.dao.UserDao;
import com.mongodb.springbootmongodb.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Objects;


/**
 * @author wangbowen
 * @Description TODO
 * @Date 2018/5/21 11:06
 */
@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public void saveUser(UserEntity user) {
        mongoTemplate.save(user);
    }

    @Override
    public UserEntity findUserByUserName(String userName) {
        Query query = new Query(Criteria.where("userName").is(userName));
        UserEntity user = mongoTemplate.findOne(query, UserEntity.class);
        return user;
    }

    @Override
    public int updateUser(UserEntity user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update  = new Update().set("userName",user.getUserName()).set("passWord",user.getPassWord());
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, UserEntity.class);
        //更新全部的集合
        //mongoTemplate.updateMulti(query,update,UserEntity.class);
        if(Objects.nonNull(updateResult)){
            return (int) updateResult.getModifiedCount();
        }
        return 0;
    }

    @Override
    public void deleteUserById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,UserEntity.class);
    }
}
