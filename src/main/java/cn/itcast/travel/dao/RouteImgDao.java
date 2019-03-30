package cn.itcast.travel.dao;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;

/**路线图片数据层
 * @author xieren8iao
 * @create 2019/3/29 - 18:06
 */
public interface RouteImgDao {
    /**
     * 查找旅游路线相关展示图片资源路径
     * @param rid
     * @return
     */
    public List<RouteImg> findByRid(int rid);
}
