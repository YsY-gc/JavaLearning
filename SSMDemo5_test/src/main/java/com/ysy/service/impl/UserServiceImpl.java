package com.ysy.service.impl;

import com.ysy.dao.RoleDao;
import com.ysy.dao.UserDao;
import com.ysy.domain.Role;
import com.ysy.domain.User;
import com.ysy.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<User> list() {
        List<User> userList = userDao.findAll();

        for (User user : userList) {
            Long id = user.getId();

            List<Role> roles = roleDao.findRoleByUserId(id);
            user.setRoles(roles);

        }

        return userList;
    }

    public void save(User user, Long[] roleIds) {
        //向sys_user表中存储数据
        Long userId = userDao.save(user);
        //向sys_user_role中存储多条数据
        userDao.saveUserRoleRel(userId, roleIds);
    }

    public void del(Long userId) {
        userDao.delUserRoleRel(userId);
        userDao.delUser(userId);
    }
}
