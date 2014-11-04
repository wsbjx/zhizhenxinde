package com.zhizhenxinde.polaris.restful.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhizhenxinde.polaris.core.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController
{
	@Resource
	private ProductService productService;
	
	@RequestMapping(value = "/enter", method = RequestMethod.GET)
	public Object test()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "1");
		map.put("name", "a");
		map.put("age", 25);
		return map;
	}
}
