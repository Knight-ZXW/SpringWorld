package com.zous.springworld.dao;

import com.zous.springworld.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by zhuoxiuwu on 2017/3/6.
 */
@Repository
public class UserDao implements IUserDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User queryOne(int id) {
        String sql = "SELECT * FROM user where id = " + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {
            @Override
            public User extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    User user = new User();
                    user.setName(rs.getString("name"));
                    return user;
                }
                return null;
            }
        });
    }

    @Override
    public User insertUser(User user) {
        return null;
    }
}
