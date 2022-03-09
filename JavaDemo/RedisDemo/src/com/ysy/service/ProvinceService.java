package com.ysy.service;

import com.ysy.domain.Province;

import java.util.List;

public interface ProvinceService {
    public List<Province> findAll();
    public String findAllJson();
}
