package com.example.web_product;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static javafx.beans.binding.Bindings.isNotEmpty;

@WebServlet(name = "product", value = "/product/*")
public class ProductServlet extends BaseServlet {
   private ServletInputStream servletInputStream;
    private String sql;
    private Product product;
    private List list;
    private int n;
    private String s;
    public void sendMessage(HttpServletResponse res,R r){
        String rsJson = JSON.toJSONString(r);
        try {
            res.getWriter().append(rsJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void findAll(HttpServletRequest req, HttpServletResponse res){//查询所有
        sql="SELECT * FROM  mysql1.`t-product`";
         list=DBUtils.executeR(sql,Product.class);
        System.out.println(list.size());
        sendMessage(res,R.ok().put("data",list));
    }
    public void add(HttpServletRequest req,HttpServletResponse rep){//添加
        try {
          servletInputStream = req.getInputStream();
        product=JSON.parseObject(servletInputStream,Product.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sql="insert into mysql1.`t-product`(product_no,product_name,product_type,Status) values("+product.getProduct_no()+
                ",'"+product.getProduct_name()+"','"+product.getProduct_type()+"',"+product.getStatus()+")";
                //insert into mysql1.`t-product`(product_no,product_name,product_type,Status) values(4,'产品','类型',2)
       n=DBUtils.executeCUD(sql);
       if (n!=0){
           sendMessage(rep,R.ok());
       }
       else {
           sendMessage(rep,R.err());
       }
    }
    public void delete(HttpServletRequest req,HttpServletResponse rep){//删除
        try {
            servletInputStream=req.getInputStream();
            product=JSON.parseObject(servletInputStream,Product.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //DELETE FROM mysql1.`t-product` WHERE id=5
        sql="DELETE FROM mysql1.`t-product` WHERE id="+product.getId();
        n=DBUtils.executeCUD(sql);
        if (n!=0){
            sendMessage(rep,R.ok());
        }
        else {
            sendMessage(rep,R.err());
        }
    }
    public void update(HttpServletRequest req,HttpServletResponse rep){
        try {
            servletInputStream=req.getInputStream();
            product=JSON.parseObject(servletInputStream,Product.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sql="update  mysql1.`t-product` set product_no="+product.getProduct_no()+",product_name='"+product.getProduct_name()+"',product_type='"+product.getProduct_type()+"',Status="+product.getStatus()+" where id="+product.getId();
        System.out.println(sql);
        //UPDATE `mysql1`.`t-product` SET `id` = 5, `product_no` = 5, `product_name` = '测试产品', `product_type` = '类型4', `Status` = 1 WHERE `id` = 4
        n=DBUtils.executeCUD(sql);
        if (n!=0){
            sendMessage(rep,R.ok());
        }
        else {
            sendMessage(rep,R.err());
        }
    }
    public void findById(HttpServletRequest req,HttpServletResponse rep){
        try {
            servletInputStream=req.getInputStream();
            product=JSON.parseObject(servletInputStream,Product.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sql="SELECT * FROM mysql1.`t-product` where id="+product.getId();
       list =DBUtils.executeR(sql,Product.class);
       if (list.size()!=0){
           sendMessage(rep,R.ok().put("data",list));
       }
       else {
           sendMessage(rep,R.err().put("message","没有查到"));
       }
    }
    public void findByName(HttpServletRequest req,HttpServletResponse rep){
        try {
            servletInputStream=req.getInputStream();
            product=JSON.parseObject(servletInputStream,Product.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sql="SELECT * FROM mysql1.`t-product` where product_name LIKE '%"+product.getProduct_name()+"%'";
        list=DBUtils.executeR(sql,Product.class);
        if (list.size()!=0){
            sendMessage(rep,R.ok().put("data",list));
        }
        else {
            sendMessage(rep,R.err());
        }

    }
    public void findByStatus(HttpServletRequest req,HttpServletResponse rep){
        try {
            servletInputStream=req.getInputStream();
           product= JSON.parseObject(servletInputStream,Product.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sql="SELECT * FROM mysql1.`t-product` where Status LIKE '%"+product.getStatus()+"%'";
       list= DBUtils.executeR(sql,Product.class);
       if (list.size()!=0){
           sendMessage(rep,R.ok().put("data",list));
       }
       else {
           sendMessage(rep,R.err());
       }
    }
    public void findByLike(HttpServletRequest req,HttpServletResponse rep){
        try {
            servletInputStream=req.getInputStream();
            product=JSON.parseObject(servletInputStream,Product.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //SELECT * from mysql1.`t-product` WHERE product_no=NULL AND product_name LIKE '%测%'  AND  Status=1
        sql="select * from mysql1.`t-product` WHERE 1=1 ";

        if (product.getProduct_no()!=0){
            sql+="and product_no="+product.getProduct_no();
            System.out.println(s);
        }
        if (product.getProduct_name()!=null){
            sql+=" and product_name like '%"+product.getProduct_name()+"%'";
        }
       if (product.getStatus()!=0){
           sql+=" and Status="+product.getStatus();
       }
        System.out.println(sql);
      list= DBUtils.executeR(sql,Product.class);
        System.out.println(list.size());
       sendMessage(rep,R.ok().put("data",list));
    }
}