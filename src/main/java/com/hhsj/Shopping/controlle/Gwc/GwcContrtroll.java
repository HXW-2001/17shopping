package com.hhsj.Shopping.controlle.Gwc;

import com.hhsj.Shopping.pojo.Adderss.Address;
import com.hhsj.Shopping.pojo.Commodity.Commodity;
import com.hhsj.Shopping.pojo.Gl.Gl;
import com.hhsj.Shopping.pojo.Gwc.Gwc;
import com.hhsj.Shopping.pojo.Gwc.GwcCustom;
import com.hhsj.Shopping.pojo.Order.Order;
import com.hhsj.Shopping.pojo.User.User;
import com.hhsj.Shopping.service.Commodity.CommodityService;
import com.hhsj.Shopping.service.Gwc.GwcService;
import com.hhsj.Shopping.service.Order.OrderService;
import com.hhsj.Shopping.service.Type.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by xtnloveyou on 2019/7/11.
 */
@Controller
public class GwcContrtroll {
    @Resource
    private GwcService gwcService;

    @Resource
    private CommodityService commodityService;

    @Resource
    private TypeService typeService;

    @Resource
    private OrderService orderService;

    /**
     * 首页商品购物车信息查询
     *
     * @param gwc
     * @param model
     * @return
     */
    @RequestMapping(value = "/findGwc")
    public String findGwc(Model model, Gwc gwc, Integer user_id) {
        List<Gwc> orderList = gwcService.findGwc(gwc);
        Gwc gwcSum = gwcService.findGwcSum(user_id);
        GwcCustom gwcCustom = gwcService.findGwcCount(user_id);
        model.addAttribute("gwcCustom",gwcCustom);
        model.addAttribute("gwcSum", gwcSum);
        model.addAttribute("orderList", orderList);
        return "Business/Gwc";
    }



    /**
     * 异步修改地址信息
     *
     * @param model
     * @param user_id
     * @return
     */
    @RequestMapping(value = "/UpdateAddress")
    public String UpdateAddress(Model model, Address address,BindingResult bindingResult) {
        int address1 = orderService.UpdateAddress(address);
        if (address1 != 0) {
            return "forward:/findGwcQd";
        } else {
            return "Business/GwcJies";
        }
    }


    /**
     * 购物车清单查询
     *
     * @param model
     * @param gwc
     * @return
     */
    @RequestMapping(value = "/findGwcQd")
    public String findGwcQd(Model model, Gwc gwc, Integer user_id) {
        List<Gwc> gwcQd = gwcService.findGwcQd(gwc);
        Gwc gwcSum = gwcService.findGwcSum(user_id);
        Address address = orderService.findAddress2(user_id);
        GwcCustom count = gwcService.count(gwc);
        model.addAttribute("count", count);
        model.addAttribute("address", address);
        model.addAttribute("gwcSum", gwcSum);
        model.addAttribute("gwcQd", gwcQd);
        return "Business/GwcJies";
    }

    /**
     * 添加购物车收藏
     *
     * @param gwc
     * @return
     */
    @RequestMapping(value = "/addGwc")
    public String updateGwc(Model model, Gwc gwc, HttpSession session, @RequestParam(value = "userId")Integer userId) {
        int order_id = gwcService.findOrder_id(gwc);
        if(order_id==1){
            Gwc number = gwcService.findNumber(gwc);
            number.setOrder_id(gwc.getOrder_id());
            number.setNumber(number.getNumber()+1);
            int i = gwcService.UpdateNumber(number);
            if(i==1){
                GwcCustom gwcCustom = gwcService.findGwcCount(gwc.getUser_id());
                session.setAttribute("gwcCustom",gwcCustom);
                return "forward:/findById2";
            }else {
                return "forward:/findById2";
            }
      }else {
            int i = gwcService.addGwc(gwc);
            if (i == 1) {
                GwcCustom gwcCustom = gwcService.findGwcCount(gwc.getUser_id());
                session.setAttribute("gwcCustom",gwcCustom);
                return "forward:/findById2";
            }
            return "Business/proinfo";
      }
    }

