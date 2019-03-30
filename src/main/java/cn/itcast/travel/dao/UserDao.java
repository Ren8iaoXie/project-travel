package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

/**用户数据层操作
 * @author xieren8iao
 * @create 2019/3/26 - 15:04
 */

public interface UserDao {
    /**
     * 通过用户名查找是否存在用户
     * @param username
     * @return
     */
    public User findByUsername(String username);
    /**
     * 存储用户信息
     * @param user
     */
    public void save(User user);

    /**
     * 通过激活码查询用户
     * @param code
     * @return
     */
    public User findByCode(String code);

    /**
     * 更新激活状态
     * @param user
     */
    public void updateStatus(User user);

    /**
     * 通过用户名和密码查找用户
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String username,String password);
}
