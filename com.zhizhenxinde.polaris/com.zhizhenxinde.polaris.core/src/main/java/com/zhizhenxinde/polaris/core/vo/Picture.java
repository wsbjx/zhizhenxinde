package com.zhizhenxinde.polaris.core.vo;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 图片表建模
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
	 * 图片文件的后缀名
	 */
	@Column
	private String suffix;
	/**
	 * 创建日期
	 */
	@Column
	private Date createDate;
	/**
	 * 备注信息
	 */
	@Column
	private String remark;
	/**
	 * 二进制内容
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

	public String getSuffix()
	{
		return suffix;
	}

	public void setSuffix(String suffix)
	{
		this.suffix = suffix;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
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
