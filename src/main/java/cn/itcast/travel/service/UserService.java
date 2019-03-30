package cn.itcast.travel.service;

import cn.itcast.travel.domain.User;

/**
 * @author xieren8iao
 * @create 2019/3/26 - 15:06
 */
public interface UserService {
    /**
     * 注册用户
     * @param user
     * @return
     */
    public Boolean regist(User user);

    /**
     * 验证激活码
     * @param code
     * @return
     */
    public Boolean active(String code);

    public User login(User user);
}
