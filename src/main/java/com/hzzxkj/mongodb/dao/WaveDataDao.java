package com.hzzxkj.mongodb.dao;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.hzzxkj.mongodb.entity.WaveData;
@Component
public class WaveDataDao implements BaseMongoDao<WaveData> {

	 @Resource
		private MongoTemplate mongoTemplate;



	@Override
	public void removeDemo(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDemo(WaveData demoEntity) {
		
		
	}

	@Override
	public WaveData findDemoById(Long id) {
		// TODO Auto-generated method stub
		return null;  
	}

	@Override
	public void insertDemo(WaveData demoEntity) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(demoEntity,"wavedata");
	}
	

}
