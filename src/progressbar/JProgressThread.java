package progressbar;
import javax.swing.*;
import java.io.*;
import java.util.*;
public class JProgressThread extends Thread{

	JTextField from,to;
	JProgressBar jp;
	boolean cancel;
	JProgressThread(JTextField t1,JTextField t2,JProgressBar j)
	{
		from=t1;
		to=t2;
		jp=j;
		cancel=false;
	}
	public void run()
	{
		BufferedInputStream in=null;
		BufferedOutputStream out=null;
		try
		{
		in=new BufferedInputStream(new FileInputStream(from.getText().trim()));
		out=new BufferedOutputStream(new FileOutputStream(to.getText().trim()));
		long size=in.available();
		byte buff[]=new byte[5];
		int r;
		long readbyte=0;
		jp.setValue(0);
		jp.setMinimum(0);
		jp.setMaximum(100);
		int prog;
		while((r=in.read(buff,0,buff.length))!=-1 )
		{
			readbyte+=r;
			prog=(int)(readbyte*100/size);
			jp.setValue(prog);
			out.write(buff,0,r);
			if (cancel) break;
		}
		
		}
		catch(FileNotFoundException fe)
		{
			System.out.println("File not found "+fe);
		}	
		catch(IOException ie)
		{
			System.out.println("Error in transfering of file contents");
		}
		finally{
			try{
				in.close();
				out.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}

}