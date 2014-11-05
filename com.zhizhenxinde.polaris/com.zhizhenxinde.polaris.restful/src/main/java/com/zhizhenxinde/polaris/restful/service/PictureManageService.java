package com.zhizhenxinde.polaris.restful.service;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.zhizhenxinde.polaris.core.service.PictureService;
import com.zhizhenxinde.polaris.core.vo.Picture;

/**
 * 图片管理服务接口
 * 
 * @author wang.sheng
 * 
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PictureManageService
{
	Log log = LogFactory.getLog(getClass());

	@Resource
	private PictureService pictureService;

	public Picture[] getPictures()
	{
		return pictureService.getPictures();
	}

	public Picture add(String remark, MultipartFile uploadFile)
	{
		return pictureService.add(remark, uploadFile);
	}

	public void delete(String id)
	{
		pictureService.delete(id);
	}

	/**
	 * 加载指定id的图片资源
	 * 
	 * @param id
	 * @param response
	 * @throws IOException
	 */
	public void loadImage(@PathVariable String id, HttpServletResponse response) throws IOException
	{
		Picture picture = pictureService.getPicture(id);
		if (picture == null)
		{
			log.warn("Picture is not exist! id=" + id);
			response.sendError(404);// 资源不存在
			return;
		}
		String fileName = picture.getFileName().toLowerCase();
		if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg"))
		{
			response.setContentType("image/jpeg");
		}
		else if (fileName.endsWith(".gif"))
		{
			response.setContentType("image/gif");
		}
		else if (fileName.endsWith(".png"))
		{
			response.setContentType("image/png");
		}
		else if (fileName.endsWith(".bmp"))
		{
			response.setContentType("image/bmp");
		}
		else
		{
			response.setContentType("image/jpeg");
		}
		pictureService.read(id, response.getOutputStream());
	}
}
