package com.hhsj.Shopping.service.Gwc;

import com.hhsj.Shopping.dao.Gwc.GwcMapper;
import com.hhsj.Shopping.pojo.Commodity.Commodity;
import com.hhsj.Shopping.pojo.Gl.Gl;
import com.hhsj.Shopping.pojo.Gwc.Gwc;
import com.hhsj.Shopping.pojo.Gwc.GwcCustom;
import com.hhsj.Shopping.pojo.User.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xtnloveyou on 2019/7/11.
 */
@Service("gwcService")
@Transactional
public class GwcService {

    @Resource
    private GwcMapper gwcMapper;

    /**
     * 首页购物车商品信息查询
     * @param gwc
     * @return
     */
    public List<Gwc> findGwc(Gwc gwc){
        List<Gwc> orders = null;
        try {
            orders = gwcMapper.findGwc(gwc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    /**
     * 商品信息查询
     * @param user_id
     * @return
     */
    public Gwc findGwcSum(Integer user_id){
        Gwc gwcSum = null;
        try {
            gwcSum = gwcMapper.findGwcSum(user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gwcSum;
    }

    /**
     * 购物车清单查询
     * @param gwc
     * @return
     */
    public List<Gwc> findGwcQd(Gwc gwc){
        List<Gwc> gwcQd = null;
        try {
            gwcQd = gwcMapper.findGwcQd(gwc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gwcQd;
    }

    /**
     * 添加购物车收藏
     * @param gwc
     * @return
     */
    public int addGwc(Gwc gwc){
        int i = 0;
        try {
            i = gwcMapper.addGwc(gwc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 购物车删除
     * @param id
     * @return
     */
    public int GwcDelete(Integer id){
        int delete = 0;
        try {
            delete = gwcMapper.GwcDelete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return delete;
    }

    /**
     * 查询商品总价钱
     * @param user
     * @return
     */
    public GwcCustom findCount(User user){
        GwcCustom gwcCustom = null;
        try {
            gwcCustom = gwcMapper.findCount(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gwcCustom;
    }


    public GwcCustom findGwcCount(Integer id){
        GwcCustom gwcCustom = null;
        try {
            gwcCustom = gwcMapper.findGwcCount(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gwcCustom;
    }

    /**
     * 修改checkbox的值
     * @param gwc
     * @return
     */
    public int Updatecheckbox(Gwc gwc){
        int updatecheckbox = 0;
        try {
            updatecheckbox = gwcMapper.Updatecheckbox(gwc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updatecheckbox;
    }

    /**
     * 清单总条数
     * @param gwcCustom
     * @return
     */
    public GwcCustom count(Gwc gwc){
        GwcCustom count = null;
        try {
            count = gwcMapper.count(gwc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 关系添加
     * @param gl
     * @return
     */
    public int addGl(Gl gl){
        int i = 0;
        try {
            i = gwcMapper.addGl(gl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 添加订单
     * @param commodity
     * @return
     */
    public int addCategory(Commodity commodity){
        int i = 0;
        try {
            i = gwcMapper.addCategory(commodity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }


    public int findId(){
       return  gwcMapper.findId();
    }

    public int findOrderId(int id){
        return  gwcMapper.findOrderId(id);
    }

    /**
     * 删除购物车信息
     * @param gwc
     * @return
     */
    public int deleteGwc(Gwc gwc){
        int i = 0;
        try {
            i = gwcMapper.deleteGwc(gwc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 购物车清单查询
     * @param gwc
     * @return
     */
    public List<Gwc> findGwcQd1(Gwc gwc){
        List<Gwc> gwcQd1 = null;
        try {
            gwcQd1 = gwcMapper.findGwcQd1(gwc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gwcQd1;
    }

    /**
     * 查询总价
     * @param gwc
     * @return
     */
    public GwcCustom count1(Gwc gwc){
        GwcCustom gwcCustom = null;
        try {
            gwcCustom = gwcMapper.count1(gwc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gwcCustom;
    }


    /**
     * 删除购物车信息
     * @param gwc
     * @return
     */
    public int deleteGwc1(Gwc gwc){
        int i = 0;
        try {
            i = gwcMapper.deleteGwc1(gwc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 修改商品数量
     * @param gwc
     * @return
     */
    public int UpdateNumber(Gwc gwc){
        int i = 0;
        try {
            i = gwcMapper.UpdateNumber(gwc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 查询商品id
     * @param gwc
     * @return
     */
    public int findOrder_id(Gwc gwc){
        int order_id = gwcMapper.findOrder_id(gwc);
        return order_id;
    }

    /**
     * 查询商品数量
     * @param gwc
     * @return
     */
    public Gwc findNumber(Gwc gwc){
        Gwc number = gwcMapper.findNumber(gwc);
        return number;
    }
}
