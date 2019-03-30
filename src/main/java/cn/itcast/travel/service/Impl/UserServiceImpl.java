package cn.itcast.travel.service.Impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

/**用户业务层
 * @author xieren8iao
 * @create 2019/3/26 - 15:06
 */
public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();

    /**
     * 判断是否注册
     * @param user
     * @return
     */
    @Override
    public Boolean regist(User user) {
        User u = dao.findByUsername(user.getUsername());
        if(u!=null){
            return false;
        }
        //UUID很小概率重复
        user.setCode(UuidUtil.getUuid());
        user.setStatus("N");
        String context="<a href='http://localhost/travel/user/active?code="+user.getCode()+"'>点击激活【黑马旅游网】</a>";
        MailUtils.sendMail(user.getEmail(), context, "激活邮件");
        dao.save(user);
        return true;
    }

    /**
     * 判断是否激活
     * @param code
     * @return
     */
    @Override
    public Boolean active(String code) {
        //根据激活码查询用户是否存在
        User user=dao.findByCode(code);
        //设置状态为激活
        if(user!=null) {
            dao.updateStatus(user);
            return true;
        }
        return false;
    }

    /**
     * 登陆功能
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return dao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
