package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

/**
 * 查询是否有收藏
 *
 * @author xieren8iao
 * @create 2019/3/29 - 22:04
 */
public class FavoriteDaoImpl implements FavoriteDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Favorite findByUidAndRid(int uid, int rid) {
        String sql = "select * from tab_favorite where uid=? and rid=?";
        Favorite favorite = null;
        try {
            favorite = template.queryForObject(sql, new BeanPropertyRowMapper<Favorite>(Favorite.class), uid, rid);
            //如果查不到数据返回null
        } catch (DataAccessException e) {

        }
        return favorite;
    }

    @Override
    public int findCountByRid(int rid) {
        String sql = "select count(*) from tab_favorite where rid=?";
        return template.queryForObject(sql, Integer.class, rid);

    }

    @Override
    public void addFavorite(int rid, int uid) {
        String sql="insert into tab_favorite (rid,date,uid) values(?,?,?)";


        template.update(sql,rid,new Date(),uid);
        /*

        String sql = "insert into tab_favorite values(?,?,?)";

        template.update(sql,rid,new Date(),uid);*/
    }
}
