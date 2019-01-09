package com.java.threads.example2;

public class DeadLockExamples 
{
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		Thread t1 = new Thread(new SyncThread(obj1,obj2));
		Thread t2 = new Thread(new SyncThread(obj2,obj1));
		t1.start();
		t2.start();
	}
}
class SyncThread implements Runnable
{
	private Object obj1;
	private Object obj2;
	public SyncThread(Object obj1,Object obj2)
	{
		this.obj1=obj1;
		this.obj2=obj2;
	}
	public void run()
	{
		String name = Thread.currentThread().getName();
        System.out.println(name + " acquiring lock on "+obj1);
        synchronized (obj1) {
         System.out.println(name + " acquired lock on "+obj1);
         work();
         System.out.println(name + " acquiring lock on "+obj2);
         synchronized (obj2) {
            System.out.println(name + " acquired lock on "+obj2);
            work();
        }
         System.out.println(name + " released lock on "+obj2);
        }
        System.out.println(name + " released lock on "+obj1);
        System.out.println(name + " finished execution.");
	}
	private void work() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

