package com.hhsj.Shopping.service.User;


import com.hhsj.Shopping.dao.User.UserMapper;
import com.hhsj.Shopping.pojo.Adderss.Address;
import com.hhsj.Shopping.pojo.User.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xtnloveyou on 2019/6/26.
 */
@Service("userService")
public class UserService {
    @Resource
    private UserMapper userMapper;


    /**
     * 登录前查询用户名是否重复
     *
     * @param username
     * @return
     */
    public int SelectUser(String username) {
        int i = 0;
        try {
            i = userMapper.SelectUser(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 登陆
     *
     * @param user
     * @return
     */
    public User LoginUser(User user) {
        User user1 = null;
        try {
            user1 = userMapper.LoginUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user1;
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    public int InsertUser(User user) {
        int i = 0;
        try {
            i = userMapper.InsertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 按ID查询用户
     *
     * @param
     * @return
     */
    public User findUserByid(int id) {
        User user = null;
        try {
            user = userMapper.findUserByid(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 完善用戶信息
     *
     * @param
     * @return
     */
    public int UpdateUsers(User user) {
        int i = 0;
        try {
            i = userMapper.UpdateUsers(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 修改用戶表
     *
     * @param userCustom
     * @return
     */
    public int UpdateUser(User userCustom) {
        int i = 0;
        try {
            i = userMapper.UpdateUser(userCustom);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 修改用戶密碼
     *
     * @param userCustom
     * @return
     */
    public int UpdatePw(User userCustom) {
        int i = 0;
        try {
            i = userMapper.UpdatePw(userCustom);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 查询地址信息
     *
     * @param
     * @return
     */
    public List<Address> findAddressId(int id) {
        List<Address> address = null;
        try {
            address = userMapper.findAddressId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address;
    }


    /**
     * 添加地址信息
     *
     * @param
     * @return
     */
    public int AddUserAddress(Address address) {
        int user = 0;
        try {
            user = userMapper.AddUserAddress(address);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 删除地址信息
     *
     * @param address
     * @return
     */
    public int DeleteAddress(Address address) {
        int user = 0;
        try {
            user = userMapper.DeleteAddress(address);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


}
