package com.hhsj.Shopping.dao.Order;

import com.hhsj.Shopping.pojo.Adderss.Address;
import com.hhsj.Shopping.pojo.Order.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xtnloveyou on 2019/7/1.
 */
public interface OrderMapper {

    /**
     * 首页按名称查询商品
     * @param order
     * @return
     * @throws Exception
     */
    public List<Order> findShangPing(Order order)throws Exception;

    /**
     * 首页商品推荐查询
     *
     * @return
     * @throws Exception
     */
    public List<Order> findRecommend(Order order) throws Exception;

    /**
     * 首页商品促销查询
     *
     * @return
     * @throws Exception
     */
    public List<Order> findPromotion(Order orderr) throws Exception;


    /***
     * 首页杯子系列查询
     *
     * @return
     * @throws Exception
     */
    public List<Order> findOrder(Order order) throws Exception;

    /**
     * 首页餐具系列查询
     * @return
     * @throws Exception
     */
    public List<Order> findTableware(Order order)throws Exception;

    /**
     * 首页纸浆系列查询
     * @return
     * @throws Exception
     */
    public List<Order> findPaper1(Order order)throws Exception;

    /**
     * 首页所有商品模糊查询杯子
     * @param
     * @param
     * @param
     * @return
     * @throws Exception
     */
    public List<Order> findBeizhi(@Param(value = "name") String name)throws  Exception;

    /**
     * 按id查询商品
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Order findById(Integer id) throws Exception;

    /**
     * 促销中心查询最低价
     *
     * @param order
     * @return
     * @throws Exception
     */
    public List<Order> findAgnet(Order order) throws Exception;

    /**
     * 按id查询商品订单
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Order findPrice(Integer id) throws Exception;

    /**
     * 按商品id修改商品购买数量
     * @param order
     * @return
     */
    public int  UpdatePrice(Order order)throws  Exception;

    /**
     * 查询购物信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Order orderDetails(Integer id) throws Exception;


    /**
     * 修改地址信息
     *
     * @param address
     * @return
     * @throws Exception
     */
    public int UpdateAddress(Address address) throws Exception;

    /***
     * 查询单层杯子
     *
     * @return
     * @throws Exception
     */
    public List<Order> findOrders(Order order) throws Exception;

    /**
     * 查询被子系类双层纸杯
     *
     * @param order
     * @return
     * @throws Exception
     */
    public List<Order> findDeck(Order order) throws Exception;


    /**
     * 查询瓦楞杯子
     *
     * @param order
     * @return
     * @throws Exception
     */
    public List<Order> findFlutin(Order order) throws Exception;

    /**
     * 查询透明杯子
     *
     * @param order
     * @return
     * @throws Exception
     */
    public List<Order> findLucency(Order order) throws Exception;


    /**
     * 查询冰淇淋杯子
     *
     * @param order
     * @return
     * @throws Exception
     */
    public List<Order> findCream(Order order) throws Exception;

    /**
     * 按id查询用户信息
     * @param user_id
     * @return
     */
    public List<Address> findAddress(Integer user_id)throws Exception;


    /**
     * 查询地址
     * @param user_id
     * @return
     * @throws Exception
     */
    public Address findAddress2(Integer user_id)throws Exception;


    /**
     * 按id查询用户信息
     * @param user_id
     * @return
     */
    public Address findAddress1(Integer user_id)throws Exception;

//分层线（）-----------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * 查询蛋糕分类
     *
     * @param order
     * @return
     * @throws Exception
     */
    public List<Order> findCake(Order order) throws Exception;


    /**
     * 查询沙拉分类
     *
     * @param order
     * @return
     * @throws Exception
     */
    public List<Order> findSalad(Order order) throws Exception;

    /**
     * 查询西餐分类
     *
     * @param order
     * @return
     * @throws Exception
     */
    public List<Order> findWestern(Order order) throws Exception;

    /**
     * 查询中餐分类
     *
     * @param order
     * @return
     * @throws Exception
     */
    public List<Order> findChinese(Order order) throws Exception;

    /**
     * 查询外带打包分类
     *
     * @param order
     * @return
     * @throws Exception
     */
    public List<Order> findBale(Order order) throws Exception;

    //分层线（）-----------------------------------------------------------------------------------------------------------------------------------------------


    /**
     * 查询纸碟分类
     *
     * @param order
     * @return
     * @throws Exception
     */
    public List<Order> findPaper(Order order) throws Exception;

    /**
     * 查询纸袋分类
     *
     * @param order
     * @return
     * @throws Exception
     */
    public List<Order> findPaperBag(Order order) throws Exception;

    /**
     * 查询纸碗分类
     *
     * @param order
     * @return
     * @throws Exception
     */
    public List<Order> findPaperBowl(Order order) throws Exception;

    /**
     * 查询食用袋子分类
     *
     * @param order
     * @return
     * @throws Exception
     */
    public List<Order> findDoggieBag(Order order) throws Exception;

    /**
     * 查询打包分类
     *
     * @param order
     * @return
     * @throws Exception
     */
    public List<Order> findFoodBale(Order order) throws Exception;

}