    /**
     * 按id查询商品信息
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/findById2")
    public String findById2(Model model, Integer id) {
        Order byId = orderService.findById(id);
        model.addAttribute("byId", byId);
        return "Business/proinfo";
    }

    /**
     * 购物车删除
     *
     * @param model
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GwcDelete")
    public Object GwcDelete(Model model, Integer id) {
        int delete = gwcService.GwcDelete(id);
        if (delete == 1) {
            return "Business/Gwc";
        }
        return "Business/Gwc";
    }

    /**
     * 购物车查询总价
     *
     * @param model
     * @param user
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findCount1")
    public Object findCount1(Model model, User user, HttpSession session) {
        GwcCustom userCustom = gwcService.findCount(user);
        session.setAttribute("gwcCustom", userCustom);//购物车总价钱和总条数
        return userCustom;
    }

    /**
     * 修改Updatecheckbox的值
     *
     * @param gwc
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/Updatecheckbox")
    public Object Updatecheckbox(Gwc gwc) {
        int updatecheckbox = gwcService.Updatecheckbox(gwc);
        if (updatecheckbox != 0) {
            return updatecheckbox;
        } else {
            return updatecheckbox;
        }
    }


    /**
     * 添加订单
     *
     * @param commodity
     * @return
     */
    @RequestMapping(value = "/addCategory")
    public String addCategory(Commodity commodity, Gwc gwc,HttpSession session) {
        if(commodity.getPayment_id()==1){
            List<Gwc> gwcQd = gwcService.findGwcQd(gwc);
            commodity.setDate(new Date());
            commodity.setSj("17商城");
            commodity.setNumber(gwcQd.size());
            int i = gwcService.addCategory(commodity);
            if (i != 0) {
                int id = gwcService.findId();
                for (Gwc gwc1 : gwcQd) {
                    int orderId = gwcService.findOrderId(gwc1.getId());
                    Gl g = new Gl();
                    g.setOrder_id(id);
                    g.setTb_did(orderId);
                    gwcService.addGl(g);
                }
                int i1 = gwcService.deleteGwc(gwc);
                GwcCustom gwcCustom = gwcService.findGwcCount(gwc.getUser_id());
                session.setAttribute("gwcCustom",gwcCustom);
                return "Business/success";
            } else {
                return "Business/GwcJies";
            }
        }else {
            List<Gwc> gwcQd = gwcService.findGwcQd(gwc);
            commodity.setDate(new Date());
            commodity.setSj("17商城");
            commodity.setNumber(gwcQd.size());
            int i = gwcService.addCategory(commodity);
            if (i != 0) {
                int id = gwcService.findId();
                for (Gwc gwc1 : gwcQd) {
                    int orderId = gwcService.findOrderId(gwc1.getId());
                    Gl g = new Gl();
                    g.setOrder_id(id);
                    g.setTb_did(orderId);
                    gwcService.addGl(g);
                }
                int i1 = gwcService.deleteGwc(gwc);
                GwcCustom gwcCustom = gwcService.findGwcCount(gwc.getUser_id());
                session.setAttribute("gwcCustom",gwcCustom);
                return "Business/success2";
            } else {
                return "Business/GwcJies";
            }
        }

    }


    /**
     * 添加订单
     *
     * @param commodity
     * @return
     */
    @RequestMapping(value = "/addCategory1")
    public String addCategory1(Commodity commodity, Gwc gwc,HttpSession session) {
        if(commodity.getPayment_id()==1){
            List<Gwc> gwcQd = gwcService.findGwcQd1(gwc);
            commodity.setDate(new Date());
            commodity.setSj("17商城");
            commodity.setNumber(gwcQd.size());
            int i = gwcService.addCategory(commodity);
            if (i != 0) {
                int id = gwcService.findId();
                for (Gwc gwc1 : gwcQd) {
                    int orderId = gwcService.findOrderId(gwc1.getId());
                    Gl g = new Gl();
                    g.setOrder_id(id);
                    g.setTb_did(orderId);
                    gwcService.addGl(g);
                }
                int i1 = gwcService.deleteGwc1(gwc);
                GwcCustom gwcCustom = gwcService.findGwcCount(gwc.getUser_id());
                session.setAttribute("gwcCustom",gwcCustom);
                return "Business/success";
            } else {
                return "Business/GwcJies";
            }
        }else {
            List<Gwc> gwcQd = gwcService.findGwcQd1(gwc);
            commodity.setDate(new Date());
            commodity.setSj("17商城");
            commodity.setNumber(gwcQd.size());
            int i = gwcService.addCategory(commodity);
            if (i != 0) {
                int id = gwcService.findId();
                for (Gwc gwc1 : gwcQd) {
                    int orderId = gwcService.findOrderId(gwc1.getId());
                    Gl g = new Gl();
                    g.setOrder_id(id);
                    g.setTb_did(orderId);
                    gwcService.addGl(g);
                }
                int i1 = gwcService.deleteGwc1(gwc);
                GwcCustom gwcCustom = gwcService.findGwcCount(gwc.getUser_id());
                session.setAttribute("gwcCustom",gwcCustom);
                return "Business/success2";
            } else {
                return "Business/GwcJies";
            }
        }
    }


    /**
     * 查询清单
     *
     * @param model
     * @param gwc
     * @return
     */
    @RequestMapping(value = "/findGwcQd1")
    public String findGwcQd1(Model model, Gwc gwc, Integer user_id) {
        List<Gwc> gwcQd1 = gwcService.findGwcQd1(gwc);
        Address address = orderService.findAddress2(user_id);
        GwcCustom gwcCustom = gwcService.count1(gwc);
        model.addAttribute("gwcCustom", gwcCustom);
        model.addAttribute("address", address);
        model.addAttribute("gwcQd1", gwcQd1);
        return "Business/GwcJies1";
    }

}
