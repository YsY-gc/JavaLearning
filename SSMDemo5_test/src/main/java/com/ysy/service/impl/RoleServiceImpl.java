package com.ysy.service.impl;

import com.ysy.dao.RoleDao;
import com.ysy.domain.Role;
import com.ysy.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> list() {
        List<Role> roleList = roleDao.findAll();

        return  roleList;
    }

    public void save(Role role) {

        roleDao.save(role);

    }


}
