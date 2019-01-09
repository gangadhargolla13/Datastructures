package com.java.latestfeatures;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


 interface MyFactory {
    public String create(char[] chars);
}
public class LamdaExample {
	// Type inference there in java as lamda expresions and Generic diamond operator
	public static void main(String[] args) {
		MyFactory myFactory = (chars) -> {
		    return new String(chars);
		};
		List<String> list = new ArrayList<>();
		list.add("Gangadhar");
		list.add("Ganesh");
		list.add("Sujatha");
		//list.
		Comparator<String> comp = (a, b) -> b.compareTo(a);
		Collections.sort(list, comp);
		/*StateChnageLister1 df = (a1, a2) -> { return a1 > a2; };
		StateChnageLister1 li1 = (a, b) -> { return a > b;};*/
		//StateChnageLister li = (old, latest) -> System.out.println("I am chnaging from " + old + " to " + latest);
		// li.onStateChange("Chennai", "Hyderbad or Bangalore");
		//call(li);

		// Priot to java 8
		/*
		 * call(new StateChnageLister() {
		 * 
		 * @Override public void onStateChange(String old, String latest) {
		 * System.out.println("I am fine"); } });
		 */

		call((a, b) -> { 
			System.out.println("I am fine " + a);
			System.out.println("I am fine " + b);
			}
		);
	}

	public static void call(StateChnageLister li) {
		li.onStateChange("Chennai", "Hyderbad or Bangalore");
	}
	
	//String check = () -> System.out.println("Zero parameter lambda"); Error as target type is functional interface
}
//@FunctionalInterface
interface StateChangeLister1
{
	public int compare(int a,int b);
}
interface StateChnageLister {
	public void onStateChange(String old, String latest);
	static void printItToSystemOut(String text){
        System.out.println(text);
    }
	default public void printUtf8To(String text, OutputStream outputStream){
        try {
            outputStream.write(text.getBytes("UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException("Error writing String as UTF-8 to OutputStream", e);
        }
    }
}

class Checking implements StateChnageLister
{

	@Override
	public void onStateChange(String old, String latest) {
		// TODO Auto-generated method stub
		
	}
	void printItToSystemOut(String master)
	{
		System.out.println("I am not master");
	}
}
