package com.hhsj.Shopping.controlle.BackstageJump;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xtnloveyou on 2019/7/4.
 */
@Controller
public class BackstageControlle {

    /**
     * 默认首页跳转
     *
     * @return
     */
    @RequestMapping(value = "/home")
    public String home() {
        return "redirect:/SelectOrder";
    }

    /**
     * 商品添加跳转
     *
     * @return
     */
    @RequestMapping(value = "/picture")
    public String picture() {
        return "backstage/picture-add";
    }

    /**
     * 商品修改跳转
     *
     * @return
     */
    @RequestMapping(value = "/update")
    public String update() {
        return "backstage/picture-add1";
    }

    /**
     * 跳转到登录页面
     *
     * @return
     */

    @RequestMapping(value = "/Runter_Login")
    public String Runter_Login() {
        return "login";
    }
}


