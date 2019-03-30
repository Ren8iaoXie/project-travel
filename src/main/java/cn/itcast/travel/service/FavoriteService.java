package cn.itcast.travel.service;

/**
 * @author xieren8iao
 * @create 2019/3/29 - 21:57
 */
public interface FavoriteService {
    public Boolean isFavorite(int uid,int rid);
    public void addFavorite(int rid,int uid);
}
