/*package com.java.core.algo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class SortingMain 
{

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Map m = new HashMap();
		Callable c = null;
		m.put("Ga", 123);
		//Class c = MergeSorting.class;
		MergeSorting s = null;
		int[] data = {34,21,4,2,17};
		Constructor[] cc = c.getConstructors();
		for(Constructor ccc : cc)
		{
			if(s== null)
				s = (MergeSorting)ccc.newInstance();
		}
		Method[] m = c.getMethods();
		for(Method m1 : m)
		{
			m1.setAccessible(true);
			if(m1.getName().equals("sorting"))
			{
				m1.invoke(s, data);
			}
		}
	}
}
*/