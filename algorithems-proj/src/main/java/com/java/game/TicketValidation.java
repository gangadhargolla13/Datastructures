package com.java.game;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TicketValidation {

	static boolean status = true;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter nubmer of tickets");
		//int size = sc.nextInt();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss zzzz");
		Set<String> set = new HashSet<>();
		set.add("Ganga");
		//Queue<Passencer> queue = new PriorityQueue<>(size);
		String name = sc.nextLine();
		Date d = format.parse(name);
		Date dd = new Date();
		System.out.println("Is it before "+d.before(dd));
		System.out.println("Id it after "+d.after(dd));
		System.out.println(format1.format(d));
		/*while(status)
		{
			String input = sc.nextLine();
			if(input.equals("close"))
			{
				status = false;
			}
			String[] inputArr = input.split(" ");
			if(inputArr.length==4)
			{
				if(size>=queue.size())
				{
	               try{
	            	   Date d = format.parse(inputArr[3]);
	            	   if(d.before( new Date()))
	            	   {
	            		   Passencer p = new Passencer(Integer.parseInt(inputArr[0]),inputArr[1],inputArr[2],d);
	            		   queue.add(p);
	            	   }else
	            	   {
	            		   System.out.println("Please provide after date");  
	            	   }
					}catch(ParseException p)
	               {
						System.out.println("Please provide date of jourdey as yyyy-MM-dd");
	               }
				}else
				{
					System.out.println("All tickets got booked please try tommotow");
				}
			}
			else
			{
				System.out.println("You have to provide all mandatory inputs.");
			}
		}*/
		sc.close();
	}
}

class Passencer implements Comparable<Passencer>
{
	private int id ;
	private String name;
	private String destination;
	private Date doj;
	public Passencer(int no,String identity,String des,Date date){
		name=identity;
		id = no;
		destination= des;
		doj=date;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDestination() {
		return destination;
	}
	public Date getDoj() {
		return doj;
	}
	public String toString(){
		return id+" "+name+" "+destination+" "+doj.toString();
	}
	@Override
	public int compareTo(Passencer o) {
		return this.name.compareTo(o.getName()) == 0 ? this.destination.compareTo(o.getDestination()) == 0 ? 2 : 3 : 1;
	}
}