package cn.itcast.travel.service.Impl;

import cn.itcast.travel.dao.RouteImgDao;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**旅游图片存放资源路径业务层
 * @author xieren8iao
 * @create 2019/3/29 - 18:07
 */
public class RouteImgDaoImpl implements RouteImgDao {
    JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    /**
     * 根据id查找旅游路线相关的图片路径资源
     */
    public List<RouteImg> findByRid(int rid) {
        String sql="select * from tab_route_img where rid=?";
        return template.query(sql,new BeanPropertyRowMapper<RouteImg>(RouteImg.class),rid);
    }
}
