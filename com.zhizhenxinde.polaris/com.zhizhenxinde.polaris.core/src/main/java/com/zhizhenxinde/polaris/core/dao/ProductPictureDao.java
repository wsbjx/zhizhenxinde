package com.zhizhenxinde.polaris.core.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.zhizhenxinde.polaris.common.dao.HibernateTemplate;
import com.zhizhenxinde.polaris.core.vo.ProductPicture;

/**
 * 产品图片DAO
 * 
 * @author wang.sheng
 * 
 */
@Repository
public class ProductPictureDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;

	public ProductPicture[] getProductPictures(String productId)
	{
		return this.hibernateTemplate.queryForArray("from ProductPicture t where t.productId=?", new Object[] { productId },
				ProductPicture.class);
	}

	public ProductPicture getProductPicture(String id)
	{
		return this.hibernateTemplate.queryForObject("from ProductPicture t where t.id=?", new Object[] { id }, ProductPicture.class);
	}

	public void deleteByProduct(String productId)
	{
		this.hibernateTemplate.executeUpdate("delete from ProductPicture t where t.productId=?", new Object[] { productId });
	}

	public void delete(String id)
	{
		this.hibernateTemplate.executeUpdate("delete from ProductPicture t where t.id=?", new Object[] { id });
	}

	public void add(ProductPicture vo)
	{
		this.hibernateTemplate.save(vo);
	}

	public void update(ProductPicture vo)
	{
		this.hibernateTemplate.update(vo);
	}

}
