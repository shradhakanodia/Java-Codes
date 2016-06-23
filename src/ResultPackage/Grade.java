package ResultPackage;
import java.util.*;
import StudentPackage.*;
public class Grade extends RegisterStudent{
	float sgpa[],cgpa;
	int nsem;
	public Grade(int cr,float sg[],int ns)
	{
		super(cr);
		nsem=ns;
		sgpa=new float[ns];
		for(int i=0; i<ns; i++)
			{
				sgpa[i]=sg[i];
				cgpa+=sgpa[i];
			}
		cgpa/=ns;
	}
	public void checkCGPA()throws NumberFormatException
	{
		try{
			if(cgpa>10)
				throw new InvalidCGPA("invalid cgpa");
			else
				System.out.println("cgpa is :"+cgpa);
		}
		catch(InvalidCGPA cg)
		{
			System.out.println(cg);
		}
	}
}
