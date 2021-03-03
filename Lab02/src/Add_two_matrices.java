
public class Add_two_matrices{
public static void main(String args[]){
//create two matrices  
	int a[][]={{5,2,6},{6,3,1},{1,2,3}};  
	int b[][]={{2,2,3},{1,5,3},{2,3,6}};  
  
//create a matrix to store the sum of two matrices  
	int c[][]=new int[3][3];  
//add and print 
	System.out.println("Result:");
	for(int i=0;i<3;i++){  
		for(int j=0;j<3;j++){  
			c[i][j]=a[i][j]+b[i][j]; 
			System.out.print(c[i][j]+" ");  
}  
		System.out.println("");
}  
}}
