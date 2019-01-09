package com.java.core.patterns;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExamples 
{
	public static void main(String[] args) 
	{
		Pattern p = Pattern.compile("http");
		try(BufferedReader br = new BufferedReader(new FileReader("C:\\Ganga123\\Datatrasfer.txt")))
		{
			String str=br.readLine();
	        /*while(str!=null){
	            Matcher m = p.matcher(str);
	            if(m.find())
	            {
	            System.out.println("Element is available");
	            System.out.println("Start -->"+m.start()+" End-->"+m.end()+" GroupBy-->"+m.group());
	            }
	            str = br.readLine();
	        }*/
	        String text    = "The URL is http mydomain.com";
	        String regex = "http";

	        System.out.println(Pattern.compile(regex).matcher(text).matches());
	        /*boolean matches = Pattern.matches(regex, text);

	        System.out.println("matches = " + matches);*/
		String line = "I am checking environment problemsganga so i will see after some time";
		Matcher m = p.matcher(text);
		System.out.println(m.find());
		}
		catch(IOException  f)
		{
			System.out.println("I am exception!");
		}
	}
}
