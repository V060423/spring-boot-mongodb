package com.mongodb.springbootmongodb.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangbowen
 * @Description TODO
 * @Date 2018/5/21 11:03
 */
@Data
public class UserEntity implements Serializable {
    private Long id;
    private String userName;
    private String passWord;

}
