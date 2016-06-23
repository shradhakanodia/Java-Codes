package Account;
import java.util.*;
public class Myaccount {
String name;
int accno,phno;
float bal;
static Scanner sn=new Scanner(System.in);
void getinput()throws NumberFormatException
{
	System.out.println("enter name, phone no, account no, initial balance of Account");
	name=sn.next();
	accno=sn.nextInt();
	phno=sn.nextInt();
	bal=sn.nextFloat();
}
void deposit(float amt)
{
	bal+=amt;
	System.out.println("total balance in account: "+bal);
}
void withdraw(float amt)
{
	if(amt<=bal)
	{
		bal-=amt;
		System.out.println("remaining amount in account: "+bal);
	}
	else
		System.out.println("amount in account: "+bal);
}
public static void main(String args[])throws NumberFormatException
{
	Myaccount obj=new Myaccount();
	obj.getinput();
	float amt;
	while(true)
	{
		int ch;
		System.out.println("Enter your choice: 1)deposit 2)withdraw 3)view balance");
		ch=sn.nextInt();
		switch(ch)
		{
		case 1:
			System.out.println("enter amount to be deposited\n");
			amt=sn.nextFloat();
			obj.deposit(amt); break;
		case 2:
			System.out.println("enter amount to be withdrawn\n");
			amt=sn.nextFloat();
			obj.withdraw(amt); break;
		case 3:
			System.out.println("Balance in ur account: "+obj.bal);
		default: System.exit(0);
				
		}
	}
}
}
