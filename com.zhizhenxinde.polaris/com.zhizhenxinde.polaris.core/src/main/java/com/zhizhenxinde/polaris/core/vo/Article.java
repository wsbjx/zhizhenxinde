package com.zhizhenxinde.polaris.core.vo;

import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 图文内容建模
 * 
 * @author wang.sheng
 * 
 */
@Entity
@Table
public class Article
{
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	/**
	 * 文章标题
	 */
	@Column
	private String title;
	/**
	 * 摘要,关键字
	 */
	@Column
	private String summary;
	/**
	 * 大文本
	 */
	@Column
	private Clob content;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getSummary()
	{
		return summary;
	}

	public void setSummary(String summary)
	{
		this.summary = summary;
	}

	public Clob getContent()
	{
		return content;
	}

	public void setContent(Clob content)
	{
		this.content = content;
	}

}
