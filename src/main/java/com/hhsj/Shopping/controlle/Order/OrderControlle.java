package com.hhsj.Shopping.controlle.Order;

import com.github.pagehelper.PageInfo;
import com.hhsj.Shopping.Util.PageUtil;
import com.hhsj.Shopping.pojo.Adderss.Address;
import com.hhsj.Shopping.pojo.Order.Order;
import com.hhsj.Shopping.pojo.Type.Type;
import com.hhsj.Shopping.service.Gwc.GwcService;
import com.hhsj.Shopping.service.Order.OrderService;
import com.hhsj.Shopping.service.Type.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by xtnloveyou on 2019/7/1.
 */
@Controller
public class OrderControlle {
    @Resource
    private OrderService orderService;

    @Resource
    private TypeService typeService;

    @Resource
    private GwcService gwcService;

    /**
     * 首页商品查询
     *
     * @param model
     * @param order
     * @return
     */
    @RequestMapping(value = "/findShangPing")
    public String findShangPing(Model model, Order order) throws Exception {
        List<Order> shangPing = orderService.findShangPing(order);
        model.addAttribute("shangpPing", shangPing);
        return "Business/product2";
    }

    @RequestMapping(value = "/findShangPing1")
    public String findShangPing1(Model model, Order order) throws Exception {
        List<Order> shangPing = orderService.findShangPing(order);
        model.addAttribute("shangpPing", shangPing);
        return "Multiplexing/product2";
    }


    /**
     * 首页商品推荐查询
     *
     * @param model
     * @param order
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findRecommend")
    public List<Order> findOrder(Model model, Order order) {
        List<Order> orders = orderService.findRecommend(order);
        return orders;
    }

    /**
     * 首页商品促销查询
     *
     * @param model
     * @param order
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findPromotion")
    public List<Order> findPromotion(Model model, Order order) {
        List<Order> orders = orderService.findPromotion(order);
        return orders;
    }

    /**
     * 首页所有商品模糊查询
     *
     * @param model
     * @param request
     * @param
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/findBeizhi")
    public String findBeizhi(Model model, HttpServletRequest request,
                             @RequestParam(defaultValue = "1") int pageNum,
                             @RequestParam(defaultValue = "8") int pageSize, String name) throws Exception {
        PageInfo<Order> orderList = orderService.findBeizhi(pageNum, pageSize, name);
        List orderList1 = orderList.getList();
        PageUtil pageUtil = new PageUtil();
        pageUtil.setTotalCount(Integer.parseInt(orderList.getTotal() + ""));
        pageUtil.setPageSize(pageSize);
        pageUtil.setPageNum(pageNum);
        String path = pageUtil.getPath(request);
        model.addAttribute("orderList1", orderList1);
        model.addAttribute("pageUtil", pageUtil);
        model.addAttribute("path", path);
        model.addAttribute("name", name);
        model.addAttribute("orderList", orderList);
        return "Business/product";
    }

    @RequestMapping(value = "/findBeizhi1")
    public String findBeizhi1(Model model, HttpServletRequest request,
                              @RequestParam(defaultValue = "1") int pageNum,
                              @RequestParam(defaultValue = "8") int pageSize, String name) throws Exception {
        PageInfo<Order> orderList = orderService.findBeizhi(pageNum, pageSize, name);
        List orderList1 = orderList.getList();
        PageUtil pageUtil = new PageUtil();
        pageUtil.setTotalCount(Integer.parseInt(orderList.getTotal() + ""));
        pageUtil.setPageSize(pageSize);
        pageUtil.setPageNum(pageNum);
        String path = pageUtil.getPath(request);
        model.addAttribute("orderList1", orderList1);
        model.addAttribute("pageUtil", pageUtil);
        model.addAttribute("path", path);
        model.addAttribute("name", name);
        model.addAttribute("orderList", orderList);
        return "Multiplexing/product";
    }


    /**
     * 查询促销中心最低价
     *
     * @param model
     * @param order
     * @return
     */
    @RequestMapping(value = "/findAgent")
    public String findAgent(Model model, Order order, HttpServletRequest request,
                            @RequestParam(defaultValue = "1") int pageNum,
                            @RequestParam(defaultValue = "8") int pageSize, String name) throws Exception {
        List<Order> agent = orderService.findAgent(order);
        PageInfo<Order> orderList = orderService.findBeizhi(pageNum, pageSize, name);
        List orderList1 = orderList.getList();
        PageUtil pageUtil = new PageUtil();
        pageUtil.setTotalCount(Integer.parseInt(orderList.getTotal() + ""));
        pageUtil.setPageSize(pageSize);
        pageUtil.setPageNum(pageNum);
        String path = pageUtil.getPath(request);
        model.addAttribute("orderList1", orderList1);
        model.addAttribute("pageUtil", pageUtil);
        model.addAttribute("path", path);
        model.addAttribute("name", name);
        model.addAttribute("orderList", orderList);
        model.addAttribute("orderAgent", agent);
        return "Business/product1";

    }

