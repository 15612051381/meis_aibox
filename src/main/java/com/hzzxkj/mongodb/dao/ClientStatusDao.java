/**  

* <p>Title: ClientStatusDao.java</p>  

* <p>Description:北京惠泽智信科技有限公司 </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: www.hzzxkj.com/</p>  
* @author guoxinan  
* @date 2018年10月22日  
* @version 1.0  
*/  
package com.hzzxkj.mongodb.dao;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.hzzxkj.mongodb.entity.ClientParam;
import com.hzzxkj.mongodb.entity.ClientStatus;

/**
 * @author    guoxinan
 * @date      2018年10月22日 
 */
@Component
public class ClientStatusDao implements BaseMongoDao<ClientStatus> {

	 @Resource
	private MongoTemplate mongoTemplate;


	@Override
	public void removeDemo(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDemo(ClientStatus demoEntity) {
		Criteria criteria = Criteria.where("HospitalID").is(demoEntity.getHospitalId()).and("DeviceID").in(demoEntity.getDeviceId());
		Query query = Query.query(criteria);
		mongoTemplate.remove(query,"clientstatus");
		mongoTemplate.insert(demoEntity,"clientstatus");
	}

	@Override
	public ClientStatus findDemoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertDemo(ClientStatus demoEntity) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(demoEntity,"clientstatus");
	}

}
