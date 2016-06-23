import javax.swing.*;
import java.awt.event.*;
class prac extends JFrame implements ActionListener
{
	JLabel j1,j2;
	JTextField t;
	JComboBox c;
	JButton b;
	prac()
	{
		super("Prime number");
		j1=new JLabel("enter number");
		j2=new JLabel("Prime_Number");
		t=new JTextField(10);
		c=new JComboBox();
		b=new JButton("click");
		JPanel jp=new JPanel();
		jp.add(j1);
		jp.add(t);
		jp.add(j2);
		jp.add(c);
		jp.add(b);
		b.addActionListener(this);
		setContentPane(jp);
	}
	public void actionPerformed(ActionEvent ae)
	{
		c.removeAllItems();
		if(ae.getSource()==b)
		{
			int count=Integer.parseInt(t.getText());
			int n=1;
			while(count>0)
			{
				int temp=0;
				for(int i=1; i<=n; i++)
					if(n%i==0)
						temp++;
				if(temp==2)
				{
					count--;
					c.addItem(String.valueOf(n));
				}
				n++;
			}
		}
	}
	public static void main(String args[])
	{
		prac p=new prac();
		p.setSize(200,200);
		p.setVisible(true);
		WindowListener win=new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				//JOptionPane.showInternalMessageDialog(p, "u are exiting from frame");
				System.exit(0);	
			}
		};
		p.addWindowListener(win);
	}
}
