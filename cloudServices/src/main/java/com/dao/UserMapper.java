package com.dao;

import com.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User sel(String fname_l2);
}
