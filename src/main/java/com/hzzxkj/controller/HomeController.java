package com.hzzxkj.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpHost;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	private static int y = 0;

	@GetMapping("/index")
	@ResponseBody
	String index(@RequestHeader HttpHeaders header) throws IOException {

//		String x = String.valueOf(httpSession.getAttribute("A"));
//		httpSession.setAttribute("A", y++);
//
//		System.out.print(x);
//
//		RestClient client = RestClient.builder(new HttpHost("localhost", 8080, "http")).build();
//		Response response = client.performRequest("Get", "test/show");
//		// BufferedReader reader = new BufferedReader(new
//		// InputStreamReader(response.getEntity().getContent()));
//		String str = EntityUtils.toString(response.getEntity());
		return "Hello World 8888---";
	}
}
