package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.Seller;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xieren8iao
 * @create 2019/3/28 - 14:20
 */
public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int findTotalCount(int cid, String rname) {
        /*String sql="select count(*) from tab_route where cid=?";*/
        String sql="select  count(*) from tab_route where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        List params=new ArrayList();
        if(cid!=0){
            sb.append(" and cid=?");
            params.add(cid);

        }
        if(rname!=null&&rname.length()>0&&!"null".equals(rname)){
            sb.append(" and rname like ? ");
            params.add("%"+rname+"%");
        }
        sql=sb.toString();

        int count=template.queryForObject(sql, Integer.class, params.toArray());
        return count;
    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize, String rname) {

        /*String sql="select  * from tab_route where cid=? limit ?,?";*/
        String sql="select * from tab_route where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);

        List params=new ArrayList();
        if(cid!=0){
            sb.append(" and cid=?");
            params.add(cid);

        }

        if(rname!=null&&rname.length()>0){
            sb.append(" and rname like ? ");
            params.add("%"+rname+"%");
        }
        sb.append(" limit ?,?");
        params.add(start);
        params.add(pageSize);
        sql=sb.toString();
        return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class),params.toArray());
    }

    /**
     * 查询返回一个Seller对象，里面包含有关卖家信息
     * @param rid
     * @return
     */


    /**
     * 查询旅游路线的相关相信
     * @param rid
     * @return
     */
    @Override
    public Route findByRid(int rid) {
        String sql="select * from tab_route where rid=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class),rid);
    }
}
