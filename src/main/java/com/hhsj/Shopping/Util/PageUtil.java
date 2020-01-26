package com.hhsj.Shopping.Util;

import com.github.pagehelper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by xtnloveyou on 2019/7/7.
 */
public class PageUtil <T>{
    private int pageNum;//页码
    private int pageSize;//页面容量
    private int totalPageCount;//总页数
    private int totalCount;//总资源数
    private List<T> data;//分页查询的结果
    private int pageIndex;//pageIndex = (pageNum-1)*pageSize

    public int getPageIndex() {
        pageIndex = (pageNum-1)*pageSize;
        return pageIndex;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        if (pageNum < 1) {
            pageNum = 1;
        } else if (pageNum > getTotalPageCount()) {
            pageNum = getTotalPageCount();
        }
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPageCount() {
        totalPageCount = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        return totalPageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getPath(HttpServletRequest request){
        //获取请求的地址
        String requestURI = request.getRequestURI();
        //获取请求的参数
        String queryString = request.getQueryString();
        //设置返回的路径
        String path ;
        //当请求是无条件的请求时
        if(StringUtil.isEmpty(queryString)){
            path = requestURI+"?pageNum";
        }else{
            //判断请求中是否包含分页参数
            boolean contains = queryString.contains("pageNum");
            String data;
            if(contains){
                //截取分页条件页码之前的参数
                data = queryString.substring(0,queryString.lastIndexOf("="));
            }else{
                //拼接分页的页码
                data = queryString+"&pageNum";
            }
            //拼接分页超链接的地址
            path = requestURI + "?"+data;
        }
        return path;
    }
}
