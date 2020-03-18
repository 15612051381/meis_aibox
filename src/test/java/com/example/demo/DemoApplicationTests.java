package com.example.demo;

import com.hzzxkj.BootApplication;
import com.hzzxkj.dao.MdDeviceStatusMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootApplication.class)
@WebAppConfiguration
public class DemoApplicationTests {

	@Autowired
	private MdDeviceStatusMapper mdDeviceStatusMapper;

	@Test
	public void contextLoads() {
		System.out.println(mdDeviceStatusMapper.selectByPrimaryKey(1).toString());

	}

}
