package com.zhizhenxinde.polaris.core.service;

import java.io.Reader;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhizhenxinde.polaris.core.dao.ArticleDao;
import com.zhizhenxinde.polaris.core.vo.Article;

/**
 * 文章服务
 * 
 * @author wang.sheng
 * 
 */
@Service
public class ArticleService
{
	@Resource
	private ArticleDao articleDao;

	/**
	 * 添加一篇文章
	 * 
	 * @param article
	 * @param reader
	 */
	public void add(Article article, Reader reader)
	{
		articleDao.add(article);
		articleDao.setContent(article.getId(), reader);
	}

	/**
	 * 修改一篇文章
	 * 
	 * @param article
	 * @param reader
	 */
	public void update(Article article, Reader reader)
	{
		articleDao.update(article);
		articleDao.setContent(article.getId(), reader);
	}

	/**
	 * 删除一篇文章
	 * 
	 * @param id
	 */
	public void delete(String id)
	{
		articleDao.delete(id);
	}

	/**
	 * 根据指定ID获取文章
	 * 
	 * @param id
	 * @return
	 */
	public Article getArticle(String id)
	{
		return articleDao.getArticle(id);
	}

	/**
	 * 读取文章内容
	 * 
	 * @param id
	 * @return
	 */
	public Reader getArticleContent(String id)
	{
		return articleDao.getContent(id);
	}

	/**
	 * 获取文章列表
	 * 
	 * @return
	 */
	public Article[] getArticles()
	{
		return articleDao.getArticles();
	}

}
