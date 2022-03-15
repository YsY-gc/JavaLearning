package com.ysy.service.impl;

import com.ysy.com.ysy.dao.AcountDao;
import com.ysy.service.AcountService;

public class AcountServiceImpl implements AcountService {

    private AcountDao acountDao;
    public void setAcountDao(AcountDao acountDao) {
        this.acountDao = acountDao;
    }

    @Override
    public void transfer(String username1, String username2, int money) {

        acountDao.out(username1, money);
//        int i=1/0;
        acountDao.in(username2, money);

    }
}
