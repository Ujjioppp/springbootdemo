package com.sb.sbdemo.dao;

import com.sb.sbdemo.model.FfaDemand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FfaDemandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FfaDemand record);

    int insertSelective(FfaDemand record);

    FfaDemand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FfaDemand record);

    int updateByPrimaryKey(FfaDemand record);

    List<FfaDemand> queryList();
}