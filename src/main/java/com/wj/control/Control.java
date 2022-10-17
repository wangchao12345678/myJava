package com.wj.control;

import com.wj.Interface.Mapper.CountMapper;
import com.wj.model.Count;
import com.wj.repository.CountRepository;
import com.wj.service.CountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;


import java.io.IOException;
import java.io.InputStream;

@Controller(value = "control")
public class Control {
    public static void main(String[] args) {
        
/*       Count count=CountService.getCountByName("小刚");
        System.out.println(count.toString());
        Count count1=new Count();
        count1.setCount("小刚",29,"北京","25678962");
        System.out.println(CountService.insertCount(count1));
        CountService.deleteCount("张三");
        count.setAddress("9999999");
        count.setPhone("88888888");
   CountService.updateCount(count);
        System.out.println( CountService.getManyCount("李四"));*/

        System.out.println( CountService.getCountByLike("五"));
        Count count=new Count();
        count.setName("李四");
//        System.out.println(CountService.returnMapByname(count));
        System.out.println(CountService.returnListCount(count));
    }
}
