package com.guangfuxiong.springjdbc.mapper;

import com.guangfuxiong.springjdbc.pojo.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    /*
	 * 该方法的作用 是将返回的map再次包装为User对象(non-Javadoc)
	 * set: 返回的结果集对象
	 * index:当前正在转化的行号 下标从0;
	 */
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt(1));
        user.setName(resultSet.getString(2));
        user.setAge(resultSet.getInt(3));
        return user;
    }
}
