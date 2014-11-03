package com.zhizhenxinde.polaris.core.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zhizhenxinde.polaris.core.dao.PictureDao;
import com.zhizhenxinde.polaris.core.vo.Picture;

/**
 * 图片服务
 * 
 * @author wang.sheng
 * 
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PictureService
{
	Log log = LogFactory.getLog(getClass());

	@Resource
	private PictureDao pictureDao;

	/**
	 * 获取全部图片
	 * 
	 * @return
	 */
	public Picture[] getPictures()
	{
		return pictureDao.getPictures();
	}

	/**
	 * 获取产品相关图片
	 * 
	 * @param productId
	 * @return
	 */
	public Picture[] getPicturesByProduct(String productId)
	{
		return pictureDao.getPicturesByProduct(productId);
	}

	/**
	 * 删除图片
	 * 
	 * @param id
	 */
	public void delete(String id)
	{
		pictureDao.delete(id);
	}

	/**
	 * 删除产品对应的所有图片
	 * 
	 * @param productId
	 */
	public void deleteByProduct(String productId)
	{
		pictureDao.deleteByProduct(productId);
	}

	/**
	 * 读取指定照片,并写到输出流中
	 * 
	 * @param id
	 * @param os
	 */
	public void read(String id, OutputStream os)
	{
		InputStream is = pictureDao.getContent(id);
		if (is == null)
		{
			log.error("cannot read Picture content, id: " + id);
			return;
		}
		try
		{
			IOUtils.copy(is, os);
		}
		catch (IOException e)
		{
			log.error("read Picture content failed! id: " + id, e);
		}
		finally
		{
			if (is != null)
			{
				try
				{
					is.close();
				}
				catch (IOException e)
				{
					log.warn("InputStream closed failed!", e);
				}
			}
		}
	}

	/**
	 * 上传一个图片
	 * 
	 * @param remark
	 * @param uploadFile
	 */
	public void add(String remark, MultipartFile uploadFile)
	{
		Picture picture = new Picture();
		picture.setRemark(remark);
		picture.setFileName(uploadFile.getOriginalFilename());
		picture.setCreateDate(new Date());
		pictureDao.add(picture);
		InputStream is = null;
		try
		{
			is = uploadFile.getInputStream();
			pictureDao.setContent(picture.getId(), is);
		}
		catch (Exception e)
		{
			log.error("upload file:" + uploadFile.getOriginalFilename() + " failed!", e);
			throw new RuntimeException("upload file:" + uploadFile.getOriginalFilename() + " failed!", e);
		}
		finally
		{
			if (is != null)
			{
				try
				{
					is.close();
				}
				catch (IOException e)
				{
					log.warn("InputStream closed failed!", e);
				}
			}
		}

	}

}
