package com.services;

import com.dao.UserMapper;
import com.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSevices {

    @Autowired
    private UserMapper userMapper;

    public User getUser (@Param("Fname_l2") String Fname_l2){
        return userMapper.sel(Fname_l2);
    }


}
