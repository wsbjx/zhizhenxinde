package com.zhizhenxinde.polaris.restful.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhizhenxinde.polaris.common.restful.SimpleResponse;
import com.zhizhenxinde.polaris.core.vo.Picture;
import com.zhizhenxinde.polaris.restful.service.PictureManageService;

/**
 * 图片服务对应的控制器
 * 
 * @author wang.sheng
 * 
 */
@Controller
@RequestMapping("/picture")
public class PictureController
{
	Log log = LogFactory.getLog(getClass());

	@Resource
	private PictureManageService pictureManageService;

	/**
	 * 获取所有的图片集合
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Picture[] getPictures()
	{
		return pictureManageService.getPictures();
	}

	/**
	 * 添加一张新图片
	 * 
	 * @param picture
	 * @param uploadFile
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public SimpleResponse addPicture(String remark, MultipartFile uploadFile)
	{
		SimpleResponse response = new SimpleResponse();
		try
		{
			pictureManageService.add(remark, uploadFile);
			response.setSuccess(true);
		}
		catch (Exception e)
		{
			log.error("addPicture failed!", e);
			response.setSuccess(false);
			response.setMessage("addPicture failed!");
		}
		return response;
	}

	/**
	 * 删除图片
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public SimpleResponse deletePicture(@PathVariable String id)
	{
		SimpleResponse response = new SimpleResponse();
		try
		{
			pictureManageService.delete(id);
			response.setSuccess(true);
		}
		catch (Exception e)
		{
			log.error("deletePicture failed!", e);
			response.setSuccess(false);
			response.setMessage("deletePicture failed!");
		}
		return response;
	}

	/**
	 * 通过Servlet加载指定图片
	 * 
	 * @param id
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public void loadImage(@PathVariable String id, HttpServletResponse response) throws IOException
	{
		pictureManageService.loadImage(id, response);
	}
}
