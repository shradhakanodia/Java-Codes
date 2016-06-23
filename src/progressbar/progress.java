package progressbar;
import java.awt.Container;
import java.awt.event.*;
import java.awt.BorderLayout;
import javax.swing.*;
public class progress extends JFrame implements ActionListener{
	JLabel j1,j2;
	JTextField t1,t2;
	JButton start,stop;
	JProgressBar jp=new JProgressBar();
	JProgressThread thread;
    progress()
    {
        super("File transfer");
        Container pane=getContentPane();
        pane.add(jp,BorderLayout.SOUTH);
        j1=new JLabel("From file");
        j2=new JLabel("To file");
        t1=new JTextField(20);
        t2=new JTextField(20);   
        jp.setStringPainted(true);
        JPanel pane1=new JPanel();
        pane1.add(j1);
        pane1.add(t1);
        pane1.add(j2);
        pane1.add(t2);
        start=new JButton("start");
        stop=new JButton("stop");
        pane1.add(start);
        pane1.add(stop);
        pane.add(pane1);
        //pane.add(pane2);
        //pane.add(pane3);
        start.addActionListener(this);
        stop.addActionListener(this);
        stop.setEnabled(false);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==start)
        {
           thread=new JProgressThread(t1,t2,jp);
           thread.start();
           start.setEnabled(false);
           stop.setEnabled(true);
        }
        else if(ae.getSource()==stop)
        {
        	thread.cancel=true;
            stop.setEnabled(false);
        }
    }
    public static void main(String[] args) {
    	progress pob=new progress();
    	pob.setSize(300,300);
    	pob.setVisible(true);
    	WindowListener win=new WindowAdapter()
    	{
    		public void windowClosing(WindowEvent we)
    		{
    			System.exit(0);
    		}
   		};
    	pob.addWindowListener(win);
    }

}