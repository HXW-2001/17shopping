package com.hhsj.Shopping.controlle.Usre;

import com.hhsj.Shopping.Util.fileController;
import com.hhsj.Shopping.pojo.Commodity.Commodity;
import com.hhsj.Shopping.pojo.Commodity.CommodityCustom;
import com.hhsj.Shopping.pojo.Order.Order;
import com.hhsj.Shopping.pojo.User.Admin;
import com.hhsj.Shopping.pojo.User.User;
import com.hhsj.Shopping.service.Order.OrderService;
import com.hhsj.Shopping.service.User.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by xtnloveyou on 2019/7/4.
 */
@Controller
public class AdminController {

    @Resource
    private AdminService adminService;

    @Resource
    private OrderService orderService;

    /**
     * 系统管理员登录
     *
     * @param model
     * @param admin
     * @return
     */
    @RequestMapping("/adminLogin")
    public String adminLogin(Model model, Admin admin, HttpSession session) {
        Admin admin1 = adminService.adminLogin(admin);
        if (admin1 != null) {
            session.setAttribute("admin1", admin1);
            return "backstage";
        } else {
            return "backstageLogin";
        }
    }

    /**
     * 订单查询
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/findAmounts")
    public String findPicture(Model model) {
        List<CommodityCustom> picture = adminService.findPicture();
        model.addAttribute("picture", picture);
        return "backstage/Amounts";
    }

    /**
     * 按条件查询商品订单信息+数据回显
     *
     * @param model
     * @param commodity
     * @return
     */
    @RequestMapping(value = "/findPictureByName")
    public String findPictureByName(Model model, Commodity commodity,Order order,
                                    @RequestParam(value = "name")String name,
                                    @RequestParam(value = "distribution")String distribution) {
        List<CommodityCustom> pictureByName = adminService.findPictureByName(commodity);
        model.addAttribute("picture", pictureByName);
        model.addAttribute("name",name);
        model.addAttribute("distribution",distribution);
        return "backstage/Amounts";
    }

    /**
     * 查询商品信息
     *
     * @param
     * @param model
     * @return
     */
    @RequestMapping(value = "/SelectOrder")
    public String SelectAdmin(Order order, Model model) {
        List<Order> list = adminService.SelectOrder(order);
        model.addAttribute("AdminList", list);
        return "backstage/Products_List";
    }

    /**
     * 按ID查询商品信息
     *
     * @param id
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/SelectOrderById")
    public String SelectOrderById(int id, Model model) {
        Order order = adminService.SelectOrderById(id);
        model.addAttribute("order", order);
        return "backstage/member-show";
    }

    /**
     * 查询用户信息
     *
     * @param
     * @param model
     * @return
     */
    @RequestMapping(value = "/SelectInformation")
    public String SelectInformation(User user, Model model) {
        List<User> list = adminService.SelectInformation(user);
        model.addAttribute("UserList", list);
        return "backstage/user_list";
    }


    /**
     * 添加上传图片
     *
     * @param
     * @return
     */
    @PostMapping("/upload")
    public Object upload(HttpSession session, Model model, Order order, @RequestParam(value = "attach", required = false) MultipartFile file) throws IOException {
        fileController fileController = new fileController();
        fileController.fileProvider(session, file);
        order.setUrl("/images/" + fileController.getFileName());
        double num = 0;
        for (int i = 0; i < 6; i++) {
            num = (Math.random() * 9 + 1) * 100000;
        }
        order.setSp_id((long) num);
        order.setUser_id(1);
        order.setXname("admin");
        int i = adminService.addOreder(order);
        if (i == 1) {
            List<Order> list = adminService.SelectOrder(order);
            model.addAttribute("AdminList", list);
            return "backstage/products_List.html";
        } else {
            return "backstage/picture-add";

        }
    }

    /**
     * 按id查询修改信息
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/findSelectOrderById")
    public String findSelectOrderById(Model model, Integer id) {
        Order selectOrderById = adminService.findSelectOrderById(id);
        model.addAttribute("selectOrderById", selectOrderById);
        return "backstage/picture-add1";
    }

    /**
     * 修改商品信息
     *
     * @param model
     * @param order
     * @return
     */
    @RequestMapping(value = "/OrderUpdate")
    public Object OrderUpdate(HttpSession session, Model model, Order order, @RequestParam(value = "attach", required = false) MultipartFile file) throws IOException {
        fileController fileController = new fileController();
        fileController.fileProvider(session, file);
        order.setUrl("/images/" + fileController.getFileName());
        int update = adminService.OrderUpdate(order);
        if (update != 0) {
            return "forward:/SelectOrder";
        } else {
            return "backstage/picture-add1";
        }
    }

    /**
     * 多条件查询物品信息+数据回显
     *
     * @param order
     * @param model
     * @return
     */
    @RequestMapping(value = "/findQueryOrder")
    public String findQueryOrder(Order order, Model model) {
        List<Order> queryOrder = adminService.findQueryOrder(order);
        model.addAttribute("AdminList", queryOrder);
        model.addAttribute("order", order);
        return "backstage/Products_List";
    }


    /**
     * 删除商品
     *
     * @param order
     * @param model
     * @return
     */
//    @ResponseBody
    @RequestMapping(value = "/DeleteOrder")
    public String DeleteOrder(Order order, Model model) {
        int i = adminService.DeleteOrder(order);
        if (i == 1) {
            List<Order> list = adminService.SelectOrder(order);
            model.addAttribute("AdminList", list);
        }
        return "forward:/SelectOrder";
    }

    /**
     * 删除用户
     *
     * @param user
     * @param model
     * @return
     */
//    @ResponseBody
    @RequestMapping(value = "/DropUser")
    public String DropUser(User user, Model model) {
        int i = adminService.DropUser(user);
        if (i == 1) {
            return "forward:/SelectInformation";
        }
        return "forward:/SelectInformation";
    }

    /**
     * 多条件查询用户信息+回显
     *
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "/findUserCont")
    public String findUserCont(User user, Model model) {
        List<User> list = adminService.findUserCont(user);
        model.addAttribute("UserList", list);
        model.addAttribute("user", user);
        return "backstage/user_list";
    }


    /**
     * 按ID查询用户信息
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/findUserById")
    public String findUserById(int id, Model model) {
        User userById = adminService.findUserById(id);
        model.addAttribute("ListUser", userById);
        return "backstage/member-show";
    }


}
