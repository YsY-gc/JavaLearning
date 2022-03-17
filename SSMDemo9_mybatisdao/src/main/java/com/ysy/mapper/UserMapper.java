package com.ysy.mapper;

import com.ysy.domain.User;

import java.util.List;

public interface UserMapper {

    public List<User> findAll();

    public User findById(int id);

    public List<User> findUserByCondition(User user);

    public List<User> findUserByIds(List<Integer> ids);

}
