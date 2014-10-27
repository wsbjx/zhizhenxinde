package com.zzxd.test.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController
{
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
