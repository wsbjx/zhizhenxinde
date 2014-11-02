package com.zhizhenxinde.polaris.core.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 产品建模
 * 
 * @author wang.sheng
 * 
 */
@Entity
@Table
public class Product
{
	/**
	 * 产品ID
	 */
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	/**
	 * 产品类别ID
	 */
	@Column
	private String categoryId;
	/**
	 * 产品名称
	 */
	@Column
	private String name;
	/**
	 * 产品简单描述
	 */
	@Column
	private String description;
	/**
	 * 价格
	 */
	@Column
	private Integer price;
	/**
	 * 产品上线日期
	 */
	@Column
	private Date onlineDate;
	/**
	 * 详细信息ID
	 */
	@Column
	private String articleId;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getCategoryId()
	{
		return categoryId;
	}

	public void setCategoryId(String categoryId)
	{
		this.categoryId = categoryId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Integer getPrice()
	{
		return price;
	}

	public void setPrice(Integer price)
	{
		this.price = price;
	}

	public Date getOnlineDate()
	{
		return onlineDate;
	}

	public void setOnlineDate(Date onlineDate)
	{
		this.onlineDate = onlineDate;
	}

	public String getArticleId()
	{
		return articleId;
	}

	public void setArticleId(String articleId)
	{
		this.articleId = articleId;
	}

}
