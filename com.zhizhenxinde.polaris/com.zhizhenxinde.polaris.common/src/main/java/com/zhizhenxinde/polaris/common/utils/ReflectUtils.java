package com.zhizhenxinde.polaris.common.utils;

import java.util.LinkedList;
import java.util.List;
import java.lang.reflect.Field;

/**
 * 类反射工具类
 * 
 * @author wang.sheng
 * 
 */
public final class ReflectUtils
{
	private ReflectUtils()
	{
	}

	/**
	 * 获取某个类的所有属性
	 * 
	 * @param cl
	 * @return
	 */
	public static Field[] getAllFields(Class<?> cl)
	{
		List<Field> fieldList = new LinkedList<Field>();
		getAllFieldList(cl, fieldList);
		return fieldList.toArray(new Field[0]);
	}

	private static void getAllFieldList(Class<?> cl, List<Field> fieldList)
	{
		Field[] fields = cl.getDeclaredFields();
		for (Field field : fields)
		{
			fieldList.add(field);
		}
		Class<?> superClass = cl.getSuperclass();
		if (superClass != Object.class)
		{
			getAllFieldList(superClass, fieldList);
		}
	}
}
