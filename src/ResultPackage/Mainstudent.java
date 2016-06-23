package ResultPackage;
import StudentPackage.*;
import java.util.Scanner;

public class Mainstudent {
	public static void main(String args[])throws NumberFormatException
	{
		Scanner sn=new Scanner(System.in);
		System.out.println("enter number of credits to register for current semester:");
		int cr=sn.nextInt();
		System.out.println("enter number of semesters cleared: ");
		int n=sn.nextInt();
		System.out.println("enter sgpa of all semesters cleared");
		float s[]=new float[n];
		for(int i=0; i<n; i++)
			s[i]=sn.nextInt();
		Grade stud=new Grade(cr,s,n);
		System.out.println("Student name: "+stud.name+" and branch: "+stud.branch);
		stud.register();
		stud.checkCGPA();
	}
}
