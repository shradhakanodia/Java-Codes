package StudentPackage;
import java.util.*;
public class RegisterStudent implements Student{
int credit;
static Scanner sn=new Scanner(System.in);
public RegisterStudent(int cr)
{
	credit=cr;
}

public void register()
{
	try{
	if(credit>30)
		throw new CreditLimit("exceeded credit limit!");
	else
		System.out.println("succefully registered "+credit+" credits");
	}
	catch(CreditLimit cr)
	{
		System.out.println(cr);
	}
}
}
