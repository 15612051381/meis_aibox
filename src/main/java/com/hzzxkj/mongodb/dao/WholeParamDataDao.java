package com.hzzxkj.mongodb.dao;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.hzzxkj.mongodb.entity.WholeParamData;

@Component
public class WholeParamDataDao implements BaseMongoDao<WholeParamData> {

	 @Resource
	private MongoTemplate mongoTemplate;



	@Override
	public void removeDemo(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDemo(WholeParamData demoEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WholeParamData findDemoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertDemo(WholeParamData demoEntity) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(demoEntity,"wholeparamdata");
	}

	
}
