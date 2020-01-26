package com.hhsj.Shopping.controlle.DomeHtml;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by HXW on 2019/8/27.
 */
@Controller
public class DomeHtmlControlle {
    @RequestMapping(value = "/DomeHtml")
    public String DomeHtml() {
        return "DomeHtml";
    }
}
