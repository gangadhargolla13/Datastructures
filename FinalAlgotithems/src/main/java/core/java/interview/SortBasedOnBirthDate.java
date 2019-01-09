package core.java.interview;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SortBasedOnBirthDate {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime().toString());
		cal.set(Calendar.MONTH, 11);
		System.out.println(cal.get(Calendar.MONTH));
		Calendar cal1 = Calendar.getInstance();
		System.out.println(cal1.getTime().toString());
		cal.set(Calendar.MONTH, 05);
		System.out.println(cal.after(cal1));
		System.out.println(cal.getTime().toString());
		System.out.println(cal1.getTime().toString());
		/*try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Enter people");
			int size = sc.nextInt();
			List<BirthDate> list = new ArrayList<>();
			SortBasedOnBirthDate da = new SortBasedOnBirthDate();
			for(int i=0;i<size;i++)
			{
				System.out.println("Enter the name and Birthday date");
				String ddate = sc.next();
				String[] ddate1= ddate.split(",");
				BirthDate d = new BirthDate(ddate1[0], ddate1[1]);
				list.add(d);
				System.out.println("");
			}
			Collections.sort(list,new BdateCompare());
			for(BirthDate ddd : list)
			{
				System.out.println(ddd.getName()+" "+ddd.getBdate().toString());
			}
		} catch (Exception e) {

		}*/
	}
}

class BirthDate {
	private String name;
	private Date bdate;
	private Integer month;
	private Integer day;

	public BirthDate(String name, String bdate1) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.name = name;
		try {
			this.bdate = format.parse(bdate1);
			Calendar cal = Calendar.getInstance();
			cal.setTime(bdate);
			this.month = cal.get(Calendar.MONTH);
			this.day = cal.get(Calendar.DAY_OF_MONTH);
		} catch (Exception e) {
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}
}

class BdateCompare implements Comparator<BirthDate> {
	@Override
	public int compare(BirthDate o1, BirthDate o2) {
		if (o1.getMonth().compareTo(o2.getMonth()) == 0) {
			return o1.getDay().compareTo(o2.getDay());
		} else
			return o1.getMonth().compareTo(o2.getMonth());
	}
}

