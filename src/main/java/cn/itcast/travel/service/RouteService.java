package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

/**
 * @author xieren8iao
 * @create 2019/3/28 - 14:13
 */
public interface RouteService {
    /**
     * 查询记录分页
     * @param cid
     * @param currentPage
     * @param pageSize
     * @param rname
     * @return
     */
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname);

    public Route find(int rid);
}
