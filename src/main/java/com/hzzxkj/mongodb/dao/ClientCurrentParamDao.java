package com.hzzxkj.mongodb.dao;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.hzzxkj.mongodb.entity.ClientCurrentParam;
import com.mongodb.client.result.DeleteResult;
@Component
public class ClientCurrentParamDao implements BaseMongoDao<ClientCurrentParam> {
	
	 @Resource
	private MongoTemplate mongoTemplate;

	@Override
	public void removeDemo(Long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateDemo(ClientCurrentParam demoEntity) {
		Criteria criteria = Criteria.where("HospitalID").is(demoEntity.getHospitalId()).and("DeviceID").is(demoEntity.getDeviceId()).and("EventID").is(demoEntity.getEventId());		
		Query query = Query.query(criteria);
	    mongoTemplate.remove(query, "clientcurrentparam");
		mongoTemplate.insert(demoEntity, "clientcurrentparam"); 
	}

	@Override
	public ClientCurrentParam findDemoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertDemo(ClientCurrentParam demoEntity) {
		mongoTemplate.insert(demoEntity, "clientcurrentparam");
		
	}
	 





}
