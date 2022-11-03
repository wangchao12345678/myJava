package com.example.web_product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        res.setContentType("application/json;charset=utf-8");//关键
        res.setHeader("Access-Control-Allow-Origin","*");// 允许跨域的主机地址
        res.setHeader("Access-Control-Allow-Headers","*");// 允许跨域的请求头
        String URI=req.getRequestURI();
        StringBuffer URL=req.getRequestURL();
        System.out.println(URI);
        System.out.println(URL.toString());
        String methName=URI.substring(URI.lastIndexOf("/")+1);
        System.out.println(methName);
        Method method=null;
        /**
         * 加入容错机制
         */
        Method[] methods=this.getClass().getDeclaredMethods();//获取所有方法
        Boolean flag=false;//是否存在该方法
        for (Method meth:methods){
            if (meth.getName().equals(methName)){
                flag=true;//含有方法
                break;
            }
        }
        if (!flag){//不含有方法
              methName="findAll";
        }
        try {
            method =this.getClass().getDeclaredMethod(methName,HttpServletRequest.class,HttpServletResponse.class);
            System.out.println(method.toString());
            method.invoke(this,req,res);
        } catch (NoSuchMethodException e) {
            System.out.println(e.getMessage());
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
