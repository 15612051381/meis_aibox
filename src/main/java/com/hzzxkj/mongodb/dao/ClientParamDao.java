package com.hzzxkj.mongodb.dao;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.hzzxkj.mongodb.entity.ClientCurrentParam;
import com.hzzxkj.mongodb.entity.ClientParam;
import com.hzzxkj.utils.DateUtils;

@Component
public class ClientParamDao implements BaseMongoDao<ClientParam> {
	@Resource
	private MongoTemplate mongoTemplate;

	public static final String clientParamCollectionNamePrefix = "clientparam";

	@Override
	public void removeDemo(Long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateDemo(ClientParam demoEntity) {
		Criteria criteria = Criteria.where("HospitalID").is(demoEntity.getHospitalId()).and("DeviceID")
				.in(demoEntity.getDeviceId());
		Query query = Query.query(criteria);
		mongoTemplate.remove(query, ClientParam.class);
		mongoTemplate.insert(demoEntity);
	}

	@Override
	public ClientParam findDemoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertDemo(ClientParam demoEntity) {
		String yyyyMM = DateUtils.formatDate(new Date(), "yyyyMM");
		mongoTemplate.insert(demoEntity, clientParamCollectionNamePrefix + "_" + yyyyMM);
	}

}
