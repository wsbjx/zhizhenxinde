package com.zhizhenxinde.polaris.restful.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.zhizhenxinde.polaris.core.service.ArticleService;

/**
 * 文章管理模块的控制器
 * 
 * @author wang.sheng
 * 
 */
@Controller
public class ArticleController
{
	@Resource
	private ArticleService articleService;
}
