package com.hzzxkj.dao;

import com.hzzxkj.models.ProtocolAnalysisRuler;
import com.hzzxkj.models.ProtocolAnalysisRulerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ProtocolAnalysisRulerMapper {
   
	long countByExample(ProtocolAnalysisRulerExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ProtocolAnalysisRuler record);

	int insertSelective(ProtocolAnalysisRuler record);

	List<ProtocolAnalysisRuler> selectByExampleWithRowbounds(ProtocolAnalysisRulerExample example, RowBounds rowBounds);

	List<ProtocolAnalysisRuler> selectByExample(ProtocolAnalysisRulerExample example);

	ProtocolAnalysisRuler selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ProtocolAnalysisRuler record,
			@Param("example") ProtocolAnalysisRulerExample example);

	int updateByExample(@Param("record") ProtocolAnalysisRuler record,
			@Param("example") ProtocolAnalysisRulerExample example);

	int updateByPrimaryKeySelective(ProtocolAnalysisRuler record);

	int updateByPrimaryKey(ProtocolAnalysisRuler record);

    List<ProtocolAnalysisRuler> selectByTypeAndVersion(ProtocolAnalysisRuler record);
}