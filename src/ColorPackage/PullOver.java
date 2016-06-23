package ColorPackage;
import java.util.*;
public class PullOver extends Color{
	Scanner sn=new Scanner(System.in);
	PullOver()
	{
		super();
	}
	 public void getColor()throws NumberFormatException
	 {
		 System.out.println("enter color and brand of pullover");
		 String c=sn.next();
		 String b=sn.next();
		 color=c;
		 brand=b;
	 }
	 public void putcolor()throws NumberFormatException
	 {
		 System.out.println("Pullover color: "+color+" and brand: "+brand);
	 }
}
