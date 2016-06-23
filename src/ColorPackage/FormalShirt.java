package ColorPackage;

import java.util.Scanner;

final public class FormalShirt extends Color{
	Scanner sn=new Scanner(System.in);
	FormalShirt()
	{
		super();
	}
	 public void getColor()throws NumberFormatException
	 {
		 System.out.println("enter color and brand of formalshirt: ");
		 String c=sn.next();
		 String b=sn.next();
		 color=c;
		 brand=b;
	 }
	 public void putcolor()throws NumberFormatException
	 {
		 System.out.println("FormalShirt color: "+color+" and brand: "+brand);
	 }
}
