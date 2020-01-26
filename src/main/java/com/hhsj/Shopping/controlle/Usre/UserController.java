package com.hhsj.Shopping.controlle.Usre;

import com.hhsj.Shopping.pojo.Adderss.Address;
import com.hhsj.Shopping.pojo.Gwc.GwcCustom;
import com.hhsj.Shopping.pojo.Order.Order;
import com.hhsj.Shopping.pojo.User.User;
import com.hhsj.Shopping.service.Gwc.GwcService;
import com.hhsj.Shopping.service.Order.OrderService;
import com.hhsj.Shopping.service.User.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by xtnloveyou on 2019/6/26.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private OrderService orderService;
    @Resource
    private GwcService gwcService;


    /**
     * 登录前异步查询用户名是否重复
     */
    @ResponseBody
    @RequestMapping(value = "/SelectUser")
    public int SelectUser(String username, Model model) {
        int i = userService.SelectUser(username);
        return i;
    }

    /**
     * 登录：登录成功跳转到首页
     *
     * @param model
     * @param user
     * @param session
     * @return
     */
    @RequestMapping(value = "/login")
    public String findUser(Model model, User user, HttpSession session) {
        User user1 = userService.LoginUser(user);
        if (user1 != null) {
            GwcCustom gwcCustom = gwcService.findGwcCount(user1.getId());
            session.setAttribute("gwcCustom", gwcCustom);//购物车总价钱和总条数
            session.setAttribute("login", user1);
            return "forward:/main";
        }
        return "login";
    }

    /**
     * 商城首页：跳转
     *
     * @return
     */
    @RequestMapping(value = "/main")
    public String main(Model model, Order order, User user, HttpSession session) {
        order.setCid("k");
        List<Order> recommend = orderService.findRecommend(order);
        order.setCid("h");
        List<Order> tableware = orderService.findTableware(order);
        order.setCid("l");
        List<Order> paper1 = orderService.findPaper1(order);
        order.setCid("c");
        List<Order> order1 = orderService.findOrder(order);
        model.addAttribute("order", order1);//前台杯子显示
        model.addAttribute("recommend", recommend);//前台推荐产品显示
        model.addAttribute("tableware", tableware);//前台餐具显示
        model.addAttribute("paper1", paper1);//前台纸浆显示
        return "main";
    }


    /**
     * 注册：跳转到注册页面
     *
     * @return
     */
    @RequestMapping(value = "/reg")
    public String reg() {
        return "reg";
    }

    /**
     * 注册用户
     */
    @RequestMapping(value = "/Add")
    public java.lang.String InsetUser(User user, HttpSession session, Model model) {
        user.setCreated(new Date());
        user.setUpdated(new Date());
        int i = userService.InsertUser(user);
        if (i == 1) {
            return "login";
        } else {
            model.addAttribute("text","注册失败");
            return "reg";
        }

    }

    /**
     * 按ID查询用户信息(跳轉到完善頁面)
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/findUserByid")
    public String finduUserByid(int id, Model model) {
        User userByid = userService.findUserByid(id);
        model.addAttribute("findUserByid", userByid);
        return "Vip/vip";
    }

    /**
     * 按ID查询用户信息（跳轉到個人信息頁面）
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/findUserPerson")
    public String findUserPerson(int id, Model model) {
        User userByid = userService.findUserByid(id);
        model.addAttribute("UserPerson", userByid);
        return "Vip/vipMy";
    }

    /**
     * 完善個人信息
     *
     * @param
     * @param model
     * @return
     */
    @RequestMapping(value = "/InserUser")
    public String InserUser(User user, Model model) {
        int i = userService.UpdateUsers(user);
        if (i == 1) {
            model.addAttribute("test", "完善成功！");
        } else {
            model.addAttribute("test", "完善失败！");
        }
        return "Vip/vip";
    }

    /**
     * 修改用戶信息
     *
     * @param userCustom
     * @param model
     * @return
     */
    @RequestMapping(value = "/UpdateUsers")
    public String UpdateUsers(User userCustom, Model model) {
        int i = userService.UpdateUser(userCustom);
        if (i > 0) {
            return "forward:findUserPerson";

        } else {
            model.addAttribute("test", "修改失敗！");
        }
        return "Vip/vipMy";
    }

    /**
     * 修改用戶密碼
     *
     * @param userCustom
     * @param model
     * @return
     */
    @RequestMapping(value = "/UpdatePw")
    public String UpdatePw(User userCustom, Model model) {
        int i = userService.UpdatePw(userCustom);
        if (i > 0) {
            model.addAttribute("test", "修改成功！");
        } else {
            model.addAttribute("test", "修改失敗！");
        }
        return "Vip/vipPwd";
    }

    /**
     * 查询地址信息
     *
     * @param
     * @param model
     * @return
     */
    @RequestMapping(value = "/findAddress")
    public String findAddress(int id, Model model) {
        List<Address> address = userService.findAddressId(id);
        model.addAttribute("Address", address);
        return "Vip/vipAdress";
    }


    /**
     * 添加地址信息
     *
     * @param
     * @param model
     * @return
     */
    @RequestMapping(value = "/AddUserAddress")
    public String AddUserAddress(Address address, Model model) {
        Integer m = (int) Math.floor(Math.random() * 90) + 10;
        address.setDel_id(m);
        int i = userService.AddUserAddress(address);
        if (i > 0) {
            return "forward:findAddress";
        } else {
            model.addAttribute("test", "添加失敗！");
        }
        return "Vip/vipAdress";
    }

    /**
     * 删除地址信息
     *
     * @param address
     * @param model
     * @return
     */
    @RequestMapping(value = "/DeleteAddress")
    public String DeleteAddress(Address address, Model model, Integer id, Integer user_id) {
        int i = userService.DeleteAddress(address);
        if (i > 0) {
            List<Address> addres = userService.findAddressId(user_id);
            model.addAttribute("Address", addres);
            return "Vip/vipAdress";
        } else {
            model.addAttribute("test", "删除失敗！");
        }
        return "Vip/vipAdress";
    }
}
