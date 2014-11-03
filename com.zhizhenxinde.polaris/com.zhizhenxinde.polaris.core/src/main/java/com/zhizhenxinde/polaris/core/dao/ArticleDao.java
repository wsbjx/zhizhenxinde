package com.zhizhenxinde.polaris.core.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.zhizhenxinde.polaris.common.dao.HibernateTemplate;
import com.zhizhenxinde.polaris.core.vo.Article;

/**
 * 文章DAO
 * 
 * @author wang.sheng
 * 
 */
@Repository
public class ArticleDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;

	public Article getArticle(String id)
	{
		return this.hibernateTemplate.queryForObject("from Article t where t.id=?", new Object[] { id }, Article.class);
	}

	public Article[] getArticles()
	{
		return this.hibernateTemplate.queryForArray("from Article t", null, Article.class);
	}

	public void add(Article vo)
	{
		this.hibernateTemplate.save(vo);
	}

	public void update(Article vo)
	{
		this.hibernateTemplate.update(vo);
	}

	public void delete(String id)
	{
		this.hibernateTemplate.executeUpdate("delete from Article t where t.id=?", new Object[] { id });
	}

}
