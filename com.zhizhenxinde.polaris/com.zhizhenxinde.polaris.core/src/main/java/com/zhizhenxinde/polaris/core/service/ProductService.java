package com.zhizhenxinde.polaris.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhizhenxinde.polaris.core.dao.ProductDao;

/**
 * 产品服务
 * 
 * @author wang.sheng
 * 
 */
@Service
public class ProductService
{
	@Resource
	private ProductDao productDao;
}
