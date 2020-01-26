package com.hhsj.Shopping.controlle.Commodity;

import com.github.pagehelper.PageInfo;
import com.hhsj.Shopping.Util.PageUtil;
import com.hhsj.Shopping.pojo.Commodity.Commodity;
import com.hhsj.Shopping.pojo.Commodity.CommodityCustom;
import com.hhsj.Shopping.pojo.Gl.Gl;
import com.hhsj.Shopping.pojo.Gwc.Gwc;
import com.hhsj.Shopping.pojo.Gwc.GwcCustom;
import com.hhsj.Shopping.service.Commodity.CommodityService;
import com.hhsj.Shopping.service.Gwc.GwcService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by xtnloveyou on 2019/7/12.
 */
@Controller
public class CommodityControlle {

    @Resource
    private CommodityService commodityService;

    @Resource
    private GwcService gwcService;

    /**
     * 添加订单信息如果等于1跳转微信页面
     *
     * @param model
     * @param commodity
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addCommodity")
    public Object addCommodity(Model model, Commodity commodity, HttpSession session) {
        Date date = new Date();
        commodity.setSj("17商城");
        commodity.setDate(date);
        int i = commodityService.addCommodity(commodity);
        if (i == 1) {
            session.setAttribute("commodity", commodity);
            return i;
        } else {
            return i;
        }
    }

    /**
     * 跳转到结算页面
     *
     * @return
     */
    @RequestMapping(value = "/tiaoz")
    public String tiaoz() {
        return "Business/success";
    }

    /**
     * 订单商品查询
     *
     * @param model
     * @param user_id
     * @return
     */
    @RequestMapping(value = "/findCommodity")
    public String findCommodity(Model model, @RequestParam(defaultValue = "1") Integer pageNum,
                                @RequestParam(defaultValue = "5") Integer pageSize, Integer user_id) {
        PageInfo<CommodityCustom> commodity = commodityService.findCommodity(pageNum, pageSize, user_id);
        List commodityList = commodity.getList();
        PageUtil pageUtil = new PageUtil();
        pageUtil.setTotalCount(Integer.parseInt(commodity.getTotal() + ""));
        pageUtil.setPageSize(pageSize);
        pageUtil.setPageNum(pageNum);
        model.addAttribute("commodityList", commodityList);
        model.addAttribute("pageUtil", pageUtil);
        model.addAttribute("user_id", user_id);
        model.addAttribute("commodity", commodity);
        return "Vip/vipOrder";
    }


    /**
     * 查询订单详情
     *
     * @param model
     * @param did
     * @return
     */
    @RequestMapping(value = "/fidnDingDan")
    public String fidnDingDan(Model model, Integer did) {
        CommodityCustom commodityCustom = commodityService.fidnDingDan(did);
        model.addAttribute("commodityCustom", commodityCustom);
        return "Business/orderDetails";
    }

    /**
     * 订单商品查询
     *
     * @param model
     * @param user_id
     * @return
     */
    @RequestMapping(value = "/findCommodity1")
    public String findCommodity1(Model model, @RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "5") Integer pageSize, Integer user_id) {
        PageInfo<CommodityCustom> commodity = commodityService.findCommodity(pageNum, pageSize, user_id);
        List commodityList = commodity.getList();
        PageUtil pageUtil = new PageUtil();
        pageUtil.setTotalCount(Integer.parseInt(commodity.getTotal() + ""));
        pageUtil.setPageSize(pageSize);
        pageUtil.setPageNum(pageNum);
        model.addAttribute("commodityList", commodityList);
        model.addAttribute("pageUtil", pageUtil);
        model.addAttribute("user_id", user_id);
        model.addAttribute("commodity", commodity);
        return "Vip/vipOrder1";
    }

    /**
     * 查询订单详情
     *
     * @param model
     * @param did
     * @return
     */
    @RequestMapping(value = "/fidnDingDan1")
    public String fidnDingDan1(Model model, Integer did) {
        CommodityCustom commodityCustom = commodityService.fidnDingDan(did);
        model.addAttribute("commodityCustom", commodityCustom);
        return "Business/orderDetails1";
    }

    /**
     * 修改订单状态
     *
     * @param model
     * @param commodity
     * @return
     */
    @RequestMapping(value = "/UpdateStatus")
    public String UpdateStatus(Model model, Commodity commodity, Integer user_id, HttpSession session) {
        int id = gwcService.findId();
        Commodity commodity1 = new Commodity();
        commodity1.setStatus_id(1);
        commodity1.setDid(id);
        int i = commodityService.UpdateStatus(commodity1);
        if (i == 1) {
            GwcCustom gwcCustom = gwcService.findGwcCount(user_id);
            session.setAttribute("gwcCustom", gwcCustom);
            return "Business/success1";
        } else {
            return "Business/success";
        }
    }

    /**
     * 添加订单
     *
     * @param commodity
     * @return
     */
    @RequestMapping(value = "/addCategory2")
    public String addCategory2(Commodity commodity, Gwc gwc, Gl gl) {
        if (commodity.getPayment_id() == 1) {
            commodity.setDate(new Date());
            commodity.setSj("17商城");
            commodity.setNumber(1);
            int i = gwcService.addCategory(commodity);
            if (i != 0) {
                int id = gwcService.findId();
                gl.setOrder_id(id);
                int i2 = gwcService.addGl(gl);
                return "Business/success";
            } else {
                return "Business/GwcJies";
            }
        } else {
            commodity.setDate(new Date());
            commodity.setSj("17商城");
            commodity.setNumber(1);
            int i = gwcService.addCategory(commodity);
            if (i != 0) {
                int id = gwcService.findId();
                gl.setOrder_id(id);
                int i2 = gwcService.addGl(gl);
                return "Business/success2";
            } else {
                return "Business/GwcJies";
            }
        }
    }
}



