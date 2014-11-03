package com.zhizhenxinde.polaris.core.dao;

import java.io.InputStream;
import java.sql.Blob;
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
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void add(Picture vo)
	{
		this.hibernateTemplate.save(vo);
	}

	public Picture getPicture(String id)
	{
		return this.hibernateTemplate.queryForObject("from Picture t where t.id=?", new Object[] { id }, Picture.class);
	}

	/**
	 * 获取指定ID记录的二进制流
	 * 
	 * @param id
	 * @return
	 */
	public InputStream getContent(String id)
	{
		return jdbcTemplate.query("select t.content from Picture t where t.id=?", new Object[] { id },
				new ResultSetExtractor<InputStream>()
				{
					@Override
					public InputStream extractData(ResultSet rs) throws SQLException, DataAccessException
					{
						if (rs.next())
						{
							Blob blob = rs.getBlob("content");
							return blob.getBinaryStream();
						}
						return null;
					}
				});
	}

	/**
	 * 向指定ID记录写入二进制流
	 * 
	 * @param id
	 * @param is
	 */
	public void setContent(final String id, final InputStream is)
	{
		jdbcTemplate.execute("update Picture t set t.content=? where t.id=?", new PreparedStatementCallback<Object>()
		{
			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException
			{
				ps.setBinaryStream(1, is);
				ps.setString(2, id);
				return null;
			}
		});
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

	public void deleteByProduct(String productId)
	{
		this.hibernateTemplate.executeUpdate("delete from Picture t where t.id in "
				+ "(select r.pictureId from ProductPicture r where r.productId=?)", new Object[] { productId });
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
