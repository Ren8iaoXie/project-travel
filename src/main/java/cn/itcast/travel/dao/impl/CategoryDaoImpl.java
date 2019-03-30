package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

/**
 * @author xieren8iao
 * @create 2019/3/27 - 20:48
 */
public class CategoryDaoImpl implements CategoryDao {
    //jdbcTempl对象
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    /**
     * 查找所有分类的信息并返回
     */
    public List<Category> findAll() {
        String sql= "select * from tab_category";
        return template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
    }
}
