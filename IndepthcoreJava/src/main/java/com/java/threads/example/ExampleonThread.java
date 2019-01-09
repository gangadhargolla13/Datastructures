package com.java.threads.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ExampleonThread {
	public static void main(String[] args) {
		try {
			System.out.println(Thread.currentThread());
			System.out.println("This is a main thread");
			System.out.println(Thread.currentThread().getName());
			First first = new First();
			first.setName("Ganga");
			Second sec = new Second();
			Thread th = new Thread(sec);
			th.setName("First thread");
			th.start();
			Thread th1 = new Thread(sec);
			th1.setName("Second thread");
			th1.start();
			//first.setPriority(Thread.MAX_PRIORITY);
			//Thread.currentThread().stop();
			//first.start();
			//first.join();
			/*for (int i = 1; i < 5; i++) {
				System.out.println("The value of J is " + i);
			}*/
			System.out.println("Main thread have been successful");
		} catch (Exception e) {
			System.out.println("Exception is occured");
			e.printStackTrace();
		} finally {
			System.out.println("Every thing went was well");

		}
	}

}

class First extends Thread {
	public void run() {
		System.out.println(Thread.currentThread());
		System.out.println(Thread.currentThread().getName());
		for (int i = 1; i < 5; i++) {
			System.out.println("The value of i is " + i);
		}
		try{
			
			Thread.sleep(10000);
			System.out.println("Current running is "+Thread.currentThread().getName());
		}catch(Exception e){
			
		}
	}
}

class Second implements Runnable{

	public void run() {
		try{
			System.out.println(Thread.currentThread().getName());
			File f = new File("ganga.txt");
			BufferedReader br = new BufferedReader(new FileReader(f));
			String str = br.readLine();
			while(null != str && !str.isEmpty()){
				System.out.println(str);
				str = br.readLine();
			}
			br.close();
			System.out.println("i have done my operations");
		}catch(Exception e){
			System.out.println("Mr.Cool you got exception so please terminate");
			
		}finally{
			System.out.println("Interface thread is being executed");
		}
	}
}