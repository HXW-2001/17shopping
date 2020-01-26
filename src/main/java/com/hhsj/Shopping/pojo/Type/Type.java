package com.hhsj.Shopping.pojo.Type;

/**
 * Created by xtnloveyou on 2019/7/12.
 */
public class Type {
    private String cid;//商品类型id
    private String typeName;//商品名称

    public String getId() {
        return cid;
    }

    public void setId(String id) {
        this.cid = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
