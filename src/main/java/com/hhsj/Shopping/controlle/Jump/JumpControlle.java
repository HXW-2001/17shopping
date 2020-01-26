package com.hhsj.Shopping.controlle.Jump;

import com.hhsj.Shopping.pojo.Order.Order;
import com.hhsj.Shopping.pojo.User.User;
import com.hhsj.Shopping.service.Order.OrderService;
import com.hhsj.Shopping.service.User.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xtnloveyou on 2019/7/2.
 * 跳转类
 */
@Controller
public class JumpControlle {
    @Resource
    private OrderService orderService;
    @Resource
    private UserService userService;

    @RequestMapping(value = "/backstage")
    public String login() {
        return "backstageLogin";
    }

    /**
     * 结算页面: 跳转
     *
     * @return
     */
    @RequestMapping(value = "/order")
    public String order1() {
        return "Business/order2";
    }

    /**
     * 联系我们: 跳转
     *
     * @return
     */
    @RequestMapping(value = "/contact")
    public String contact() {
        return "Business/contact";
    }

    /**
     * 首页联系我们: 跳转
     *
     * @return
     */
    @RequestMapping(value = "/contact1")
    public String contact1() {
        return "Multiplexing/contact1";
    }


    /**
     * 促销页面：跳转
     *
     * @return
     */
    @RequestMapping(value = "/product")
    public String product() {
        return "Business/product";
    }

    /**
     * 首页促销页面：跳转
     *
     * @return
     */
    @RequestMapping(value = "/product1")
    public String product1() {
        return "Multiplexing/product1";
    }

    /**
     * 会员中心:跳转
     *
     * @return
     */
    @RequestMapping(value = "/vip")
    public String vlp(Model model, int id) {
        User userByid = userService.findUserByid(id);
        model.addAttribute("findUserByid", userByid);
        return "Vip/vip";
    }


    /**
     * 帮助中心: 跳转
     *
     * @return
     */
    @RequestMapping(value = "/help")
    public String help() {
        return "Business/help";
    }

    /**
     * 首页帮助中心: 跳转
     *
     * @return
     */
    @RequestMapping(value = "/help1")
    public String help1() {
        return "Multiplexing/help1";
    }

    /**
     * 首页商品首页：跳转
     *
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(Model model, Order order) {
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
        return "index";
    }

    /**
     * 商品信息：跳转
     *
     * @return
     */
    @RequestMapping(value = "/proinfo")
    public String proinfo() {
        return "Business/proinfo";
    }

    /**
     * 商品信息：跳转
     *
     * @return
     */
    @RequestMapping(value = "/proinfo1")
    public String proinfo1() {
        return "Multiplexing/proinfo1";
    }

    /**
     * 购买商品信息跳转
     *
     * @return
     */
    @RequestMapping(value = "/order2")
    public String order2() {
        return "Business/order1";
    }


    @RequestMapping(value = "/orderDetails1")
    public String orderDetails() {
        return "Business/orderDetails";
    }

    /**
     * 修改密碼：跳轉頁面
     *
     * @return
     */
    @RequestMapping(value = "/UserPassword")
    public String UserPassword() {
        return "Vip/vipPwd";
    }

    /**
     * 跳转企业简介
     *
     * @return
     */
    @RequestMapping(value = "/about")
    public String about() {
        return "Business/about";
    }

    /**
     * 跳转到网站使用条款
     *
     * @return
     */
    @RequestMapping(value = "/Exit")
    public String Exit() {
        return "Vip/vipExit";
    }

    /**
     * 跳转负责声明使用条款
     *
     * @return
     */
    @RequestMapping(value = "/Tuihuo")
    public String Tuihuo() {
        return "Vip/vipTuihuo";
    }

    /**
     * 未登录状态下跳转到企业简介
     *
     * @return
     */
    @RequestMapping(value = "/about1")
    public String about1() {
        return "Multiplexing/about1";
    }


    @RequestMapping(value = "/success")
    public String success(Integer payment_id){
        if(payment_id==1){
            return "Business/success";
        }else {
            return "Business/success2";
        }
    }

}
