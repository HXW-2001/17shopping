package com.hhsj.Shopping.service.Type;

import com.hhsj.Shopping.dao.Type.TypeMapper;
import com.hhsj.Shopping.pojo.Type.Type;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xtnloveyou on 2019/7/12.
 */
@Service("typeService")
public class TypeService {

    @Resource
    private TypeMapper typeMapper;

    /**
     * 查询商品类型
     * @param cid
     * @return
     */
    public Type findType(String cid){
        Type type = null;
        try {
            type = typeMapper.findType(cid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return type;
    }
}
