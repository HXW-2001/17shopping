package com.hhsj.Shopping.dao.Type;

import com.hhsj.Shopping.pojo.Type.Type;

/**
 * Created by xtnloveyou on 2019/7/12.
 */
public interface TypeMapper {
    /**
     * 安商品外键查询商品类型
     * @param cid
     * @return
     */
    public Type findType(String cid)throws  Exception;
}
