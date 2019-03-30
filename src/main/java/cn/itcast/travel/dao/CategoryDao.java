package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**分类数据层
 * @author xieren8iao
 * @create 2019/3/27 - 20:46
 */
public interface CategoryDao {
    /**
     * 查找所有分类
     * @return
     */
    public List<Category> findAll();
}
