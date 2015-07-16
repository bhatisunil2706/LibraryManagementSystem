import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class ChangePassword extends JPanel implements ActionListener
{	JLabel l1,l2,l3,l4;
	JTextField tf1,tf2,tf3,tf4;
	JPasswordField jpf1,jpf2,jpf3;
	JButton b1,b2;
	Connection con;
	PreparedStatement pstmt;
	ResultSet res;
	
	public ChangePassword()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("yyyyyyy");
			//e.printStackTrace();
		}
		try
		{
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","lms","lms");
		}
		catch(SQLException s)
		{
			System.out.println("tttttttttt");
			//s.printStackTrace();
		}
		
		setSize(600,600);
		setLayout(new GridBagLayout());
		
		l1=new JLabel("User ID:");
		l2=new JLabel("Old Password:");
		l3=new JLabel("New Password:");
		l4=new JLabel("Confirm Password:");
		tf1=new JTextField();
		
		jpf1=new JPasswordField();
		jpf2=new JPasswordField();
		jpf3=new JPasswordField();
		
		b1=new JButton("OK");
		b1.addActionListener(this);
		
		b2=new JButton("CANCEL");
		b2.addActionListener(this);
		
		GridBagConstraints gc=new GridBagConstraints();
		gc.gridx=2;
		gc.gridy=2;
		gc.ipadx=0;
		gc.ipady=0;
		gc.weightx=0.5;
		gc.weighty=0.5;
		gc.insets=new Insets(0,0,0,130);
		add(l1,gc);

		gc=new GridBagConstraints();
		gc.gridx=2;
		gc.gridy=3;
		gc.ipadx=300;
		gc.ipady=0;
		gc.weightx=0.5;
		gc.weighty=0.5;
		gc.insets=new Insets(0,130,0,0);
		add(tf1,gc);

		gc=new GridBagConstraints();
		gc.gridx=2;
		gc.gridy=4;
		gc.ipadx=0;
		gc.ipady=0;
		gc.weightx=0.5;
		gc.weighty=0.5;
		gc.insets=new Insets(0,0,0,100);
		add(l2,gc);

		gc=new GridBagConstraints();
		gc.gridx=2;
		gc.gridy=5;
		gc.ipadx=300;
		gc.ipady=0;
		gc.weightx=0.5;
		gc.weighty=0.5;
		gc.insets=new Insets(0,130,0,0);
		add(jpf1,gc);

		gc=new GridBagConstraints();
		gc.gridx=2;
		gc.gridy=6;
		gc.ipadx=0;
		gc.ipady=0;
		gc.weightx=0.5;
		gc.weighty=0.5;
		gc.insets=new Insets(0,0,0,100);
		add(l3,gc);

		gc=new GridBagConstraints();
		gc.gridx=2;
		gc.gridy=7;
		gc.ipadx=300;
		gc.ipady=0;
		gc.weightx=0.5;
		gc.weighty=0.5;
		gc.insets=new Insets(0,130,0,0);
		add(jpf2,gc);

		gc=new GridBagConstraints();
		gc.gridx=2;
		gc.gridy=8;
		gc.ipadx=0;
		gc.ipady=0;
		gc.weightx=0.5;
		gc.weighty=0.5;
		gc.insets=new Insets(0,0,0,80);
		add(l4,gc);

		gc=new GridBagConstraints();
		gc.gridx=2;
		gc.gridy=9;
		gc.ipadx=300;
		gc.ipady=0;
		gc.weightx=0.5;
		gc.weighty=0.5;
		gc.insets=new Insets(0,130,0,0);
		add(jpf3,gc);

		gc=new GridBagConstraints();
		gc.gridx=2;
		gc.gridy=10;
		gc.ipadx=20;
		gc.ipady=0;
		gc.weightx=0.5;
		gc.weighty=0.5;
		gc.insets=new Insets(0,0,0,80);
		add(b1,gc);
		
		gc=new GridBagConstraints();
		gc.gridx=2;
		gc.gridy=10;
		gc.ipadx=0;
		gc.ipady=0;
		gc.weightx=0.5;
		gc.weighty=0.5;
		gc.insets=new Insets(0,80,0,0);
		add(b2,gc);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try
			{	
				String str1=tf1.getText();
				char chr[]=jpf1.getPassword();
				String str2=String.valueOf(chr);
				
				char chr1[]=jpf2.getPassword();
				String str3=String.valueOf(chr1);
			
				String query1="select LOGIN_ID from Login";
				pstmt=con.prepareStatement(query1);
				res=pstmt.executeQuery();
				while(res.next())
				{
					String strr1=res.getString("LOGIN_ID");
					if(strr1.equalsIgnoreCase(str1))
					{
						String query2="update LOGIN SET PASSWORD=? where LOGIN_ID='admin'";
						pstmt=con.prepareStatement(query2);
						pstmt.setString(1,str3);
						//pstmt.setString(2,str1);
						int vb=pstmt.executeUpdate();
					}
				}
			}
			catch(SQLException pp)
			{
				System.out.println("mmmmm");
				//pp.printStackTrace();
			}
				
		}
		else if(ae.getSource()==b2)
		{
		}
		else
		{
		}
	}
}