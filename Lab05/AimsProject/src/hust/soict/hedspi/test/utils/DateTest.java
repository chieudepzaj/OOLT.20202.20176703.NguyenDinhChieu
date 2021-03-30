package hust.soict.hedspi.test.utils;
import hust.soict.hedspi.aims.utils.DateUtils;
import hust.soict.hedspi.aims.utils.MyDate;

public class DateTest {
    public static void main(String[] args) {
        MyDate date1 = new MyDate(1, 2, 1999);
        MyDate date2 = new MyDate("first", 2, 1999);
        MyDate date3 = new MyDate("first", "feb", 1999);
        MyDate date4 = new MyDate(1, "feb", 1999);
        MyDate date5 = new MyDate("first", "feBruary", 1999);
        MyDate date6 = new MyDate(1, "February", 1999);
        MyDate[] dateArray = new MyDate[] {date1, date2, date3, date4, date5, date6};
        String[] format = new String[] {"dd/mm/yyyy", "d:yy:m", "yy-mmm*dd", "yyyy:d/m", "mmm+yyyy\\d", "MMM d yyyy"};
        System.out.println("Date is February, 1st 1999");
        for (int i = 0; i < dateArray.length; i++) {
           System.out.print("Print in format: " + format[i] + "\t");
           dateArray[i].printWithFormat(format[i]);
        }
        MyDate date7 = new MyDate(1, 1, 1999);
        MyDate date8 = new MyDate(2, 2, 1999);
        System.out.println(DateUtils.DateCompare(date1, date7));
        System.out.println(DateUtils.DateCompare(date1, date8));
        System.out.println(DateUtils.DateCompare(date1, date2));
    }
}   