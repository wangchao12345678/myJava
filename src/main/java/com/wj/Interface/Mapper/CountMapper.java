package com.wj.Interface.Mapper;

import com.wj.model.Count;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CountMapper {
    Count selectCount(String name);//����ΪString,����Count
    int insertCount(Count count);//�������
    int deleteCount(String name);//ɾ������
    boolean updateCount(Count count);//��������
    List<Count> selectManyCount(String name);//����String������List����
    List<Count> selectCountByLike(String name);//ģ����ѯ
    Map returnMapByname(Count count);//����count�����ص�������Map
    List<Map<String,Object>> returnListCount(Count count);//����count�����ض��map�������͵�����
}
