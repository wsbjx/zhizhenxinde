package com.zhizhenxinde.polaris.core.vo;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 产品图片建模<br>
 * 用户可以连续查看该产品的全部图片<br>
 * 并可以指定作为产品封面的图片<br>
 * 
 * @author wang.sheng
 * 
 */
@Entity
@Table
public class ProductPicture
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

	public Blob getContent()
	{
		return content;
	}

	public void setContent(Blob content)
	{
		this.content = content;
	}

}
