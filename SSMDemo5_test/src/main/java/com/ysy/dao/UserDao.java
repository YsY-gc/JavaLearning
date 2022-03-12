package com.ysy.dao;

import com.ysy.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    Long save(User user);

    void saveUserRoleRel(Long userId, Long[] roleIds);


    void delUserRoleRel(Long userId);

    void delUser(Long userId);
}
