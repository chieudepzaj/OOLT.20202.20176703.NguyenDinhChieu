
import javax.swing.JOptionPane;
public class Assignment225 {
	public static void main(String[] args) {
		String Sa,Sb;
		double result1,result2,result3,result4;
		Sa = JOptionPane.showInputDialog(null,"Number 1 : ","Enter the first number",JOptionPane.INFORMATION_MESSAGE);
		Sb = JOptionPane.showInputDialog(null,"Number 2 : ","Enter the second number",JOptionPane.INFORMATION_MESSAGE);
		double a = Double.parseDouble(Sa);
		double b = Double.parseDouble(Sb);
		result1 = a + b;
		result2 = a - b;
		result3 = a*b;
		if(b!=0)
		{
		result4 = a/b;
		JOptionPane.showMessageDialog(null,"a + b = "+ result1 +"\na - b = " + result2 +"\na * b = " + result3 +"\na / b = " + result4,"Result",JOptionPane.INFORMATION_MESSAGE);}
		else JOptionPane.showMessageDialog(null,"a + b = "+ result1 +"\na - b = " + result2 +"\na * b = " + result3,"Result",JOptionPane.INFORMATION_MESSAGE);
	}
}
