package com.hhsj.Shopping.dao.Gwc;

import com.hhsj.Shopping.pojo.Commodity.Commodity;
import com.hhsj.Shopping.pojo.Gl.Gl;
import com.hhsj.Shopping.pojo.Gwc.Gwc;
import com.hhsj.Shopping.pojo.Gwc.GwcCustom;
import com.hhsj.Shopping.pojo.User.User;

import java.util.List;

/**
 * Created by xtnloveyou on 2019/7/11.
 */
public interface GwcMapper {
    /**
     * 首页购物车商品信息查询
     * @param gwc
     * @return
     */
    public List<Gwc> findGwc(Gwc gwc)throws  Exception;

    /**
     * 购物车总价钱查询
     * @param user_id
     * @return
     * @throws Exception
     */
    public Gwc findGwcSum(Integer user_id)throws  Exception;

    /**
     * 购物车清单查询
     * @param gwc
     * @return
     * @throws Exception
     */
    public List<Gwc> findGwcQd(Gwc gwc)throws Exception;


    /**
     * 购物车收藏
     * @param gwc
     * @return
     */
    public int addGwc(Gwc gwc)throws Exception;

    /**
     * 按id删除购物车商品
     * @param id
     * @return
     */
    public int GwcDelete(Integer id)throws  Exception;

    /**
     * 总价钱和总条数
     * @param user
     * @return
     */
    public GwcCustom findCount(User user)throws  Exception;



    public GwcCustom findGwcCount(Integer id)throws  Exception;

    /**
     * 修改checkbox的值
     * @param id
     * @return
     * @throws Exception
     */
    public int Updatecheckbox(Gwc gwc)throws Exception;

    /**
     * 购物车清单总条数
     * @param gwc
     * @return
     * @throws Exception
     */
    public GwcCustom count(Gwc gwc) throws Exception;


    /**
     * 购物车清单总条数
     * @param gwc
     * @return
     * @throws Exception
     */
    public GwcCustom count1(Gwc gwc) throws Exception;

    /**
     * 关系添加
     * @param gl
     * @return
     * @throws Exception
     */
    public int addGl(Gl gl)throws Exception;

    /**
     * 订单添加
     * @param commodity
     * @return
     * @throws Exception
     */
    public int addCategory(Commodity commodity)throws Exception;

    public int findId();
    int findOrderId(int id);

    /**
     * 删除购物车信息
     * @param gwc
     * @return
     */
    public int deleteGwc(Gwc gwc)throws  Exception;

    /**
     * 查询购物车清单
     * @param gwc
     * @return
     * @throws Exception
     */
    public List<Gwc> findGwcQd1(Gwc gwc)throws Exception;


    /**
     * 删除购物车信息
     * @param gwc
     * @return
     */
    public int deleteGwc1(Gwc gwc)throws  Exception;


    /**
     * 修改商品数量
     * @param gwc
     * @return
     * @throws Exception
     */
    public int UpdateNumber(Gwc gwc)throws  Exception;

    /**
     * 查询商品次数
     * @param gwc
     * @return
     */
    public int findOrder_id(Gwc gwc);

    /**
     * 商品数量查询
     * @param gwc
     * @return
     */
    public Gwc findNumber(Gwc gwc);

}
