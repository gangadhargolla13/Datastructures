package DateFormatExamples;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class DateformatseExample {
	public static void main(String[] args) {
		DateformatseExample ex = new DateformatseExample();
		ex.dateFormater();
	}

	public void datePresentation() {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		//System.out.println(cal.toString());
		Calendar cal1 = Calendar.getInstance();
		//cal1.add(Calendar.DAY_OF_MONTH, -10);
		cal1.set(1988, 9, 31);
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal1.getTime());
		if(cal1.getTime().compareTo(cal.getTime()) >= 1){
			System.out.println("Both dates are same!");
		}
		if(cal1.getTime().after(cal.getTime())){
			System.out.println("I am gangadhar");
		}
	}
	
	public void dateFormater(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		
		
		    TimeZone zone = TimeZone.getTimeZone("America/St_Thomas");
		    cal.setTimeZone(zone);
		    System.out.println(format.format(cal.getTime()));
		String[] availableIDs = TimeZone.getAvailableIDs();

		
	}
}
