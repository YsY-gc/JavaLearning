package com.ysy.mapper;

import com.ysy.domain.User;

import java.util.List;

public interface UserMapper {
    public List<User> findUserAndRoleAll();
}
