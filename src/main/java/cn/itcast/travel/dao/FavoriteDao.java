package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;

/**收藏数据层
 * @author xieren8iao
 * @create 2019/3/29 - 22:04
 */
public interface FavoriteDao {
    /**
     * 通过uid和rid查找favorite
     * @param uid
     * @param rid
     * @return
     */
    public Favorite findByUidAndRid(int uid,int rid);

    /**
     * 查找收藏次数
     * @param rid
     * @return
     */
    public int findCountByRid(int rid);

    /**
     * 添加收藏
     * @param rid
     * @param uid
     */
    public void addFavorite(int rid,int uid);
}
