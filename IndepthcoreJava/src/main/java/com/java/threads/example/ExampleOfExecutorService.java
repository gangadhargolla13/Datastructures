package com.java.threads.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExampleOfExecutorService {

	public static void main(String[] args) throws Exception{
		System.out.println("Main thread is started");
		ExecutorService service = new ThreadPoolExecutor(3, 10, 100000, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		Future futur = service.submit(new Perieticble());
		if(futur != null){
			System.out.println("Gangadhar");
			futur.get();
		}
		Future ff = service.submit(new Regexable());
		if(ff != null){
			System.out.println(ff.get().toString());
		}
		service.shutdown();
		System.out.println("Currently running thread is "+Thread.currentThread().getName());
	}
}

class Perieticble implements Runnable{
	public void run(){
		System.out.println("Excecution of service "+Thread.currentThread().getName());
		String str = "123du*49-%";
		int sum = 0;
		char[] ch = str.toCharArray();
		for(int i=0;i<ch.length;i++){
			if(Character.isDigit(ch[i])){
				System.out.println(ch[i]);
				sum =sum + Integer.valueOf(String.valueOf(ch[i]));
			}
		}
		System.out.println("The sum of values is "+sum);
	}
}

class Regexable implements Callable{

	public Object call() throws Exception {
		System.out.println("Excecution of service "+Thread.currentThread().getName());
		Pattern p = Pattern.compile("[amn]+");
		Matcher m = p.matcher("aaamnnny");
		if(m.matches()){
			return "String is matched";
		}else{
			return "String is not matched";
		}
	}
}