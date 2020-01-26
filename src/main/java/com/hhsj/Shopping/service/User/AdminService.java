package com.hhsj.Shopping.service.User;

import com.hhsj.Shopping.dao.User.AdminMapper;
import com.hhsj.Shopping.pojo.Commodity.Commodity;
import com.hhsj.Shopping.pojo.Commodity.CommodityCustom;
import com.hhsj.Shopping.pojo.Order.Order;
import com.hhsj.Shopping.pojo.User.Admin;
import com.hhsj.Shopping.pojo.User.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xtnloveyou on 2019/7/4.
 */
@Service("adminService")
public class AdminService {
    @Resource
    private AdminMapper adminMapper;

    /**
     * 登录
     *
     * @param admin
     * @return
     */
    public Admin adminLogin(Admin admin) {
        Admin admin1 = null;
        try {
            admin1 = adminMapper.adminLogin(admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin1;
    }

    /**
     * 订单查询
     *
     * @return
     */
    public List<CommodityCustom> findPicture() {
        List<CommodityCustom> picture = null;
        try {
            picture = adminMapper.findPicture();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return picture;
    }

    /**
     * 按条件查询商品订单
     *
     * @return
     */
    public List<CommodityCustom> findPictureByName(Commodity commodity) {
        List<CommodityCustom> pictureByName = null;
        try {
            pictureByName = adminMapper.findPictureByName(commodity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pictureByName;
    }

    /**
     * 查询商品信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/SelectOrder")
    public List<Order> SelectOrder(Order Order) {
        List<Order> list = null;
        try {
            list = adminMapper.SelectOrder(Order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 按ID查询商品信息
     *
     * @param id
     * @return
     */
    public Order SelectOrderById(int id) {
        Order order = null;
        try {
            order = adminMapper.SelectOrderById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    /**
     * 查询用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/SelectInformation")
    public List<User> SelectInformation(User user) {
        List<User> list = null;
        try {
            list = adminMapper.SelectInformation(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 添加商品信息
     *
     * @param order
     * @return
     */
    public int addOreder(Order order) {
        int i = 0;
        try {
            i = adminMapper.addOreder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 按id查询修改信息
     *
     * @param id
     * @return
     */
    public Order findSelectOrderById(Integer id) {
        Order selectOrderById = null;
        try {
            selectOrderById = adminMapper.findSelectOrderById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectOrderById;
    }

    /**
     * 修改商品信息
     *
     * @param order
     * @return
     */
    public int OrderUpdate(Order order) {
        int update = 0;
        try {
            update = adminMapper.OrderUpdate(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return update;
    }

    /**
     * 多条件查询物品信息
     *
     * @param order
     * @return
     */
    public List<Order> findQueryOrder(Order order) {
        List<Order> orders = null;
        try {
            orders = adminMapper.findQueryOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }


    /**
     * 删除一个商品
     *
     * @param order
     * @return
     */
    public int DeleteOrder(Order order) {
        int i = 0;
        try {
            i = adminMapper.DeleteOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 删除用户
     *
     * @param user
     * @return
     */
    public int DropUser(User user) {
        int i = 0;
        try {
            i = adminMapper.DropUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 多条件查询用户信息
     *
     * @param user
     * @return
     */
    public List<User> findUserCont(User user) {
        List<User> list = null;
        try {
            list = adminMapper.findUserCont(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 按ID查询用户信息
     *
     * @param id
     * @return
     */
    public User findUserById(int id) {
        User User = null;
        try {
            User = adminMapper.findUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return User;
    }


}
