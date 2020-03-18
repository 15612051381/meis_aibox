package com.hzzxkj.dao;

import com.hzzxkj.models.SysAttrGroup;

import java.util.List;

public interface SysAttrGroupMapper {
    int deleteByPrimaryKey(Integer agId);

    int insert(SysAttrGroup record);

    int insertSelective(SysAttrGroup record);

    SysAttrGroup selectByPrimaryKey(Integer agId);

    int updateByPrimaryKeySelective(SysAttrGroup record);

    int updateByPrimaryKey(SysAttrGroup record);

    List<SysAttrGroup> selectBySysAttrGroupWhithDeviceID(SysAttrGroup record);
}