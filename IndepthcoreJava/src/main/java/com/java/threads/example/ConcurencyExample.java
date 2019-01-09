package com.java.threads.example;

import java.text.SimpleDateFormat;

public class ConcurencyExample {
	public static void main(String[] args) {
		final Synctest test =new Synctest();
      // Thread th1 = new Thread(){public void run(){System.out.println(test.getName("01/31/2012"));}};
		//Thread th1 = new Thread(){public void run(){System.out.println(test.getNmae2("2012-01-31 23:59:59"));}};
		Thread th1 = new Thread(){public void run(){System.out.println(Synctest.getName1("2012-01-31"));}};
       th1.setName("Ganga");
       th1.start();
       Thread th2 = new Thread(){public void run(){test.getName("01/31/2012");}};
       th2.setName("Malli");
       th2.start();
       //System.out.println("Thread operation is completed");
	}
}

class Synctest {
	public  synchronized String getName(String name) {
		System.out.println("This is an instant method of synchronized");
		String formatName = null;
		try {
			if (name == null && "".equals(name)) {
				formatName = "";
			} else {
				SimpleDateFormat format = new SimpleDateFormat();
				format.applyPattern("MM/dd/yyyy");
				formatName = format.parse(name).toString();
				System.out.println("Current thread is "+Thread.currentThread().getName());
				Thread.sleep(10000);
				System.out.println("Current thread is "+Thread.currentThread().getName()+" Its operation is completed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formatName;
	}

	public static synchronized String getName1(String name) {
		System.out.println("This is an static method of synchronized");
		String formatName = null;
		try {
			if (name == null && "".equals(name)) {
				formatName = "";
			} else {
				SimpleDateFormat format = new SimpleDateFormat();
				format.applyPattern("yyyy-MM-dd");
				formatName = format.parse(name).toString();
				System.out.println("Current running thread is "+Thread.currentThread().getName());
				Thread.sleep(10000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formatName;
	}

	public String getNmae2(String name) {
		System.out.println("This is an instant block of synchronized");
		String formatName = null;
		try {
			if (name == null && "".equals(name)) {
				formatName = "";
			} else {
				synchronized (this) {
					SimpleDateFormat format = new SimpleDateFormat();
					format.applyPattern("yyyy-MM-dd HH:mm:ss");
					formatName = format.parse(name).toString();
					System.out.println("Current running thread is "+Thread.currentThread().getName());
					Thread.sleep(10000);
					//System.out.println("Current running thread is "+Thread.currentThread().getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formatName;
	}

	public static String getNmae3(String name) {
		System.out.println("This is an static block of synchronized");
		String formatName = null;
		try {
			if (name == null && "".equals(name)) {
				formatName = "";
			} else {
				synchronized (ConcurencyExample.class) {
					SimpleDateFormat format = new SimpleDateFormat();
					format.applyPattern("yyyy-MM-dd HH:mm:ss.SSS");
					formatName = format.parse(name).toString();
					System.out.println("Current running thread is "+Thread.currentThread().getName());
					Thread.sleep(10000);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formatName;
	}
}