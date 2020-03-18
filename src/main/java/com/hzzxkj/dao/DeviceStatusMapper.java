package com.hzzxkj.dao;

import com.hzzxkj.models.DeviceStatus;
import com.hzzxkj.models.DeviceStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DeviceStatusMapper {
    long countByExample(DeviceStatusExample example);

    int deleteByPrimaryKey(String id);

    int insert(DeviceStatus record);

    int insertSelective(DeviceStatus record);

    List<DeviceStatus> selectByExampleWithRowbounds(DeviceStatusExample example, RowBounds rowBounds);

    List<DeviceStatus> selectByExample(DeviceStatusExample example);

    DeviceStatus selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DeviceStatus record, @Param("example") DeviceStatusExample example);

    int updateByExample(@Param("record") DeviceStatus record, @Param("example") DeviceStatusExample example);

    int updateByPrimaryKeySelective(DeviceStatus record);

    int updateByPrimaryKey(DeviceStatus record);
    
    DeviceStatus selectBydeviceID(String id);
}