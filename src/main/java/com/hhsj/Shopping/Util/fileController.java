package com.hhsj.Shopping.Util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by XiaoDu on 2019/4/12.
 */
public class fileController {
    private String fileName;
    private String XGLOGO;
    private String apk;
    private String bd;

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }
    public String getApk() {
        return apk;
    }

    public void setApk(String apk) {
        this.apk = apk;
    }

    public String getXGLOGO() {
        return XGLOGO;
    }

    public void setXGLOGO(String XGLOGO) {
        this.XGLOGO = XGLOGO;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void fileProvider(HttpSession session, @RequestParam(value = "picPath11", required = false) MultipartFile file) throws IOException {
        //设置上传的地址
        //File.separator自适应服务器文件夹的路径分隔符
        String path = "A:/项目/Shopping2/src/main/resources/static/images";
        File uploadPath = new File(path);
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }
        //先要确定用户没有上传文件
        if (!file.isEmpty()) {
            //获取源文件名=====》获取文件的类型
            String oldFileName = file.getOriginalFilename();//这个就是源文件名
            String prefix = FilenameUtils.getExtension(oldFileName);//这个就是文件类型
            if (prefix.equals("jpg") || prefix.equals("jpeg") || prefix.equals("png")) {
                //文件类型符合,接下来在判断一下文件的大小
                if (file.getSize() <= 500000) {//文件的大小符合要求
                    fileName = UUID.randomUUID().toString() + "." + prefix;
                    //创建上传的文件
                    File uploadFile = new File(path,fileName);
                    //执行上传操作
                    file.transferTo(uploadFile);
                }
            }
        }
    }

    public void fileProvider2(HttpSession session, @RequestParam(value = "picPath", required = false) MultipartFile file) throws IOException {
        //设置上传的地址
        //File.separator自适应服务器文件夹的路径分隔符
        String path = session.getServletContext().getRealPath("statics" + File.separator + "upload");
        System.out.println("上传的文件路径为：" + path);
        File uploadPath = new File(path);
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }
        //先要确定用户没有上传文件
        if (!file.isEmpty()) {
            //获取源文件名=====》获取文件的类型
            String oldFileName = file.getOriginalFilename();//这个就是源文件名
            String prefix = FilenameUtils.getExtension(oldFileName);//这个就是文件类型
            if (prefix.equals("jpg") || prefix.equals("jpeg") || prefix.equals("png") || prefix.equals("logo")) {
                //文件类型符合,接下来在判断一下文件的大小
                if (file.getSize() <= 500000) {//文件的大小符合要求
                    XGLOGO = UUID.randomUUID().toString() + "." + prefix;
                    //创建上传的文件
                    File uploadFile = new File(path, XGLOGO);
                    //执行上传操作
                    file.transferTo(uploadFile);
                }
            }
        }
    }


    public void fileProvider3(HttpSession session, @RequestParam(value = "attach", required = false) MultipartFile file) throws IOException {
        //设置上传的地址
        //File.separator自适应服务器文件夹的路径分隔符
        String path = session.getServletContext().getRealPath("statics" + File.separator + "uploadfiles");
        System.out.println("上传的文件路径为：" + path);
        File uploadPath = new File(path);
        bd=path;
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }
        //先要确定用户没有上传文件
        if (file.isEmpty()) {
            //获取源文件名=====》获取文件的类型
            String oldFileName = file.getOriginalFilename();//这个就是源文件名
            String prefix = FilenameUtils.getExtension(oldFileName);//这个就是文件类型
            if (prefix.equals("txt")) {
                //文件类型符合,接下来在判断一下文件的大小
                if (file.getSize() <= 500000) {//文件的大小符合要求
                    apk = UUID.randomUUID().toString() + "." + prefix;
                    //创建上传的文件
                    File uploadFile = new File(path, apk);
                    //执行上传操作
                    file.transferTo(uploadFile);
                }
            }
        }
    }
}
