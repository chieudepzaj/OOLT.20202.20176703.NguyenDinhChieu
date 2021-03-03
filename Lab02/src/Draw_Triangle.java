import java.util.Scanner;
public class Draw_Triangle{
public static void main(String args[]){ 
	int i,j,n,k;
	Scanner Sn = new Scanner(System.in);
    System.out.println("Enter the height of triangle : ");
    n = Sn.nextInt();
    for(i=1;i<=n;i++){
         for(j=i;j<=n;j++)
         {
             System.out.print(" ");
         }
         for(j=1;j<=i;j++)
         {
             System.out.print("*");
         }
         for(k=1;k<=i-1;k++) {
        	 System.out.print("*");
         }
         System.out.println("");
     } 
 }
}