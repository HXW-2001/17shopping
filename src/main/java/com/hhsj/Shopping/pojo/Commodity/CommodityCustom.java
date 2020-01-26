package com.hhsj.Shopping.pojo.Commodity;

/**
 * Created by xtnloveyou on 2019/7/13.
 */
/*订单增强类
* */
public class CommodityCustom extends Commodity {
    private String receiver_name;
    private String status;
    private Long id;
    private String adderss;
    private String atatus;
    private String payment;
    private Integer tb_did;

    public Integer getTb_did() {
        return tb_did;
    }

    public void setTb_did(Integer tb_did) {
        this.tb_did = tb_did;
    }

    public String getAtatus() {
        return atatus;
    }

    public void setAtatus(String atatus) {
        this.atatus = atatus;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdderss() {
        return adderss;
    }

    public void setAdderss(String adderss) {
        this.adderss = adderss;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
