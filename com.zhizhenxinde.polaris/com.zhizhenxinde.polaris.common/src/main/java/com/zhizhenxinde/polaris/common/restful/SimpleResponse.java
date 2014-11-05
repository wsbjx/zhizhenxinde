package com.zhizhenxinde.polaris.common.restful;

/**
 * 用于展示简单回显
 * 
 * @author wang.sheng
 * 
 */
public class SimpleResponse
{
	private boolean success = true;
	private String message;
	private Object data;

	public boolean isSuccess()
	{
		return success;
	}

	public void setSuccess(boolean success)
	{
		this.success = success;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public Object getData()
	{
		return data;
	}

	public void setData(Object data)
	{
		this.data = data;
	}

}
