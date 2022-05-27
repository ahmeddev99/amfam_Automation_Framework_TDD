package practice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat dateFormat = new SimpleDateFormat("mmddyyyy__hh:mm.ss");
		System.out.println(dateFormat.format(date));

	}
}
