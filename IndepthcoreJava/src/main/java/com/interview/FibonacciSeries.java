package com.interview;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter input text");
		String msg = sc.nextLine();
		if(msg.length()>0 && msg.length()<=255)
		{
			FibonacciSeries fs = new FibonacciSeries();
			msg = msg.replace(" ", "");
			char[] ch = msg.toCharArray();
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<ch.length;i++)
			{
				int m = fs.fibIndex(i);
				if(m > ch.length)
				{
					break;
				}
				else
				{
					sb.append(ch[m]);
					sb.append("-");
				}
			}
			String kk = sb.toString().toUpperCase();
			System.out.println(kk.substring(0, kk.lastIndexOf("-")));
		}
		else
		{
			System.out.println("Please enter text in between 0 to 255 characters");
		}
		sc.close();
	}
	
	private int fibIndex(int n) {
		double d = (Math.pow((1+Math.sqrt(5)), n) - Math.pow((1-Math.sqrt(5)), n))/((Math.pow(2, n))*Math.sqrt(5));
		Double d1 = new Double(d);
		return d1.intValue();
	}
}
