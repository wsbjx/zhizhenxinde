package com.zhizhenxinde.polaris.core.dao;

import java.io.Reader;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.zhizhenxinde.polaris.common.dao.HibernateTemplate;
import com.zhizhenxinde.polaris.core.vo.Article;

/**
 * 文章DAO
 * 
 * @author wang.sheng
 * 
 */
@Repository
public class ArticleDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	private JdbcTemplate jdbcTemplate;

	public Article getArticle(String id)
	{
		return this.hibernateTemplate.queryForObject("from Article t where t.id=?", new Object[] { id }, Article.class);
	}

	public Article[] getArticles()
	{
		return this.hibernateTemplate.queryForArray("from Article t", null, Article.class);
	}

	public void add(Article vo)
	{
		this.hibernateTemplate.save(vo);
	}

	public void update(Article vo)
	{
		this.hibernateTemplate.update(vo);
	}

	public void delete(String id)
	{
		this.hibernateTemplate.executeUpdate("delete from Article t where t.id=?", new Object[] { id });
	}

	/**
	 * 根据文章ID获取内容Reader
	 * 
	 * @param id
	 * @return
	 */
	public Reader getContent(String id)
	{
		return jdbcTemplate.query("select t.content from Article t where t.id=?", new Object[] { id }, new ResultSetExtractor<Reader>()
		{
			@Override
			public Reader extractData(ResultSet rs) throws SQLException, DataAccessException
			{
				if (rs.next())
				{
					Clob clob = rs.getClob("content");
					return clob.getCharacterStream();
				}
				return null;
			}
		});
	}

	/**
	 * 根据文章ID和内容Reader更新数据库中的内容
	 * 
	 * @param id
	 * @param reader
	 */
	public void setContent(final String id, final Reader reader)
	{
		jdbcTemplate.execute("update Article t set t.content=? where t.id=?", new PreparedStatementCallback<Integer>()
		{
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException
			{
				ps.setClob(1, reader);
				ps.setString(2, id);
				return ps.executeUpdate();
			}
		});
	}

}
