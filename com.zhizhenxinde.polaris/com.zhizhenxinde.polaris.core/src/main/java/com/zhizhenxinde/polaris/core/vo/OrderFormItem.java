package com.zhizhenxinde.polaris.core.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 订单组成单元
 * 
 * @author wang.sheng
 * 
 */
@Entity
@Table
public class OrderFormItem
{
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	/**
	 * 对应产品ID
	 */
	@Column
	private String productId;
	/**
	 * 产品价格
	 */
	@Column
	private Integer price;
	/**
	 * 产品数量
	 */
	@Column
	private Integer number;

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

	public Integer getPrice()
	{
		return price;
	}

	public void setPrice(Integer price)
	{
		this.price = price;
	}

	public Integer getNumber()
	{
		return number;
	}

	public void setNumber(Integer number)
	{
		this.number = number;
	}

}
