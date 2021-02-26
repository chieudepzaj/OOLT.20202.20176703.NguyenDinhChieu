import javax.swing.JOptionPane;
public class Assignment226 {
public static void main(String[] args) {
	double result,a,b;
	String Sk = JOptionPane.showInputDialog(null,"1.ax + b = 0 (a≠0)\n2.a11x1 + a12x2 = b1\n   a21x1 + a22x2 = b2\n3.ax^2 + bx + c = 0");
	double k = Double.parseDouble(Sk);
	if(k == 1)
	{
		do {
		String Sa = JOptionPane.showInputDialog(null,"a = ");
		a = Double.parseDouble(Sa);
		} while (a == 0);
		String Sb = JOptionPane.showInputDialog(null,"b = ");
		b = Double.parseDouble(Sb);
		result = -b/a;
		JOptionPane.showMessageDialog(null,"the equation has a unique solution x = "+ result);

	}
	else if(k == 2) {
		//input
		String Sa11 = JOptionPane.showInputDialog(null,"a11 = ");
		double a11 = Double.parseDouble(Sa11);
		String Sa12 = JOptionPane.showInputDialog(null,"a12 = ");
		double a12 = Double.parseDouble(Sa12);
		String Sb1 = JOptionPane.showInputDialog(null,"b1 = ");
		double b1 = Double.parseDouble(Sb1);
		String Sa21 = JOptionPane.showInputDialog(null,"a21 = ");
		double a21 = Double.parseDouble(Sa21);
		String Sa22 = JOptionPane.showInputDialog(null,"a22 = ");
		double a22 = Double.parseDouble(Sa22);
		String Sb2 = JOptionPane.showInputDialog(null,"b21r = ");
		double b2 = Double.parseDouble(Sb2);
		//solution
		double D = a11*a22 - a12*a21;
		double D1 = b1*a22 - b2*a12;
		double D2 = a11*b2 - a21*b1;
		// D!= 0
		if(D!=0) {
		double x1 = D1/D;
		double x2 = D2/D;
		JOptionPane.showMessageDialog(null,"the system has a unique solution (x1,x2) = (" + x1 + "," + x2 + ")");
		}
		else {
			if (D == 0 && D1 == 0 && D2 == 0)
				JOptionPane.showMessageDialog(null,"the system has infinitely many solutions!");
			else 
				JOptionPane.showMessageDialog(null,"the system has no solution !!!");
		}
	}
	else if(k == 3) {
		// input
		String Sa = JOptionPane.showInputDialog(null,"a = ");
		a = Double.parseDouble(Sa);
		String Sb = JOptionPane.showInputDialog(null,"b = ");
		b = Double.parseDouble(Sb);	
		String Sc = JOptionPane.showInputDialog(null,"c = ");
		double c = Double.parseDouble(Sc);
		//solution
		double delta = b*b - 4*a*c;
		if(a==0)
		{
			result = -c/b;
			JOptionPane.showMessageDialog(null,"the equation has a unique solution x = " + result);
		}
		else {
			if(delta == 0) {
				result = -b/(2*a);
				JOptionPane.showMessageDialog(null,"the equation has double root x = " + result);
			}
			else if(delta > 0){
				double x1 = (-b + Math.sqrt(delta) )/(2*a);
				double x2 = (-b - Math.sqrt(delta) )/(2*a); 
				JOptionPane.showMessageDialog(null,"the equation has two distinct roots x1 = " + x1 + " and x2 = " + x2);
			}
			else if(delta < 0)
				JOptionPane.showMessageDialog(null,"the equation has no solution.");
			
		}
		
	}
}
}
