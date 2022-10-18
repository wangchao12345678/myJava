package com.wjm.control;

import com.wjm.model.Count;
import com.wjm.model.CountList;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Control {
   public static void main(String[] args) {

      ApplicationContext applicationContext=new ClassPathXmlApplicationContext("BeanConfig/Bean.xml");//可在Bean.xml中设置为懒加载
      Count count=applicationContext.getBean("count2",Count.class);
      System.out.println(count.toString());

      CountList countList=applicationContext.getBean("countList",CountList.class);
      System.out.println(countList.toString());


   }
}
