///
public class DateUtils{
    public static void main(String[] args) {

    }
    public static int DateCompare(MyDate date1, MyDate date2) {  // 1 if date1 > date2, -1 if date1 < date2, 0 if equal
        if (date1.year > date2.year) {
            return 1;
        } else if (date1.year < date2.year) {
            return -1;
        } else {
            if (date1.month > date2.month) {
                return 1;
            } else if (date1.month < date2.month) {
                return -1;
            } else {
                if (date1.day > date2.day) {
                    return 1;
                } else if (date1.day < date2.day) {
                    return -1;
                }
            }
        }
        return 0;
    }
    public MyDate[] SortDate(MyDate[] dateArray) {
        int i, j;
        int len = dateArray.length;
        MyDate date1, date2;
        for (i = 0; i < len; i++) { // 0 ... j ... i ... n
            for (j = 0; j < i; j++){
                date1 = dateArray[i]; 
                date2 = dateArray[j]; // 0 .... d2 .... d1 .... n
                if (date1.year < date2.year){
                    // swap 
                    dateArray[i] = date2;
                    dateArray[j] = date1;
                } else if (date1.year == date2.year) {
                    if (date1.month < date2.month) {
                        // swap
                        dateArray[i] = date2;
                        dateArray[j] = date1;
                    } else if (date1.month == date2.month) {
                        if (date1.day < date2.day) {
                            // swap
                            dateArray[i] = date2;
                            dateArray[j] = date1;
                        }
                    }
                }
            }
        }
        return dateArray;
    }
}