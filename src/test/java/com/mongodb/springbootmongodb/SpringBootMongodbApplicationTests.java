package com.mongodb.springbootmongodb;

import com.mongodb.springbootmongodb.dao.UserDao;
import com.mongodb.springbootmongodb.domain.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMongodbApplicationTests {
	@Autowired
	private UserDao userDao;
	@Test
	public void saveUser() {
		UserEntity user = new UserEntity();
		user.setId(1L);
		user.setUserName("小蚊子");
		user.setPassWord("123456");
		userDao.saveUser(user);
	}

	@Test
	public void find(){
        UserEntity userEntity = userDao.findUserByUserName("小蚊子");
        System.out.println("查询数据");
        System.out.println(userEntity.getId()+"_"+userEntity.getUserName()+"_"+userEntity.getPassWord());
    }

    @Test
    public  void update(){
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setUserName("小蚊子2");
        user.setPassWord("1234567");
        userDao.updateUser(user);
    }
    @Test
    public void  remove(){
	    userDao.deleteUserById(1L);
    }
}
