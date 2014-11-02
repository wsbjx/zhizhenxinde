package com.zhizhenxinde.polaris.core.vo;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 产品图片建模
 * 
 * @author wang.sheng
 * 
 */
@Entity
@Table
public class Picture
{
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	/**
	 * 对应的产品ID
	 */
	@Column
	private String productId;
	/**
	 * 图片宽度
	 */
	@Column
	private Integer width;
	/**
	 * 图片高度
	 */
	@Column
	private Integer height;
	/**
	 * 存放图片的二进制流
	 */
	@Column
	private Blob content;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getProductId()
	{
		return productId;
	}

	public void setProductId(String productId)
	{
		this.productId = productId;
	}

	public Integer getWidth()
	{
		return width;
	}

	public void setWidth(Integer width)
	{
		this.width = width;
	}

	public Integer getHeight()
	{
		return height;
	}

	public void setHeight(Integer height)
	{
		this.height = height;
	}

	public Blob getContent()
	{
		return content;
	}

	public void setContent(Blob content)
	{
		this.content = content;
	}

}
