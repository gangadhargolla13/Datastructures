package com.java.threads.example;

public class ThreadMemory {

	public  int value = 2;
	
	public static void main(String[] args) {
		ThreadMemory m = new ThreadMemory();
		System.out.println(Thread.currentThread().getName()+"  "+m.value);
		RunnImpl impl = new RunnImpl();
		Thread t1 = new Thread(impl);
		t1.setName("Ganga");
		t1.start();
		Thread t2 = new Thread(impl);
		t2.setName("Malli");
		t2.start();
		System.out.println(Thread.currentThread().getName()+"  "+m.value);
	}
}

class RunnImpl implements Runnable {
	//ThreadMemory m =new ThreadMemory();
	@Override
	public void run() {
		int test =1;
		for(int i= 0;i<10;i++){
			if("Ganga".equals(Thread.currentThread().getName())){
				//m.value=m.value+3;
				test+=4;
				System.out.println(Thread.currentThread().getName()+"---"+test);
			}
			else{
			//m.value++;
				test++;
			System.out.println(Thread.currentThread().getName()+"---"+test);
			}
		}
		
	}
}