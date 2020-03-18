package com.hzzxkj.dao;

import com.hzzxkj.models.MdDeviceStatus;

public interface MdDeviceStatusMapper {
    int deleteByPrimaryKey(Integer dsId);

    int insert(MdDeviceStatus record);

    int insertSelective(MdDeviceStatus record);

    MdDeviceStatus selectByPrimaryKey(Integer dsId);

    int updateByPrimaryKeySelective(MdDeviceStatus record);

    int updateByPrimaryKey(MdDeviceStatus record);
}