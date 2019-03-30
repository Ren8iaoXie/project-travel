package cn.itcast.travel.service.Impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**关于Categony的业务层
 * @author xieren8iao
 * @create 2019/3/27 - 20:49
 */
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao dao=new CategoryDaoImpl();

    /**
     * 查找分类列表的信息，使用了redis缓存
     * @return
     */
    @Override
    public List<Category> findAll() {
        Jedis jedis = JedisUtil.getJedis();
        //jedis sortedSet排序存储
       /* Set<String> category = jedis.zrange("category", 0, -1);*/
        //带有分数的set
        Set<Tuple> category = jedis.zrangeWithScores("category", 0, -1);

        List<Category> list =null;
        if(category==null||category.size()==0){
            //缓存里没有数据
//            System.out.println("从数据库查询");
            list = dao.findAll();
            for (int i = 0; i < list.size(); i++) {
                jedis.zadd("category", list.get(i).getCid(),list.get(i).getCname());
            }
        }else {
            //redis缓存里有数据
//            System.out.println("缓存查询");
            list=new ArrayList<Category>();
            for (Tuple tuple : category) {
                Category c = new Category();
                c.setCname(tuple.getElement());
                c.setCid((int)tuple.getScore());
                list.add(c);
            }
        }
        return dao.findAll();
    }
}
