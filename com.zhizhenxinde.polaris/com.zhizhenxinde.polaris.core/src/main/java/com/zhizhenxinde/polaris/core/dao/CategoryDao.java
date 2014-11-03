package com.zhizhenxinde.polaris.core.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.zhizhenxinde.polaris.common.dao.HibernateTemplate;
import com.zhizhenxinde.polaris.core.vo.Category;

/**
 * 产品类型DAO
 * 
 * @author wang.sheng
 * 
 */
@Repository
public class CategoryDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;

	public Category[] getCategorys()
	{
		return hibernateTemplate.queryForArray("from Category t", null, Category.class);
	}

	public Category[] getChildren(String parentId)
	{
		return hibernateTemplate.queryForArray("from Category t where t.parentId=?", new Object[] { parentId },
				Category.class);
	}

	public Category getRoot()
	{
		return hibernateTemplate.queryForObject("from Category t where t.parentId=?", new Object[] { "root" },
				Category.class);
	}

	public Category getCategory(String id)
	{
		return hibernateTemplate.queryForObject("from Category t where t.id=?", new Object[] { id }, Category.class);
	}

	public void add(Category vo)
	{
		this.hibernateTemplate.save(vo);
	}

	public void update(Category vo)
	{
		this.hibernateTemplate.update(vo);
	}

	public void delete(String id)
	{
		this.hibernateTemplate.executeUpdate("delete from Category t where t.id=?", new Object[] { id });
	}

}
