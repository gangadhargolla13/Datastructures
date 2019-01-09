package com.java.core.linkedlist;

public class LNode 
{

	public int data;
	public LNode next;
	
	public LNode(int data){
		this.data=data;
		next=null;
	}
	public int getData(){
		return data;
	}
	public String toString()
	{
		return data+"-";
	}
}
