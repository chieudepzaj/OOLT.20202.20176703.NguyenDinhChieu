import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
public class Array_Sort_And_Calculate {
public static void main(String[] args) {
//create a random array have 1000 elements
	java.util.List<Integer> arrayList = new ArrayList();

    for(int i = 0; i < 1000; i++){
        arrayList.add(i + 1);
    }

    java.util.Collections.shuffle(arrayList);
//create a array for user enter
   int n=0;
   String auto = "$";
   do {
	   String Sn = JOptionPane.showInputDialog(null,"Enter number of array elements: ");
	   n = Integer.parseInt(Sn);
   } while (n<=0 || n>=1000); 
    int[] array = new int[n];
    for(int i=0;i<n;i++)
    {
    String Sa = JOptionPane.showInputDialog(null,"Enter Array["+(i+1)+"]: ");
    if(Sa.compareTo(auto)==0)
    {
    	array[i] = arrayList.get(i);
    	continue;
    }
    int a = Integer.parseInt(Sa);
    array[i] = a;
    }
//sort array
    Arrays.sort(array);
    JOptionPane.showMessageDialog(null,"Sorted array[ ] : "+ Arrays.toString(array));
//calculate sum and average of array
    int sum=0;
    double ave=0;
    for(int i=0;i<n;i++)
    {
    	sum +=array[i];
    }
    ave = (double) sum/n;
    JOptionPane.showMessageDialog(null,"Sum of array: "+ sum+".\nAverage of array: "+ave +".");
    System.exit(0);
}
}
