package ColorPackage;

import java.util.Scanner;

public class Partywear extends PullOver{
String cost;
Scanner sn=new Scanner(System.in);
Partywear()
{
	super();
}
public void getColor()throws NumberFormatException
{
     super.getColor();
	 System.out.println("enter cost of Partywear");
	 String c=sn.next();
	 cost=c;
}
public void putcolor()throws NumberFormatException
{
	 super.putcolor();
	 System.out.println(" cost of partywear: "+cost);
}
}