    /**
     * 未登录时，促销中心查询
     * @param model
     * @param order
     * @param request
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/findAgent1")
    public String findAgent1(Model model, Order order, HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize, String name) throws Exception {
        List<Order> agent = orderService.findAgent(order);
        PageInfo<Order> orderList = orderService.findBeizhi(pageNum, pageSize, name);
        List orderList1 = orderList.getList();
        PageUtil pageUtil = new PageUtil();
        pageUtil.setTotalCount(Integer.parseInt(orderList.getTotal() + ""));
        pageUtil.setPageSize(pageSize);
        pageUtil.setPageNum(pageNum);
        String path = pageUtil.getPath(request);
        model.addAttribute("orderList1", orderList1);
        model.addAttribute("pageUtil", pageUtil);
        model.addAttribute("path", path);
        model.addAttribute("name", name);
        model.addAttribute("orderList", orderList);
        model.addAttribute("orderAgent", agent);
        return "Multiplexing/product1";

    }


    /**
     * 按id查询商品信息
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/findById")
    public String findById(Model model, Integer id) {
        Order byId = orderService.findById(id);
        model.addAttribute("byId", byId);
        return "Business/proinfo";
    }

    /**
     * 默认首页按id查询商品信息
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/findById1")
    public String findById1(Model model, Integer id) {
        Order byId = orderService.findById(id);
        model.addAttribute("byId", byId);
        return "Multiplexing/proinfo1";
    }

    /**
     * 按Id查询确认订单信息,并修改购买数量
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/UpdatePrice")
    public String UpdatePrice(Model model, Integer id, Order order) {
        int orde1 = orderService.UpdatePrice(order);
        if (orde1 != 0) {
            Order findPrice = orderService.findPrice(id);
            model.addAttribute("findPrice", findPrice);
            return "Business/order";
        } else {
            return "Business/proinfo";
        }
    }

    /**
     * 按id查询商品订单
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/orderDetails")
    public String orderDetails(Model model, Integer id, String cid, Integer user_id) {
        Order orderDetails = orderService.orderDetails(id);
        Type type = typeService.findType(cid);
        Address address = orderService.findAddress2(user_id);
        model.addAttribute("address", address);
        Address addres = orderService.findAddress1(user_id);
        model.addAttribute("addres", addres);
        model.addAttribute("type", type);
        model.addAttribute("orderDetails", orderDetails);
        return "Business/order2";
    }




    /**
     * 查询单层杯子
     *
     * @param
     * @param
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findOrders")
    public List<Order> findOrders(Order order) {
        List<Order> orders = orderService.findOrders(order);
        return orders;
    }

    /**
     * 查询双层杯子
     *
     * @param
     * @param order
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findDeck")
    public List<Order> findDeck(Order order) {
        //b
        List<Order> orders = orderService.findDeck(order);
        return orders;
    }

    /**
     * 查询瓦楞杯子
     *
     * @param
     * @param order
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findFlutin")
    public List<Order> findFlutin(Order order) {
        //c
        List<Order> orders = orderService.findFlutin(order);
        return orders;

    }

    /**
     * 查询透明杯子
     *
     * @param model
     * @param order
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findLucency")
    public List<Order> findLucency(Model model, Order order) {
        //待修改为d
        List<Order> orders = orderService.findLucency(order);
        return orders;
    }

    /**
     * 查询冰淇淋杯子
     *
     * @param model
     * @param order
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findCream")
    public List<Order> findCream(Model model, Order order) {
        //待修改为e
        List<Order> orders = orderService.findCream(order);
        return orders;
    }

    /**
     * 查询蛋糕分类
     *
     * @param model
     * @param order
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findCake")
    public List<Order> findCake(Model model, Order order) {
        //待修改为f
        List<Order> orders = orderService.findCake(order);
        return orders;
    }


    /**
     * 查询沙拉分类
     *
     * @param model
     * @param order
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findSalad")
    public List<Order> findSalad(Model model, Order order) {
        //待修改为g
        List<Order> orders = orderService.findSalad(order);
        return orders;
    }

    /**
     * 查询西餐
     *
     * @param model
     * @param order
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findWestern")
    public List<Order> findWestern(Model model, Order order) {
        //待修改为h
        List<Order> orders = orderService.findWestern(order);
        return orders;
    }

    /**
     * 查询中餐
     *
     * @param model
     * @param order
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findChinese")
    public List<Order> findChinese(Model model, Order order) {
        //待修改为i
        List<Order> orders = orderService.findChinese(order);
        return orders;
    }

    /**
     * 查询外带打包
     *
     * @param model
     * @param order
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findBale")
    public List<Order> findBale(Model model, Order order) {
        //待修改为j
        List<Order> orders = orderService.findBale(order);
        return orders;
    }

    /**
     * 查询纸碟分类
     *
     * @param model
     * @param order
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findPaper")
    public List<Order> findPaper(Model model, Order order) {
        //待修改为k
        List<Order> orders = orderService.findPaper(order);
        return orders;
    }

    /**
     * 查询纸袋子分类
     *
     * @param model
     * @param order
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findPaperBag")
    public List<Order> findPaperBag(Model model, Order order, HttpSession session) {
        //待修改为l
        List<Order> orders = orderService.findPaperBag(order);
        return orders;
    }

    /**
     * 查询纸碗分类
     *
     * @param model
     * @param order
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findPaperBowl")
    public List<Order> findPaperBowl(Model model, Order order) {
        //待修改为m
        List<Order> orders = orderService.findPaperBowl(order);
        return orders;
    }

    /**
     * 查询食用袋子分类
     *
     * @param model
     * @param order
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findDoggieBag")
    public List<Order> findDoggieBag(Model model, Order order) {
        //待修改为n
        List<Order> orders = orderService.findDoggieBag(order);
        return orders;
    }

    /**
     * 食品外带打包分类
     *
     * @param model
     * @param order
     * @param order
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findFoodBale")
    public List<Order> findFoodBale(Model model, Order order) {
        //待修改为o
        List<Order> orders = orderService.findFoodBale(order);
        return orders;
    }

}
