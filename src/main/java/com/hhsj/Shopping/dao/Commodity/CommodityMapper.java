package com.hhsj.Shopping.dao.Commodity;

import com.hhsj.Shopping.pojo.Commodity.Commodity;
import com.hhsj.Shopping.pojo.Commodity.CommodityCustom;

import java.util.List;

/**
 * Created by xtnloveyou on 2019/7/12.
 */
public interface CommodityMapper {

    /**
     * 订单信息添加
     * @param commodity
     * @return
     * @throws Exception
     */
    public int addCommodity(Commodity commodity)throws Exception;

    /**
     * 查询订单信息
     * @param user_id
     * @return
     */
    public List<CommodityCustom> findCommodity(Integer user_id)throws Exception;

    /**
     * 安id查询订单详情
     * @param did
     * @return
     * @throws Exception
     */
    public CommodityCustom fidnDingDan(Integer did)throws Exception;

    /**
     * 修改支付状态
     * @param commodity
     * @return
     * @throws Exception
     */
    public int UpdateStatus(Commodity commodity)throws Exception;

    /**
     * 购物车添加订单
     * @return
     * @throws Exception
     */
    public int insert(Commodity commodity)throws Exception;

}
