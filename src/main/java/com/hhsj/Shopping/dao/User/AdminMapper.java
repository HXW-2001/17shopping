package com.hhsj.Shopping.dao.User;

import com.hhsj.Shopping.pojo.Commodity.Commodity;
import com.hhsj.Shopping.pojo.Commodity.CommodityCustom;
import com.hhsj.Shopping.pojo.Order.Order;
import com.hhsj.Shopping.pojo.User.Admin;
import com.hhsj.Shopping.pojo.User.User;

import java.util.List;

/**
 * Created by xtnloveyou on 2019/7/4.
 */
public interface AdminMapper {

    /**
     * 系统管理登录
     *
     * @param admin
     * @return
     */
    public Admin adminLogin(Admin admin) throws Exception;

    /**
     * 订单信息查询
     *
     * @return
     * @throws Exception
     */
    public List<CommodityCustom> findPicture() throws Exception;

    /**
     * 按条件查询订单
     *
     * @return
     * @throws Exception
     */
    public List<CommodityCustom> findPictureByName(Commodity Commodity) throws Exception;

    /**
     * 查询商品信息
     *
     * @return
     * @throws Exception
     */
    public List<Order> SelectOrder(Order Order) throws Exception;

    /**
     * 按ID查询商品信息
     *
     * @return
     * @throws Exception
     */
    public Order SelectOrderById(int id) throws Exception;

    /**
     * 查询用户信息
     *
     * @param user
     * @return
     * @throws Exception
     */
    public List<User> SelectInformation(User user) throws Exception;

    /**
     * 添加商品信息
     *
     * @param order
     * @return
     * @throws Exception
     */
    public int InsertSelectOrder(Order order) throws Exception;


    /**
     * 添加商品信息
     *
     * @param order
     * @return
     */
    public int addOreder(Order order) throws Exception;

    /**
     * 按id查询修改信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Order findSelectOrderById(Integer id) throws Exception;

    /**
     * 修改商品信息
     *
     * @param order
     * @return
     * @throws Exception
     */
    public int OrderUpdate(Order order) throws Exception;


    /**
     * 多条件查询商品信息
     *
     * @param order
     * @return
     * @throws Exception
     */
    public List<Order> findQueryOrder(Order order) throws Exception;

    /**
     * 删除物品
     *
     * @param order
     * @return
     * @throws Exception
     */
    public int DeleteOrder(Order order) throws Exception;

    /**
     * 删除用户
     *
     * @param user
     * @return
     * @throws Exception
     */
    public int DropUser(User user) throws Exception;


    /**
     * 多条件查询用户信息
     *
     * @param user
     * @return
     * @throws Exception
     */
    public List<User> findUserCont(User user) throws Exception;

    /**
     * 按ID查询用户信息
     *
     * @param
     * @return
     * @throws Exception
     */
    public User findUserById(int i) throws Exception;


}
