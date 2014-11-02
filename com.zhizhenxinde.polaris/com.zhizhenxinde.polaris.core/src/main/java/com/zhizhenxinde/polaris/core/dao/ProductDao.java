package com.zhizhenxinde.polaris.core.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.zhizhenxinde.polaris.common.dao.HibernateTemplate;
import com.zhizhenxinde.polaris.core.vo.Product;

@Repository
public class ProductDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;

	public void add(Product product)
	{
		hibernateTemplate.save(product);
	}

	public void delete(String id)
	{
		hibernateTemplate.executeUpdate("delete from Product t where t.id=?", new Object[] { id });
	}
	
	

}
