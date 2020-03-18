/**  

* <p>Title: BaseMongoDao.java</p>  

* <p>Description:北京惠泽智信科技有限公司 </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: www.hzzxkj.com/</p>  
* @author guoxinan  
* @date 2018年10月22日  
* @version 1.0  
*/
package com.hzzxkj.mongodb.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;

/**
 * @author guoxinan
 * @date 2018年10月22日 
 */
public interface  BaseMongoDao<T>  {

    void removeDemo(Long id);

    void updateDemo(T demoEntity);

    T findDemoById(Long id);

    void insertDemo(T demoEntity);
     
}
