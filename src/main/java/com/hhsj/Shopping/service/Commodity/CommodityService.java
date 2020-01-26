package com.hhsj.Shopping.service.Commodity;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hhsj.Shopping.dao.Commodity.CommodityMapper;
import com.hhsj.Shopping.dao.Type.TypeMapper;
import com.hhsj.Shopping.pojo.Commodity.Commodity;
import com.hhsj.Shopping.pojo.Commodity.CommodityCustom;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xtnloveyou on 2019/7/12.
 */
@Service("commodityService")
public class CommodityService {

    @Resource
    private CommodityMapper commodityMapper;

    @Resource
    private TypeMapper typeMapper;

    /**
     * 订单信息添加
     * @param commodity
     * @return
     */
    public int addCommodity(Commodity commodity){
        int i= 0;
        try {
            i = commodityMapper.addCommodity(commodity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 查询商品信息
     * @param user_id
     * @return
     */
    public PageInfo<CommodityCustom> findCommodity(Integer pageNum,Integer pageSize,Integer user_id){
        PageHelper.startPage(pageNum,pageSize);
        List<CommodityCustom> customList = null;
        try {
            customList = commodityMapper.findCommodity(user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageInfo<CommodityCustom> pageInfo = new PageInfo<>(customList);
        return pageInfo;
    }

    /**
     * 查询订单详情
     * @param did
     * @return
     */
        public CommodityCustom fidnDingDan(Integer did){
        CommodityCustom commodityCustom = null;
        try {
            commodityCustom = commodityMapper.fidnDingDan(did);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commodityCustom;
    }

    /**
     * 修改订单状态
     * @param commodity
     * @return
     */
    public int UpdateStatus(Commodity commodity){
        int i = 0;
        try {
            i = commodityMapper.UpdateStatus(commodity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 购物车订单添加
     * @param gwc
     * @return
     */
    public int insert(Commodity commodity){
        int insert = 0;
        try {
            insert = commodityMapper.insert(commodity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return insert;
    }
}
