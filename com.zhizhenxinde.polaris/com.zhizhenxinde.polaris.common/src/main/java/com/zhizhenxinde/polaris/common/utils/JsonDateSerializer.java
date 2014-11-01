package com.zhizhenxinde.polaris.common.utils;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * JSON的日期格式转换器
 * 
 * @author wang.sheng
 */
public class JsonDateSerializer extends JsonSerializer<Date>
{
	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider provider) throws IOException,
			JsonProcessingException
	{
		gen.writeString(DateFormatUtils.format(date, "yyyy-MM-dd"));
	}

}
