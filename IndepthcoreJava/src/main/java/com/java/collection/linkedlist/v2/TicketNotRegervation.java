package com.java.collection.linkedlist.v2;

public class  TicketNotRegervation extends Throwable
{
	private String massage = null;
	public TicketNotRegervation(String msg)
	{
		super(msg);
		massage=msg;
	}
	@Override
	public String toString()
	{
		return massage;
	}
}
