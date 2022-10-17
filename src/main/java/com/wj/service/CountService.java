package com.wj.service;

import com.wj.Interface.Mapper.CountMapper;
import com.wj.model.Count;
import com.wj.repository.CountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service(value ="countService" )
public class CountService {
    //获取mapper接口
    public static Count getCountByName(String name){
        CountMapper countMapper=CountRepository.getSqlSession().getMapper(CountMapper.class);
        Count count=countMapper.selectCount(name);
        count.setAddress("眉山");
        return count;
    }
   public static int insertCount(Count count){
       CountMapper countMapper=CountRepository.getSqlSession().getMapper(CountMapper.class);
      return  countMapper.insertCount(count);
   }
    public static int deleteCount(String name){
        CountMapper countMapper=CountRepository.getSqlSession().getMapper(CountMapper.class);
        return  countMapper.deleteCount(name);
    }
    public static boolean updateCount(Count count){
        CountMapper countMapper=CountRepository.getSqlSession().getMapper(CountMapper.class);
        return countMapper.updateCount(count);
    }
    public static List<Count> getManyCount(String name){
        CountMapper countMapper=CountRepository.getSqlSession().getMapper(CountMapper.class);
        return countMapper.selectManyCount(name);
    }
    public static List<Count> getCountByLike(String name){
        CountMapper countMapper=CountRepository.getSqlSession().getMapper(CountMapper.class);
        return countMapper.selectCountByLike(name);
    }
    public static Map returnMapByname(Count count){
        CountMapper countMapper=CountRepository.getSqlSession().getMapper(CountMapper.class);
        return countMapper.returnMapByname(count);
    }
   public static List<Map<String,Object>> returnListCount(Count count){
        CountMapper countMapper=CountRepository.getSqlSession().getMapper(CountMapper.class);
        return countMapper.returnListCount(count);
   }

}
