package com.zhizhenxinde.polaris.common.utils;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * 日期时间的格式转换
 * 
 * @author wang.sheng
 * 
 */
public class JsonDateTimeSerializer extends JsonSerializer<Date>
{
	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider provider) throws IOException,
			JsonProcessingException
	{
		gen.writeString(DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss"));
	}

}
