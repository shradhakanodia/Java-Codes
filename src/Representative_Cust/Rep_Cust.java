package Representative_Cust;
import javax.swing.*;
import java.sql.*;
import java.awt.Container;
import java.awt.event.*;
public class Rep_Cust extends JFrame{
Rep_Cust()throws ClassNotFoundException,SQLException
{
    super("Representative and Customer Information Forum");
    Container pane=getContentPane();
    JPanel pane1=new JPanel();
    JLabel l1=new JLabel("<html></br>Representative no</html>");
    JTextField rno=new JTextField(10);
    JLabel l2=new JLabel("<html></br>Representative name</html>");
    JTextField rname=new JTextField(10);
    JLabel l3=new JLabel("<html></br>Commission</html>");
    JTextField comm=new JTextField(10);
    JLabel l4=new JLabel("<html></br>State</html>");
    JTextField state=new JTextField(10);
    JLabel l5=new JLabel("<html></br>Rate</html>");
    JTextField rate=new JTextField(10);
    pane1.add(l1);pane1.add(rno);
    pane1.add(l2);pane1.add(rname);
    pane1.add(l3);pane1.add(comm);
    pane1.add(l4);pane1.add(state);
    pane1.add(l5);pane1.add(rate);
    JButton b1=new JButton("<html></br>submit form1</html>");
    pane1.add(b1);
    JLabel l6=new JLabel("<html></br>Customer no</html>");
    JTextField cid=new JTextField(10);
    JLabel l7=new JLabel("<html></br>Customer name</html>");
     JTextField cname=new JTextField(10);
    JLabel l8=new JLabel("<html></br>Customer State</html>");
     JTextField cstate=new JTextField(10);
    JLabel l9=new JLabel("<html></br>Credit limit</html>");
     JTextField climit=new JTextField(10);
    JLabel l10=new JLabel("<html></br>Reprentative no</html>");
     JTextField crp=new JTextField(10);
    pane1.add(l6);pane1.add(cid);
    pane1.add(l7);pane1.add(cname);
    pane1.add(l8);pane1.add(cstate);
    pane1.add(l9);pane1.add(climit);
    pane1.add(l10);pane1.add(crp);
    JButton b2=new JButton("<html><br/>Submit</html>");
    pane1.add(b2);
    pane.add(pane1);
    
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Rep_Cust","root","");
    if(conn==null)
        System.exit(1);
    Statement stat=conn.createStatement();
    
    b1.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
        	
            try {
            	String query="insert into Rep values ("+Integer.parseInt(rno.getText().trim())+",'"+rname.getText()+"','"+state.getText()+"','"+comm.getText()+"','"+rate.getText()+"')";
                stat.executeUpdate(query);
            }
            catch (Exception e) {
                //e.printStackTrace();
                System.out.println(e);
            }
        }
    });
   b2.addActionListener(new ActionListener()
   {
	   public void actionPerformed(ActionEvent ae)
	   {

		   try {
	      	 String query="insert into Cust values ("+Integer.parseInt(cid.getText().trim())+",'"+cname.getText()+"','"+cstate.getText()+"','"+climit.getText()+"',"+Integer.parseInt(crp.getText().trim())+")";
	          int rows=stat.executeUpdate(query);
	      }
	      catch (Exception e) {
	          e.printStackTrace();
	      }
	   }
   });
   
   JLabel form3=new JLabel("<html><br/>Representative Information with credit limit>15000:</html>");
   try{
	   String query="SELECT Rep.name,Rep.RepNo,Rep.state,Rep.commission,Rep.rate FROM Cust, Rep where Rep.RepNo=Cust.repno and creditlimit='20000'";
	   ResultSet rs=stat.executeQuery(query);
	   JTextArea info=new JTextArea(5,60);
	   while(rs.next())
	   {   
		   info.setEditable(false);
		   info.append("Name: "+rs.getString("name"));
		   info.append("Representative no: "+rs.getInt("RepNo"));
		   info.append("State: "+rs.getString("state"));
		   info.append("Commission: "+rs.getString("commission"));
		   info.append("Rate: "+rs.getString("rate"));
	   }
	   pane1.add(info);
   }
   catch(Exception e)
   {
	   System.out.println(e);
   }
   
   
}
public static void main(String args[]) throws ClassNotFoundException, SQLException
{
    Rep_Cust rc=new Rep_Cust();
    rc.setSize(1000,1000);
    rc.setVisible(true);
    WindowListener win=new WindowAdapter()
    {
        public void windowClosing()
        {
         System.exit(0);
        }
    };
    rc.addWindowListener(win);
}
}