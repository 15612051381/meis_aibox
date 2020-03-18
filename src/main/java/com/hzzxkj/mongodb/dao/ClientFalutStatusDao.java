package com.hzzxkj.mongodb.dao;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.hzzxkj.mongodb.entity.ClientCurrentParam;
import com.hzzxkj.mongodb.entity.ClientFalutStatus;
@Component
public class ClientFalutStatusDao implements BaseMongoDao<ClientFalutStatus> {

	 @Resource
	private MongoTemplate mongoTemplate;


	@Override
	public void removeDemo(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDemo(ClientFalutStatus demoEntity) {
		Criteria criteria = Criteria.where("HospitalID").is(demoEntity.getHospitalId()).and("DeviceID").in(demoEntity.getDeviceId());
		Query query = Query.query(criteria);
		mongoTemplate.remove(query,"clientfalutstatus");
		mongoTemplate.insert(demoEntity,"clientfalutstatus"); 
	}

	@Override
	public ClientFalutStatus findDemoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertDemo(ClientFalutStatus demoEntity) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(demoEntity,"clientfalutstatus");
	}

}
