import java.util.Scanner;
public class SThread extends Thread{

	SThread()
	{
		start();
	}
	public void run()
	{
		String str;
		System.out.println("enter a string\n");
	    Scanner sn=new Scanner(System.in);
		str=sn.next();
		int nv=0;
		char vowel[]={'a','e','i','o','u','A','E','I','O','U'};
		for(int i=0; i<str.length(); i++)
		{
			for(int j=0; j<vowel.length; j++)
			{
				if(str.charAt(i)==vowel[j])
				{
					nv++;
				}
			}
		}
		System.out.println("no of vowels: "+nv);
	}
}
