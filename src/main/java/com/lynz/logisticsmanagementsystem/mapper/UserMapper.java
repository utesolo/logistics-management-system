package com.lynz.logisticsmanagementsystem.mapper;

import com.lynz.logisticsmanagementsystem.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    user selectUserByUsername(String username);

    String selectPasswordByUsername(String username);

    void insertUser(user user);

    int checkRoot(String username);

    String getProfile(String username);

}
