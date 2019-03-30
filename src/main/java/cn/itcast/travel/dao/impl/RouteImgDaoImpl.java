package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteImgDao;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author xieren8iao
 * @create 2019/3/29 - 18:18
 */
public class RouteImgDaoImpl implements RouteImgDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    /**
     * 查找旅游路线相关的的图片存放的资源位置
     */
    public List<RouteImg> findByRid(int rid) {
        String sql="select * from tab_route_img where rid=?";
        return template.query(sql, new BeanPropertyRowMapper<RouteImg>(RouteImg.class),rid);
    }
}
