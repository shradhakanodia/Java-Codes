package Telephone;

import java.util.*;

public class CallLog {
public static void main(String args[])
{
	HashMap<String,String> hm=new HashMap<>();
	hm.put("7829727141","Shradha");
	hm.put("9651052343","Akanchha");
	hm.put("8346354551","Pushpa");
	hm.put("8477548551","Ranjana");
	hm.put("9878458844","Akansha");
	Calendar c=Calendar.getInstance();
	Scanner sn=new Scanner(System.in);
	int count=0;
	HashMap<Integer,Phone> mlist=new HashMap<>();
	while(true)
	{
		System.out.println("Enter your choice:");
		System.out.println("1)Add\n 2)Display or delete \n3)Display a given number");
		int ch=sn.nextInt();
		switch(ch)
		{
		case 1:
			if(count>=10)
				count=0;
			else
				count++;
			System.out.println("enter phone number");
			String ph=sn.next();
			int hr=c.get(Calendar.HOUR);
			int min=c.get(Calendar.MINUTE);
			int sec=c.get(Calendar.SECOND);
			String t=hr+":"+min+":"+sec;
			String n;
			if(hm.containsKey(ph.toLowerCase()))
				n=hm.get(ph.toLowerCase());
			else
				n="private";
			mlist.put(count,new Phone(n,t,ph));
			break;
		case 2:
			System.out.println("enter 1)display all 2)delete all");
			int c2=sn.nextInt();
			Iterator<Map.Entry<Integer,Phone>> it=mlist.entrySet().iterator();
			while(it.hasNext())
			{
				Map.Entry<Integer,Phone> me=it.next();
				System.out.println("Name: "+me.getValue().name+"  PhoneNo: "+me.getValue().phno+" time: "+me.getValue().time);
				if(c2==2)
					it.remove();
			}
			break;
		case 3:
			System.out.println("enter phone no:");
			String p=sn.next();
			Iterator<Map.Entry<Integer,Phone>> it2=mlist.entrySet().iterator();
			while(it2.hasNext())
			{
				Map.Entry<Integer,Phone> me=it2.next();
				if(me.getValue().phno.equals(p))
				System.out.println("Name: "+me.getValue().name+"  PhoneNo: "+me.getValue().phno+" time: "+me.getValue().time);
			}
			break;
		default:
			System.exit(0);	
		}
	}
}
}
