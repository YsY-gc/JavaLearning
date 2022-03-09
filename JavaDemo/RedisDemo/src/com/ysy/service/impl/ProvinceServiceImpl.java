package com.ysy.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ysy.dao.ProvinceDao;
import com.ysy.dao.impl.ProvinceDaoImpl;
import com.ysy.domain.Province;
import com.ysy.jedis.util.JedisPoolUtils;
import com.ysy.service.ProvinceService;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {

    private ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {

        return  dao.findAll();

    }

    @Override
    public String findAllJson() {
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");
        
        if(province_json==null||province_json.length()==0){
            System.out.println("redis中没有数据，从数据库中查询数据");
            List<Province> ps = dao.findAll();
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            jedis.set("province", province_json);
            jedis.close();
        }else{
            System.out.println("从redis中获取数据");
        }


        return province_json;
    }
}
