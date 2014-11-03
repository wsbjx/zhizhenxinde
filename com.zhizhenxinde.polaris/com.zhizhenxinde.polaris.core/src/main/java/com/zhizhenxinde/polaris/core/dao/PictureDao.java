package com.zhizhenxinde.polaris.core.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.zhizhenxinde.polaris.common.dao.HibernateTemplate;
import com.zhizhenxinde.polaris.core.vo.Picture;

/**
 * 图片表DAO
 * 
 * @author wang.sheng
 * 
 */
@Repository
public class PictureDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;

	public void add(Picture vo)
	{
		this.hibernateTemplate.save(vo);
	}

	public void update(Picture vo)
	{
		this.hibernateTemplate.update(vo);
	}

	public Picture getPicture(String id)
	{
		return this.hibernateTemplate.queryForObject("from Picture t where t.id=?", new Object[] { id }, Picture.class);
	}

	/**
	 * 根据产品查找对应的图片集合
	 * 
	 * @param productId
	 * @return
	 */
	public Picture[] getPicturesByProduct(String productId)
	{
		return this.hibernateTemplate.queryForArray("from Picture t where t.id in "
				+ "(select r.pictureId from ProductPicture r where r.productId=?)", new Object[] { productId }, Picture.class);
	}

	public Picture[] getPictures()
	{
		return this.hibernateTemplate.queryForArray("from Picture t ", null, Picture.class);
	}

	public void delete(String id)
	{
		this.hibernateTemplate.executeUpdate("delete from Picture t where t.id=?", new Object[] { id });
	}
}
