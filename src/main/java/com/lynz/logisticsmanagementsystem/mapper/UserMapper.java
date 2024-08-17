package com.lynz.logisticsmanagementsystem.mapper;

import com.lynz.logisticsmanagementsystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    User selectUserByUsername(String username);

    String selectPasswordByUsername(String username);

    void insertUser(User user);

    int checkRoot(String username);

}
