package com.zhizhenxinde.polaris.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhizhenxinde.polaris.core.dao.ArticleDao;

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
}
