package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

//操作数据库中User表的类
public class UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 登陆方法
     * @param loginUser 只有用户名和密码
     * @return 包含用户全部数据
     */
    public User login(User loginUser){
        try {
            String sql = "select * from user where username= ? and password = ?";
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());

            return user;
        } catch (DataAccessException e) {
//            e.printStackTrace();
            return null;
        }
    }
}
