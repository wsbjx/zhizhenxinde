package com.zhizhenxinde.polaris.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhizhenxinde.polaris.core.dao.CategoryDao;
import com.zhizhenxinde.polaris.core.vo.Category;

/**
 * 产品类型服务
 * 
 * @author wang.sheng
 * 
 */
@Service
public class CategoryService
{
	@Resource
	private CategoryDao categoryDao;

	public Category getRoot()
	{
		return categoryDao.getRoot();
	}

	public Category[] getChildren(String parentId)
	{
		return categoryDao.getChildren(parentId);
	}

	public void add(Category vo)
	{
		categoryDao.add(vo);
	}

	public void update(Category vo)
	{
		categoryDao.update(vo);
	}

	public void delete(String id)
	{
		categoryDao.delete(id);
	}
}
