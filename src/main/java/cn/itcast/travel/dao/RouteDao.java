package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.Seller;

import java.util.List;

/**路线数据层
 * @author xieren8iao
 * @create 2019/3/28 - 14:17
 */
public interface RouteDao {

    /**
     * 根据id查找总记录数
     * @param cid
     * @param rname
     * @return
     */
    public int findTotalCount(int cid, String rname);


    /**
     * 根据id和开始和查找的数量返回集合数据
     * @param cid
     * @param start
     * @param pageSize
     * @param rname
     * @return
     */
    public List<Route> findByPage(int cid, int start, int pageSize, String rname);

    /**
     * 通过rid查找route对象里的数据
     * @param rid
     * @return
     */
    public Route findByRid(int rid);
}
