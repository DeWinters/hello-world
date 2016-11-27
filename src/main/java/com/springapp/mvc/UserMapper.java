package com.springapp.mvc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

/**
 * Created by Administrator on 27/11/2016.
 */

public class UserMapper implements ParameterizedRowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getInt("user_id"));
        user.setUserName(resultSet.getString("user_name"));
        user.setPassKey(resultSet.getString("pass_key"));
        return user;
    }
}
