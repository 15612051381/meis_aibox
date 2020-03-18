package com.hzzxkj.dao;

import com.hzzxkj.models.ClientInfo;
import com.hzzxkj.models.ClientInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ClientInfoMapper {
    long countByExample(ClientInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(ClientInfo record);

    int insertSelective(ClientInfo record);

    List<ClientInfo> selectByExampleWithRowbounds(ClientInfoExample example, RowBounds rowBounds);

    List<ClientInfo> selectByExample(ClientInfoExample example);

    ClientInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ClientInfo record, @Param("example") ClientInfoExample example);

    int updateByExample(@Param("record") ClientInfo record, @Param("example") ClientInfoExample example);

    int updateByPrimaryKeySelective(ClientInfo record);

    int updateByPrimaryKey(ClientInfo record);
    
    int updateByhospitalanddevice(ClientInfo record);
    
    int existsClinetInfo(ClientInfo record);
}