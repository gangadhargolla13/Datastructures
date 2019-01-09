package com.java.collection.linkedlist.v2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BasicLinkedList
{
	static List<Passenger> list = new ArrayList<>(10);
  public static void main(String[] args) {
	  Calendar cal = Calendar.getInstance();
	  cal.set(2017, 8, 8);
	  Date ddd = cal.getTime();
	  Passenger n = new Passenger(111,"Gangadhar",ddd);
	  BasicLinkedList ba = new BasicLinkedList();
	  try
	  {
		  ba.addTicket(n);
	  }catch(TicketNotRegervation r)
	  {
		 System.out.println(r.getMessage());
	  }
}
  public void addTicket(Passenger p) throws TicketNotRegervation
  {
	  Calendar cal = Calendar.getInstance();
		 Date d1 = cal.getTime();
		 for(Passenger pp : list)
		 {
			 Date f = pp.jdate;
			 if(f.before(d1))
				 list.remove(pp);
		 }
	  if(list.size() > 10)
	  {
		  throw new TicketNotRegervation("Maximum number of registration are reached");
	  }
	 Date d = p.getJdate();
	 
	 if(d1.before(d))
	 {
		 throw new TicketNotRegervation("Regervation date is always before cuttent date");
	 }
	 int id = p.getId();
	 for(Passenger a : list)
	 {
		 int id1 = a.getId();
		 if(id1 == id)
		 {
			 throw new TicketNotRegervation("For you only one ticket allowed");
		 }
	 }
	 
	 list.add(p);
  }
  public void dleTicket(Passenger p)
  {
	  list.remove(p);
  }
}

class Passenger {
	int id;
	String name;
	Date jdate;
	public Passenger(int id,String name,Date jdate)
	{
		this.id=id;
		this.name=name;
		this.jdate=jdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getJdate() {
		return jdate;
	}
	public void setJdate(Date jdate) {
		this.jdate = jdate;
	}
	@Override
	public String toString()
	{
		return "Name of passanger: "+name+"  date of journey: "+jdate.toString();
	}
	@Override
	public int hashCode() {
		/*final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((jdate == null) ? 0 : jdate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;*/
		return this.id;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		if (id != other.id)
			return false;
		if (jdate == null) {
			if (other.jdate != null)
				return false;
		} else if (!jdate.equals(other.jdate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}

