package DateFormatExamples;

import java.util.Calendar;
import java.util.Date;

public class Datecomparision {

	public static void main(String[] args) {
		Date d = new Date();
		Date d1 = new Date();
		d1.setTime(1501471468999l);
		if(d1.before(d))
		{
			System.out.println("ganga");
		}
		Calendar c = Calendar.getInstance();
		
	}
}
