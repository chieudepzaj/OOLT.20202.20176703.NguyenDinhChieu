
import java.util.Scanner;

public class MyDate {
    private int day;
    private int month;
    private int year;
    public int n,m,y;
    public String current_day;
    
    public String [] array = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    
    public void set_day(){
        this.day = n;
    }
    public void set_month(){
        this.month = m;
    }
    public void set_year(){
        this.year = y;
    }
    public int get_day(){
        return this.day;
    }
    public int get_month(){
        return this.month;
    }
    public int get_year(){
        return this.year;
    }
    public void accept(){
        Scanner key = new Scanner(System.in);
        current_day = key.nextLine();
        String[] splits = current_day.split("\\s+",3);
        for(int i = 0; i < 12; i++){
            if(splits[0].equals(array[i]) == true){
                m = i+1;
                break;
            }
        }
        n = Integer.parseInt(splits[1]);
        y = Integer.parseInt(splits[2]);
        set_day();
        set_month();
        set_year();
    }
    public void print(){
        System.out.println(get_month() + "/" + get_day() + "/" + get_year());
    }
}
