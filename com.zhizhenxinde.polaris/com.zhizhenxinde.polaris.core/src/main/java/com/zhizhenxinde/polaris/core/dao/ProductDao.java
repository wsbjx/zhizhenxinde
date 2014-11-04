package com.zhizhenxinde.polaris.core.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.zhizhenxinde.polaris.common.dao.HibernateTemplate;
import com.zhizhenxinde.polaris.core.vo.Product;

/**
 * 产品DAO
 * 
 * @author wang.sheng
 * 
 */
@Repository
public class ProductDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;

	public void add(Product product)
	{
		hibernateTemplate.save(product);
	}

	public void update(Product product)
	{
		this.hibernateTemplate.update(product);
	}

	public Product getProduct(String id)
	{
		return this.hibernateTemplate.queryForObject("from Product t where t.id=?", new Object[] { id }, Product.class);
	}

	public Product[] getProducts()
	{
		return this.hibernateTemplate.queryForArray("from Product t", null, Product.class);
	}

	public Product[] getProductsByCategory(String categoryId)
	{
		return this.hibernateTemplate.queryForArray("from Product t where t.categoryId=?", new Object[] { categoryId }, Product.class);
	}

	public void delete(String id)
	{
		hibernateTemplate.executeUpdate("delete from Product t where t.id=?", new Object[] { id });
	}

	public void deleteByCategory(String categoryId)
	{
		this.hibernateTemplate.executeUpdate("delete from Product t where t.categoryId=?", new Object[] { categoryId });
	}

}
