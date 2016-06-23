package SwingPrime;
import java.awt.event.*;
import javax.swing.*;
public class Prime extends JFrame  {
	JLabel l1,l2;
	JTextField t1;
	JComboBox c;
	JButton b1;
	Prime()
	{
		super("Prime Numbers");
		l1=new JLabel("Enter number:");
		l2=new JLabel("Prime_Numbers:");
		t1=new JTextField(10);
		c=new JComboBox();
		b1=new JButton("Click");
		JPanel jp=new JPanel();
		jp.add(l1);
		jp.add(t1);
		jp.add(l2);
		jp.add(c);
		jp.add(b1);
		setContentPane(jp);
		JOptionPane.showMessageDialog(this,"Prime Numbers");
		b1.addActionListener(new ActionListener()
			{
			@Override
			  public void actionPerformed(ActionEvent ae)
			  {
				  c.removeAllItems();
				  int count=Integer.parseInt(t1.getText());
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
			});
	}
	public static void main(String[] args) {
		Prime pm=new Prime();
		pm.setSize(200,200);
		pm.setVisible(true);
		WindowListener win=new WindowAdapter()
		{
			public void windowClosing()
			{
				System.exit(0);
			}
		};
		pm.addWindowListener(win);
	}

}
