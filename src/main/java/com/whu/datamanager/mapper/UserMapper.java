package com.whu.datamanager.mapper;

import com.whu.datamanager.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("insert into user (username,birthday,password,email) values (#{username},#{birthday},#{password},#{email})")
    void insert(User user);
}
