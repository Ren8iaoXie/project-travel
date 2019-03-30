package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author xieren8iao
 * @create 2019/3/26 - 15:05
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 通过用户名查找是否存在用户
     *
     * @param username
     * @return user
     */
    @Override
    public User findByUsername(String username) {
        String sql = "select * from tab_user where username=?";
        //此方法如果没有查到，不会返回null，而是会报异常

        User user = null;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username);
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    /**
     * 存储用户信息
     *
     * @param user
     */
    @Override
    public void save(User user) {
        String sql = "insert into tab_user(username,password,name,birthday,sex,telephone,email,status,code) values" +
                "(?,?,?,?,?,?,?,?,?)";
        template.update(sql, user.getUsername(), user.getPassword(),
                user.getName(), user.getBirthday(),
                user.getSex(), user.getTelephone(),
                user.getEmail(),user.getStatus(),
                user.getCode());
    }

    /**
     * 通过激活码查询用户
     * @param code
     * @return
     */
    @Override
    public User findByCode(String code) {
        String sql="select * from tab_user where code=?";
        User user=null;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), code);
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    /**
     * 设置状态为激活
     * @param user
     */
    @Override
    public void updateStatus(User user) {
        String sql="update tab_user set status='Y' where uid=?";
        template.update(sql,user.getUid());
    }

    /**
     * 根据用户名和密码查找是否有该用户
     * @param username
     * @param password
     * @return
     */
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        String sql="select * from tab_user where username=? and password =?";
        User user=null;
        try {
           user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username,password);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }
}
