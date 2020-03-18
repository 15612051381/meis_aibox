package com.hzzxkj.mongodb.dao;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.hzzxkj.mongodb.entity.ClientOnLine;
import com.hzzxkj.mongodb.entity.ClientParam;
@Component
public class ClientOnLineDao implements BaseMongoDao<ClientOnLine> {
	 @Resource
		private MongoTemplate mongoTemplate;


	@Override
	public void removeDemo(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDemo(ClientOnLine demoEntity) { 
		Criteria criteria = Criteria.where("HospitalID").is(demoEntity.getHospitalId()).and("DeviceID").in(demoEntity.getDeviceId());
		Query query = Query.query(criteria);
		mongoTemplate.remove(query,"clientonline");
		mongoTemplate.insert(demoEntity,"clientonline");
	}

	@Override
	public ClientOnLine findDemoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertDemo(ClientOnLine demoEntity) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(demoEntity,"clientonline");
	}
	
	

}
