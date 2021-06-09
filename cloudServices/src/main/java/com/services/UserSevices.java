package com.services;

import com.dao.UserMapper;
import com.entity.User;
import com.util.RedisUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSevices {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    public User getUser (@Param("Fname_l2") String Fname_l2){
        User user =  new User();
        if(redisUtil.exists(Fname_l2)){
             redisUtil.getString(Fname_l2);
            user.setFNAME_L2(Fname_l2);

        }else {

            user =  userMapper.sel(Fname_l2);
            redisUtil.setString(Fname_l2,10,Fname_l2);
        }
        return user;
    }
}
