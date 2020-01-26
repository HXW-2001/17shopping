package com.hhsj.Shopping.pojo.Order;

/**
 * Created by xtnloveyou on 2019/7/1.
 */
public class Order {
    private Integer id;//主键
    private Integer user_id;//用户外键
    private String xname;//下单人姓名
    private long sp_id;//商品编号
    private String cid;//分类id
    private String name;//商品名称
    private String city;//出发城市
    private String stype;//商品类型
    private String sml;//商品ml高
    private String bag;//只/袋
    private double vlp;//会员价
    private String stock;//库存是否有货
    private Integer number;//下单数量
    private double postage;//邮费
    private String url;//图片路径
    private String mail;//是否包邮
    private String total;//总金额
    private Double totals;
    private String postages;
    private String stocks;
    private String stypes;
    private String namey;//商品名称
    private String distribution;//配送公司
    private Integer bianhao;

    public long getSp_id() {
        return sp_id;
    }

    public void setSp_id(long sp_id) {
        this.sp_id = sp_id;
    }

    public Integer getBianhao() {
        return bianhao;
    }

    public void setBianhao(Integer bianhao) {
        this.bianhao = bianhao;
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    public String getNamey() {
        return namey;
    }

    public void setNamey(String namey) {
        this.namey = namey;
    }


    public Double getTotals() {
        return totals;
    }

    public void setTotals(Double totals) {
        this.totals = totals;
    }

    public String getPostages() {
        return postages;
    }

    public void setPostages(String postages) {
        this.postages = postages;
    }

    public String getStocks() {
        return stocks;
    }

    public void setStocks(String stocks) {
        this.stocks = stocks;
    }

    public String getStypes() {
        return stypes;
    }

    public void setStypes(String stypes) {
        this.stypes = stypes;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getXname() {
        return xname;
    }

    public void setXname(String xname) {
        this.xname = xname;
    }


    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getSml() {
        return sml;
    }

    public void setSml(String sml) {
        this.sml = sml;
    }

    public String getBag() {
        return bag;
    }

    public void setBag(String bag) {
        this.bag = bag;
    }


    public double getVlp() {
        return vlp;
    }

    public void setVlp(double vlp) {
        this.vlp = vlp;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public double getPostage() {
        return postage;
    }

    public void setPostage(double postage) {
        this.postage = postage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

}
