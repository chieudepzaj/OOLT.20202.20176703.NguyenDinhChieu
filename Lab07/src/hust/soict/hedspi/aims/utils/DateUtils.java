package hust.soict.hedspi.aims.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {
	public int compareDate(MyDate date1, MyDate date2) {
		if(date1.getYear() > date2.getYear()) {
			return 1;
		}
		else if(date1.getYear() < date2.getYear()) {
			return -1;
		}
		else {
			if(date1.getMonth() > date2.getMonth()) {
				return 1;
			}
			else if(date1.getMonth() < date2.getMonth()) {
				return -1;
			}
			else {
				if(date1.getDay() > date2.getDay()) {
					return 1;
				}
				else if(date1.getDay() < date2.getDay()) {
					return -1;
				}
				else
					return 0;
			}
		}
	}
	public void swapDate(MyDate date1, MyDate date2) {
		int day, month, year;
		day = date1.getDay();
		month = date1.getMonth();
		year = date1.getYear();
		date1.setDay(date2.getDay());
		date1.setMonth(date2.getMonth());
		date1.setYear(date2.getYear());
		date2.setDay(day);
		date2.setMonth(month);
		date2.setYear(year);
	}	
	public void sortDate(MyDate []arrayDate) {
		for(int i=0; i<arrayDate.length-1; i++) {
			for(int j=0; j<arrayDate.length-i-1; j++) {
				if(compareDate(arrayDate[j], arrayDate[j+1]) > 0) {
					swapDate(arrayDate[j], arrayDate[j+1]);
				}
			}
		}
	}
	
	public void printArrDate(MyDate []arrayDate) {
		Calendar fDate = Calendar.getInstance();
        String dateFormat = "MMMMM dd yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
       
		for(int i=0; i<arrayDate.length; i++) {
	        fDate.set(arrayDate[i].iYear, arrayDate[i].iMonth, arrayDate[i].iDay);
	        System.out.println(formatter.format(fDate.getTime()));  
//	        arrayDate[i].print();
		}
	}
}
