package ir.gset.utils.dateTime;


import com.gset.services.PersianCalendar;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
public class PersianDateTime {

	
	 public static String ToPersianStringDate(String gregorianDateTime) {
		 
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd'T'HH:mm", Locale.US);
	      String strLocalDate = gregorianDateTime;
	      LocalDate localDate = LocalDate.parse(strLocalDate, formatter);
	      System.out.println(localDate.getYear()+"/"+localDate.getMonthValue()+"/"+localDate.getDayOfMonth());
	      Date date = Date.valueOf(localDate);

	      String s = PersianCalendar.GregorianToSolar(date);
	     return s;
	 }
}
