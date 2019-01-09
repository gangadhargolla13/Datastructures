package com.java.core.patterns;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectionExample {

	public static void main(String[] args)  throws Exception
	{
		Class c = Class.forName("com.java.core.patterns.DatePattrensExample");
		System.out.println(c.getClassLoader().hashCode());
		Constructor[] cd = c.getConstructors();
		Annotation[] an = c.getAnnotations();
		Constructor r = c.getConstructor();
		DatePattrensExample e = (DatePattrensExample)r.newInstance(new Integer(123));
		System.out.println(e.getSize());
		for(Annotation a:an)
		{
			System.out.println(a.hashCode());
		}
		for(Constructor c1: cd)
		{
			
			//System.out.println(c1.getDeclaredAnnotations());
		}
		Field[] f = c.getDeclaredFields();
		for(Field f1:f)
		{
			//System.out.println(f1.getName());
			//System.out.println(f1.getModifiers());
		}
		//Class d = DatePattrensExample.class;
		/*Constructor[] c = d.getConstructors();
		for(Constructor c1: c)
		{
			
			DatePattrensExample ff =(DatePattrensExample)d.newInstance();
			//System.out.println(c1.);
		}
		Method[] m =d.getMethods();
		for(Method m1:m)
		{
			System.out.println(m1.getName());
		}*/
	}
}
