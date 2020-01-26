package com.hhsj.Shopping.dao.User;

import com.hhsj.Shopping.pojo.Adderss.Address;
import com.hhsj.Shopping.pojo.User.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xtnloveyou on 2019/6/26.
 */
public interface UserMapper {

    /**
     * 异步查询是否存在用户名
     *
     * @param
     * @return
     * @throws Exception
     */

    public int SelectUser(@Param(value = "username") String name) throws Exception;

    /*登录
    * */
    public User LoginUser(User user) throws Exception;

    /*
  注册
  * */
    public int InsertUser(User user) throws Exception;

    /*
     * 按查询ID用户
     */
    public User findUserByid(int id) throws Exception;

    /**
     * 完善個人信息
     *
     * @return
     * @throws Exception
     */
    public int UpdateUsers(User user) throws Exception;

    /**
     * 雙表修改（修改User表）
     *
     * @param
     * @return
     * @throws Exception
     */
    public int UpdateUser(User user) throws Exception;

    /**
     * 修改用戶密碼
     *
     * @param usercustom
     * @return
     * @throws Exception
     */
    public int UpdatePw(User usercustom) throws Exception;

    /**
     * 按ID查询收货地址
     *
     * @return
     * @throws Exception
     */
    public List<Address> findAddressId(int id) throws Exception;

    /**
     * 添加收货地址信息
     *
     * @param
     * @return
     */
    public int AddUserAddress(Address address);

    /**
     * 删除地址信息
     *
     * @param
     * @return
     */
    public int DeleteAddress(Address address);




}
