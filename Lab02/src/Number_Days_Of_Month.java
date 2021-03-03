import javax.swing.JOptionPane;
public class Number_Days_Of_Month {
public static void main(String[] args) {
	String[] month1 = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	String[] month2 = {"Jan.","Feb.","Mar.","Apr.","May","June","July","Aug.","Sept.","Oct.","Nov.","Dec."};
	String[] month3 = {"Jan","Feb","Mar","Apr","May","June","July","Aug","Sept","Oct","Nov","Dec"};
	int[] month4= {1,2,3,4,5,6,7,8,9,10,11,12};
	String month;
	int year;
	int n = 0,m = 0,check=0;
	int number_Of_DaysInMonth = 0;
	String MonthOfName = "unknown";
	do {
		month = JOptionPane.showInputDialog(null,"Enter the month :");
		for(int i=0;i<=11;i++)
		{
			if(month.compareToIgnoreCase(month1[i])==0)
			{
				n = 1;
				check = i+1;
				break;
			}
			if(month.compareToIgnoreCase(month2[i])==0)
			{
				n = 1;
				check = i+1;
				break;
			}
			if(month.compareToIgnoreCase(month3[i])==0)
			{
				n = 1;
				check = i+1;
				break;
			}
			// can't compare string vs num
			String k = String.valueOf(month4[i]);
			if(month.compareToIgnoreCase(k)==0)
			{
				n = 1;
				check = i+1;
				break;
			}
		}
	}while(n!=1);
		do {
			String Sy = JOptionPane.showInputDialog(null,"Enter the year: ");
			year = Integer.parseInt(Sy);	
			if(year>=0) {m = 1;}
		} while (m!=1);
		switch (check) {
        case 1:
            MonthOfName = "January";
            number_Of_DaysInMonth = 31;
            break;
        case 2:
            MonthOfName = "February";
            if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                number_Of_DaysInMonth = 29;
            } else {
                number_Of_DaysInMonth = 28;
            }
            break;
        case 3:
            MonthOfName = "March";
            number_Of_DaysInMonth = 31;
            break;
        case 4:
            MonthOfName = "April";
            number_Of_DaysInMonth = 30;
            break;
        case 5:
            MonthOfName = "May";
            number_Of_DaysInMonth = 31;
            break;
        case 6:
            MonthOfName = "June";
            number_Of_DaysInMonth = 30;
            break;
        case 7:
            MonthOfName = "July";
            number_Of_DaysInMonth = 31;
            break;
        case 8:
            MonthOfName = "August";
            number_Of_DaysInMonth = 31;
            break;
        case 9:
            MonthOfName = "September";
            number_Of_DaysInMonth = 30;
            break;
        case 10:
            MonthOfName = "October";
            number_Of_DaysInMonth = 31;
            break;
        case 11:
            MonthOfName = "November";
            number_Of_DaysInMonth = 30;
            break;
        case 12:
            MonthOfName = "December";
            number_Of_DaysInMonth = 31;
    }
    JOptionPane.showMessageDialog(null,MonthOfName + " " + year + " has " + number_Of_DaysInMonth + " days.");
		
}
}
