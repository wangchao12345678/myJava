package com.wj.Interface.Mapper;

import com.wj.model.Count;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CountMapper {
    Count selectCount(String name);//参数为String,返回Count
    int insertCount(Count count);//添加数据
    int deleteCount(String name);//删除数据
    boolean updateCount(Count count);//更新数据
    List<Count> selectManyCount(String name);//参数String，返回List集合
    List<Count> selectCountByLike(String name);//模糊查询
    Map returnMapByname(Count count);//参数count，返回单个集合Map
    List<Map<String,Object>> returnListCount(Count count);//参数count，返回多个map集合类型的数据
}
