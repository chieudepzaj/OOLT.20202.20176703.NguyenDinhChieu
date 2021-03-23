import java.util.Date;
public class MyDate {
    public static final String[] dayStr = new String[] { "first", "second", "third", "forth", "fifth", "sixth",
            "seventh", "righth", "nineth", "tenth", "eleventh", "twelveth", "thirdteenth", "forthteenth", "fifteenth",
            "sixteenth", "seventeenth", "eighteenth", "nineteenth", "twentyth", "twnentyoneth", "twentytwoth",
            "twentythreeth", "twentyforth", "twentyfifth", "twentysixth", "twentyseventh", "twentynineth", "thirty",
            "thirdtyfirst" };
    public static final String[] monthStrFull = new String[] { "january", "february", "march", "april", "may", "june",
            "july", "august", "september", "october", "november", "december" };
    public static final String[] monthStr3 = new String[] { "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug",
            "sep", "oct", "nov", "dec" };
    public int day = 0;
    public int month = 0;
    public int year = 0;

    public MyDate(int day, int month, int year) {
        super();
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public MyDate(String day, int month, int year) {
        super();
        int index = java.util.Arrays.asList(MyDate.dayStr).indexOf(day.toLowerCase());
        if (index == -1)
            throw null;
        this.day = index + 1;
        this.month = month;
        this.year = year;
    }

    public MyDate(int day, String month, int year) {
        super();
        int index = java.util.Arrays.asList(MyDate.monthStrFull).indexOf(month.toLowerCase())
                + java.util.Arrays.asList(MyDate.monthStr3).indexOf(month.toLowerCase()) + 1;
        if (index == -1)
            throw null;
        this.day = day;
        this.month = index + 1;
        this.year = year;
    }

    public MyDate(String day, String month, int year) {
        super();
        int indexd = java.util.Arrays.asList(MyDate.dayStr).indexOf(day.toLowerCase());
        if (indexd == -1)
            throw null;
        int indexm = java.util.Arrays.asList(MyDate.monthStrFull).indexOf(month.toLowerCase())
                + java.util.Arrays.asList(MyDate.monthStr3).indexOf(month.toLowerCase()) + 1;
        if (indexm == -1)
            throw null;
        this.day = indexd + 1;
        this.month = indexm + 1;
        this.year = year;
    }

    public void print() {
        // int month = this.month;
        String[] monthStr = new String[] { "January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December" };
        String curMonth = monthStr[this.month - 1];
        String postFix = "th";
        if (this.day % 10 == 1 & this.day != 11)
            postFix = "st";
        else if (this.day % 10 == 2 & this.day != 12)
            postFix = "nd";
        else if (this.day % 10 == 3)
            postFix = "rd";
        System.out.println(curMonth + " " + this.day + postFix + " " + this.year);
    }

    private boolean isAlpha(char c) {
        return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
    }

    public void printWithFormat(String form) {
        int i, j, index1 = -1, index2 = -1;
        String filledForm = form.toLowerCase();
        int monthPos = filledForm.indexOf('m');
        int dayPos = filledForm.indexOf('d');
        int yearPos = filledForm.indexOf('y');
        String[] monthStr = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
        int monLen, dayLen, yearLen;
        int[] order = { 0, 0, 0 };
        String printLine = "";
        for (i = 0; i < form.length(); i++) {
            if (!isAlpha(form.charAt(i))) {
                index1 = i;
                break;
            }
        }
        for (j = i + 1; j < form.length(); j++) {
            if (!isAlpha(form.charAt(j))) {
                index2 = j;
                break;
            }
        }
        if (index1 == -1 || index2 == -1 || monthPos == -1 || dayPos == -1 || yearPos == -1) {
            System.out.println("Wrong format");
            return;
        }
        // dd/mm/yyyy = 0, 1, 2
        // System.out.println(index1 + " " + index2);
        // System.out.print(index1 + " " + index2 + " " + monthPos + " " + dayPos + " "
        // + yearPos); // correct
        if (dayPos < index1) { // 5 < 4
            dayLen = index1;
            order[0] = 0;
        } else if (dayPos < index2) { // 5 < 6 , correct
            dayLen = index2 - index1 - 1;
            order[1] = 0;
        } else {
            dayLen = form.length() - index2 - 1;
            order[2] = 0;
        }
        ///////////
        if (monthPos < index1) {
            monLen = index1;
            order[0] = 1;
        } else if (monthPos < index2) {
            monLen = index2 - index1 - 1;
            order[1] = 1;
        } else {
            monLen = form.length() - index2 - 1;
            order[2] = 1;
        }
        /////////////
        if (yearPos < index1) {
            yearLen = index1;
            order[0] = 2;
        } else if (yearPos < index2) {
            yearLen = index2 - index1 - 1;
            order[1] = 2;
        } else {
            yearLen = form.length() - index2 - 1;
            order[2] = 2;
        }
        ///////////
        for (i = 0; i < 3; i++) {
            // System.out.print(order[i]);
            if (order[i] == 0) {
                // print day
                if (dayLen == 2 && this.day < 10) {
                    printLine = printLine.concat("0" + new Integer(this.day).toString());
                } else {
                    printLine = printLine.concat(new Integer(this.day).toString());
                }
            } else if (order[i] == 1) {
                // print month
                if (monLen == 3) {
                    printLine = printLine.concat(monthStr[this.month - 1]);
                } else if (monLen == 2 && this.month < 10) {
                    printLine = printLine.concat("0" + new Integer(this.month).toString());
                } else {
                    printLine = printLine.concat(new Integer(this.month).toString());
                }
            } else {
                // print year
                if (yearLen == 4) {
                    printLine = printLine.concat(new Integer(this.year).toString());
                } else {
                    printLine = printLine.concat(new Integer(this.year % 100).toString());
                }
            }
            if (i == 0)
                printLine = printLine.concat(new Character(form.charAt(index1)).toString());
            else if (i == 1)
                printLine = printLine.concat(new Character(form.charAt(index2)).toString());
        }
        System.out.println(printLine);
    }

    public void main(String[] args) {
    }

}