package com.zhizhenxinde.polaris.core.vo;

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
	 * 产品图片ID
	 */
	@Column
	private String pictureId;
	/**
	 * 产品简单描述
	 */
	@Column
	private String description;
	/**
	 * 详细信息ID
	 */
	@Column
	private String detailId;

}
