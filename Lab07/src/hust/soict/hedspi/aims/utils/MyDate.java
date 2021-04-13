package hust.soict.hedspi.aims.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyDate {
    public int iDay;
    public int iMonth; 
    public int iYear;

    public MyDate() {
        Calendar curDate = Calendar.getInstance();
        this.iDay = curDate.get(Calendar.DAY_OF_MONTH);
        this.iMonth = curDate.get(Calendar.MONTH);
        this.iYear = curDate.get(Calendar.YEAR);
    }

    public MyDate(int day, int month, int year) {
        Calendar fDate = Calendar.getInstance();
        fDate.set(year, month-1, 1);
        if(day < 1 || day > fDate.getActualMaximum(Calendar.DAY_OF_MONTH) ){ //getActualMaximum to get the last day of month
        	System.out.println("month: " + month + ", day: " + day + " is not valid");
            return;
        }
        
        this.iDay = day;
        this.iMonth = month-1;
        this.iYear = year;
    }
    
    public MyDate(String day, String month, String year) {
    	String[] strDay = {"first","second","third","fourth","fifth","sixth","seventh","eighth","ninth","tenth","eleventh","twelfth","thirteenth",
                		   "fourteenth","fifteenth","sixteenth","seventeenth","eighteenth","nineteenth","twentieth","twenty-first","twenty-second",
                		   "twenty-third", "twenty-fourth","twenty-fifth","twenty-sixth","twenty-seventh","twenty-eighth","twenty-ninth","thirtieth",
                		   "thirty-first"};
        String[] strMonth = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        for(int i=0; i<31; i++) {
            if(strDay[i].equals(day))
                this.iDay = i+1;
        }
        for(int i=0;i<12;i++) {
            if(strMonth[i].equals(month))
                this.iMonth = i;
        }    
        String unitsArray[] = { "zero", "one", "two", "three", "four", "five", "six", 
                "seven", "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", 
                "eighteen", "nineteen" };
        String tensArray[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty","sixty", "seventy", "eighty", "ninety" };
        for(int i=0;i<12;i++) {
        	if(strMonth[i].equals(month))
        	this.iMonth = i;
        }
  
        String[] yearList = year.split("\\s|-");
        int yNumber = 0;
        switch (yearList.length) {
        case 4:
          for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[0])) yNumber += i*1000;
          for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[1])) yNumber += i*100;
          for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[2])) yNumber += i*10;
          for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[3])) yNumber += i;
          break;
        case 3:
          for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[0])) yNumber += i*1000;
          for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[0])) yNumber += i*100;
          for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[1])) yNumber += i*10;
          for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[1])) yNumber += i*100;
          for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[2])) yNumber += i*10;
          for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[2])) yNumber += i;
          break;
        case 2:
          for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[0])) yNumber += i*1000;
          for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[0])) yNumber += i*100;
          for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[1])) yNumber += i*10;
          for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[1])) yNumber += i; 
          break;
        default:
          break;
        }
        this.iYear = yNumber;
    }

    
    public MyDate(String iDate) {
        String dateFormat = "MM dd yyyy";
        Date bDate; 
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar fDate = Calendar.getInstance();
        formatter.setLenient(false);
        try {
            bDate = formatter.parse(iDate.trim());
        } catch (ParseException pe) {
            return;
        }      
        
        fDate.setTime(bDate);
        this.iDay = fDate.get(Calendar.DAY_OF_MONTH);
        this.iMonth = fDate.get(Calendar.MONTH);
        this.iYear = fDate.get(Calendar.YEAR);
    }    

    public int getDay() {
        return iDay;
    }

    public void setDay(int day) {
        Calendar fDate = Calendar.getInstance();
        fDate.set(iYear, iMonth, 1); //set the time
        if(day < 1 || day > fDate.getActualMaximum(Calendar.DAY_OF_MONTH) ){ //getActualMaximum to get the last day of month
      //      System.out.println("Not valid day.");
            return;
        }
            
        this.iDay = day;
    }

    public int getMonth() {
        return iMonth+1;
    }

    public void setMonth(int month) {
        Calendar fDate = Calendar.getInstance();
        if(month > 12) {
        	System.out.println("Not valid month");
        	return;
        }
        else {
        	fDate.set(iYear, month-1, 1); //get the first day of input month only for getting month, 1 or 2 day is not important
        	if(iDay > fDate.getActualMaximum(Calendar.DAY_OF_MONTH)) { 
        		System.out.println("Not valid month.");
        		return;
        	}
        }
            
        this.iMonth = month-1;
    }
    public int getYear() {
        return iYear;
    }

    public void setYear(int year) {
        Calendar fDate = Calendar.getInstance();
        fDate.set(year, iMonth, 1); //get the first day of input month only for getting month, 1 or 2 day is not important
        if(iDay > fDate.getActualMaximum(Calendar.DAY_OF_MONTH)) { 
            System.out.println("Not valid year.");
            return;
        }
        
        this.iYear = year;
    }
        
    public void accept() {
        String dateFormat = "MM dd yyyy";
        Date bDate;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a date: ");
        String strDate = keyboard.nextLine().trim();
        String[] array = strDate.split(" ");
        String sMonth = array[0];
        String sDay = array[1];
        String sYear = array[2];
        int month, day, year;
        String date;
	// Xu ly ngay
	   Pattern p = Pattern.compile("\\d+");
       Matcher m = p.matcher(array[1]);
       m.find();
       sDay = m.group();
       day = Integer.parseInt(sDay);
       year = Integer.parseInt(sYear);
    // Xu ly thang
       switch (sMonth) {
        	case "1": case "January": case "Jan": case "Jan.":
        		month = 1;
        		break;
        	case "2": case "February": case "Feb": case "Feb.":
        		month = 2;
        		break;
        	case "3": case "March": case "Mar": case "Mar.":
        		month = 3;
        		break;
        	case "4": case "April": case "Apr": case "Apr.":
        		month = 4;
        		break;
        	case "5": case "May":
        		month = 5;
        		break;
        	case "6": case "June": case "Jun":
        		month = 6;
        		break;
        	case "7": case "July": case "Jul":
        		month = 7;
        		break;
        	case "8": case "August": case "Aug": case "Aug.":
        		month = 8;
        		break;
        	case "9": case "September": case "Sep": case "Sep.":
        		month = 9;
        		break;
        	case "10": case "October": case "Oct": case "Oct.":
        		month = 10;
        		break;
        	case "11": case "November": case "Nov": case "Nov.":
        		month = 11;
        		break;
        	case "12": case "December": case "Dec": case "Dec.":
        		month = 12;
        		break;
        	default:
        		System.out.println("Not valid month.");
        		return;
        }

		date = month + " " + day + " " + year;
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar fDate = Calendar.getInstance();
        formatter.setLenient(false);
        try {
            bDate = formatter.parse(date);
        } catch (ParseException pe) {
            System.out.println("Invalid date or format");
            return;
        }
        
        fDate.setTime(bDate);
        this.iDay = fDate.get(Calendar.DAY_OF_MONTH);
        this.iMonth = fDate.get(Calendar.MONTH);
        this.iYear = fDate.get(Calendar.YEAR);   
        System.out.println("Updated sucessfully");
        keyboard.close();
    }
    
    public void print() {
        Calendar fDate = Calendar.getInstance();
        fDate.set(iYear, iMonth, iDay);
        String dateFormat;
        
        switch (iDay) {
            case 1:
                dateFormat = "MMMMM d'st' yyyy";
                break;
            case 2:
                dateFormat = "MMMMM d'nd' yyyy";
                break;
            case 3:
                dateFormat = "MMMMM d'rd' yyyy";
                break;
            default:
                dateFormat = "MMMMM dd'th' yyyy";
                break;
        }
        
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        System.out.println(formatter.format(fDate.getTime()));                                                          
    }
    
    public void printFormat() {
        Calendar fDate = Calendar.getInstance();
        fDate.set(iYear, iMonth, iDay);
        String dateFormat;
        int choice;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please choose the optional date format; ");
        System.out.println("1. yyyy-MM-dd");
        System.out.println("2. d/M/yyyy");
        System.out.println("3. dd-MMM-yyyy");
        System.out.println("4. MMM d yyyy");
        System.out.println("5. mm-dd-yyyy");
        choice = sc.nextInt();
        
        switch (choice) {
            case 1:
                dateFormat = "yyyy-MM-dd";
                break;
            case 2:
                dateFormat = "d/M/yyyy";
                break;
            case 3:
                dateFormat = "dd-MMM-yyyy";
                break;
            case 4:
                dateFormat = "MMM d yyyy";
                break;
            case 5:
                dateFormat = "mm-dd-yyyy";
                break;
            default:
                dateFormat = "MMMMM dd yyyy";
                break;
        }
        
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        System.out.println(formatter.format(fDate.getTime()));                                                     
    }
}
