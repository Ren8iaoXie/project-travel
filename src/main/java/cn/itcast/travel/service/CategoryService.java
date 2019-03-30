package cn.itcast.travel.service;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * @author xieren8iao
 * @create 2019/3/27 - 20:48
 */
public interface CategoryService {
    /**
     * 查找分类列表的信息
     * @return
     */
    public List<Category> findAll();
}
