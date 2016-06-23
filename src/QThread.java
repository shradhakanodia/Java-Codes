import java.util.*;
public class QThread extends Thread{

	QThread()
	{
		start();
	}
	public void run()
	{
		int num;
		System.out.println("enter 4 digit number\n");
	    Scanner sn=new Scanner(System.in);
		num=sn.nextInt();
		String digit[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
		while(num!=0)
		{
			int ldig=num%10;
			num=num/10;
			System.out.println(digit[ldig]+" ");
		}
	}
}
