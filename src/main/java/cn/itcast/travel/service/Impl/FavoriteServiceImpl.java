package cn.itcast.travel.service.Impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.service.FavoriteService;

/**收藏业务层
 * @author xieren8iao
 * @create 2019/3/29 - 21:59
 */
public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao favoriteDao=new FavoriteDaoImpl();
    @Override
    public Boolean isFavorite(int uid,int rid) {
        Favorite favorite = favoriteDao.findByUidAndRid(uid, rid);

        return favorite!=null;//如果有值，表示收藏过，否则反之
    }

    @Override
    public void addFavorite(int rid, int uid) {
        favoriteDao.addFavorite(rid, uid);
    }
}
