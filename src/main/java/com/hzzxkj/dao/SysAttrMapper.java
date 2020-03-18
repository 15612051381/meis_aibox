package com.hzzxkj.dao;

import com.hzzxkj.models.SysAttr;
import com.hzzxkj.models.SysAttrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysAttrMapper {
    long countByExample(SysAttrExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysAttr record);

    int insertSelective(SysAttr record);

    List<SysAttr> selectByExampleWithRowbounds(SysAttrExample example, RowBounds rowBounds);

    List<SysAttr> selectByExample(SysAttrExample example);
    
    List<SysAttr> getAttrByDeviceId(SysAttr sysAttr);

    SysAttr selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysAttr record, @Param("example") SysAttrExample example);

    int updateByExample(@Param("record") SysAttr record, @Param("example") SysAttrExample example);

    int updateByPrimaryKeySelective(SysAttr record);

    int updateByPrimaryKey(SysAttr record);
}