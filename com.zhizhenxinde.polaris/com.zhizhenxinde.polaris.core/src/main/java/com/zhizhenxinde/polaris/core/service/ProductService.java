package com.zhizhenxinde.polaris.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhizhenxinde.polaris.core.dao.ProductDao;
import com.zhizhenxinde.polaris.core.vo.Product;

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

	public Product[] getProducts()
	{
		return productDao.getProducts();
	}

	public Product getProduct(String id)
	{
		return productDao.getProduct(id);
	}

	public void add(Product product)
	{
		productDao.add(product);
	}

	public void delete(String id)
	{
		productDao.delete(id);
	}

	public void update(Product product)
	{
		productDao.update(product);
	}

	public Product[] getProductsByCategory(String categoryId)
	{
		return productDao.getProductsByCategory(categoryId);
	}
}
