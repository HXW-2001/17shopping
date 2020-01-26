package com.hhsj.Shopping.pojo.Type;

/**
 * Created by xtnloveyou on 2019/7/12.
 */
public class Stype {
    private Integer id;//主键
    private Integer status;//1:已支付2:未支付3:已完成
    private Integer payment;//1.银行卡2.支付宝3.微信

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }
}
