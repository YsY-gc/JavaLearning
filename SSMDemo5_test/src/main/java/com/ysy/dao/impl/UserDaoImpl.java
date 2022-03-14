package com.ysy.dao.impl;

import com.ysy.dao.UserDao;
import com.ysy.domain.User;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAll() {

        List<User> userList = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));

        return userList;
    }

    public Long save(final User user) {
//        jdbcTemplate.update("insert into sys_user values(?,?,?,?,?)", null, user.getUsername(),user.getEmail(),user.getPassword(), user.getPhoneNum());
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                //使用原始jdbc
                PreparedStatement preparedStatement = con.prepareStatement("insert into sys_user values(?,?,?,?,?) ", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1,null);
                preparedStatement.setString(2,user.getUsername());
                preparedStatement.setString(3,user.getEmail());
                preparedStatement.setString(4,user.getPassword());
                preparedStatement.setString(5,user.getPhoneNum());


                return preparedStatement;
            }
        };

        KeyHolder keyHolder = new GeneratedKeyHolder();


        jdbcTemplate.update(psc, keyHolder);

        return keyHolder.getKey().longValue();

    }

    public void saveUserRoleRel(Long userId, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role value(?,?)", userId, roleId);
        }

    }

    public void delUserRoleRel(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId=?", userId);

    }

    public void delUser(Long userId) {
        jdbcTemplate.update("delete from sys_user where id=?", userId);

    }

    public User login(String username, String password) {
        User user = jdbcTemplate.queryForObject("select * from sys_user where username=? and password=?", new BeanPropertyRowMapper<User>(User.class), username, password);
        return user;
    }


}
