package com.java.threads.example2;

public class BasicsExamples 
{
    Runnable run = () -> System.out.println("I am called");
    public static void main(String[] args) 
    {
    	System.out.println("I am fine");
	   System.out.println(Thread.currentThread().getName());	
	}
}
