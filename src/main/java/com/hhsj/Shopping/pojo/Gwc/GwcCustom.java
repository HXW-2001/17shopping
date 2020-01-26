package com.hhsj.Shopping.pojo.Gwc;

/**
 * Created by xtnloveyou on 2019/7/14.
 */
public class GwcCustom extends Gwc {
    private Integer count;//总条数
    private double totals;//总价钱
    private double zhongjia;

    public double getZhongjia() {
        return zhongjia;
    }

    public void setZhongjia(double zhongjia) {
        this.zhongjia = zhongjia;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public double getTotals() {
        return totals;
    }

    public void setTotals(double totals) {
        this.totals = totals;
    }
}
