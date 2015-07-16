import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;

class SubmitStudent extends JPanel implements ActionListener
{	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	JButton b1,b2,b3;
	Connection con;
	PreparedStatement pstmt;
	ResultSet res;
	Keycalling kb;
	
	public SubmitStudent()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","lms","lms");
		}
		catch(SQLException s)
		{
			s.printStackTrace();
		}
		
		setSize(600,600);
		setLayout(new GridBagLayout());
		
		kb=new Keycalling();

		l1=new JLabel("Roll no:");
		l2=new JLabel("Name:");
		l3=new JLabel("Book Serial No:");
		l4=new JLabel("Book Name");
		l5=new JLabel("Book Author");
		l6=new JLabel("Issue Date");
		l7=new JLabel("Submit Date");
		
		tf1=new JTextField();
		tf1.addKeyListener(kb);
		
		tf2=new JTextField();
		tf2.setEditable(false);
		tf3=new JTextField();
		tf3.setEditable(false);
		tf4=new JTextField();
		tf4.setEditable(false);
		tf5=new JTextField();
		tf5.setEditable(false);
		tf6=new JTextField();
		tf6.setEditable(false);
		tf7=new JTextField();
		tf7.setEditable(false);
		tf7.setText(new IssueStudent().date());
		
		b1=new JButton("SUBMIT");
		b1.addActionListener(this);
		b2=new JButton("CLEAR");
		b2.addActionListener(this);
		b3=new JButton("CLOSE");
		b3.addActionListener(this);
				
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridx=2;
		gbc.gridy=1;
		gbc.ipadx=0;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		add(l1,gbc);		

		gbc=new GridBagConstraints();
		gbc.gridx=3;
		gbc.gridy=1;
		gbc.ipadx=300;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.gridwidth=2;
		gbc.anchor=GridBagConstraints.WEST;
		add(tf1,gbc);

		gbc=new GridBagConstraints();
		gbc.gridx=2;
		gbc.gridy=2;
		gbc.ipadx=0;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		add(l2,gbc);		
	
		gbc=new GridBagConstraints();
		gbc.gridx=3;
		gbc.gridy=2;
		gbc.ipadx=300;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.gridwidth=2;
		gbc.anchor=GridBagConstraints.WEST;
		add(tf2,gbc);
		
		gbc=new GridBagConstraints();
		gbc.gridx=2;
		gbc.gridy=3;
		gbc.ipadx=0;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		add(l3,gbc);		
	
		gbc=new GridBagConstraints();
		gbc.gridx=3;
		gbc.gridy=3;
		gbc.ipadx=300;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.gridwidth=2;
		gbc.anchor=GridBagConstraints.WEST;
		add(tf3,gbc);

		gbc=new GridBagConstraints();
		gbc.gridx=2;
		gbc.gridy=4;
		gbc.ipadx=0;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		add(l4,gbc);		
	
		gbc=new GridBagConstraints();
		gbc.gridx=3;
		gbc.gridy=4;
		gbc.ipadx=300;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.gridwidth=2;
		gbc.anchor=GridBagConstraints.WEST;
		add(tf4,gbc);

		gbc=new GridBagConstraints();
		gbc.gridx=2;
		gbc.gridy=5;
		gbc.ipadx=0;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		add(l5,gbc);		
	
		gbc=new GridBagConstraints();
		gbc.gridx=3;
		gbc.gridy=5;
		gbc.ipadx=300;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.gridwidth=2;
		gbc.anchor=GridBagConstraints.WEST;
		add(tf5,gbc);

		gbc=new GridBagConstraints();
		gbc.gridx=2;
		gbc.gridy=6;
		gbc.ipadx=0;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		add(l6,gbc);		
	
		gbc=new GridBagConstraints();
		gbc.gridx=3;
		gbc.gridy=6;
		gbc.ipadx=300;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.gridwidth=2;
		gbc.anchor=GridBagConstraints.WEST;
		add(tf6,gbc);

		gbc=new GridBagConstraints();
		gbc.gridx=2;
		gbc.gridy=7;
		gbc.ipadx=0;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		add(l7,gbc);		
	
		gbc=new GridBagConstraints();
		gbc.gridx=3;
		gbc.gridy=7;
		gbc.ipadx=300;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.gridwidth=2;
		gbc.anchor=GridBagConstraints.WEST;
		add(tf7,gbc);

		gbc=new GridBagConstraints();
		gbc.gridx=3;
		gbc.gridy=8;
		gbc.ipadx=0;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.anchor=GridBagConstraints.WEST;
		gbc.insets=new Insets(0,0,0,0);
		add(b1,gbc);

		gbc=new GridBagConstraints();
		gbc.gridx=3;
		gbc.gridy=8;
		gbc.ipadx=0;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.anchor=GridBagConstraints.CENTER;
		gbc.insets=new Insets(0,0,0,100);
		add(b2,gbc);

		gbc=new GridBagConstraints();
		gbc.gridx=3;
		gbc.gridy=8;
		gbc.ipadx=0;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.anchor=GridBagConstraints.EAST;
		gbc.insets=new Insets(0,0,0,100);
		add(b3,gbc);
	}
	public int change()
	{
		int d=0;
		try
		{
			int sd=Integer.parseInt(tf3.getText());
			String hh="select * from BOOKS where S_NO=?";
			pstmt=con.prepareStatement(hh);
			pstmt.setInt(1,sd);
			ResultSet res=pstmt.executeQuery();
			while(res.next())
			{
				int i=res.getInt("AVAILABLE_BOOKS");
				d=i+1;
			}
		}
		catch(SQLException s)
		{
			s.printStackTrace();
		}
		return d;
	}
	public void actionPerformed(ActionEvent ee)
	{
		if(ee.getSource()==b1)
		{
					String zz=null;
			try
			{
					String y=tf1.getText();
					String qq="select * from ISSUESTUDENT where ROLLNUMBER=?";
					pstmt=con.prepareStatement(qq);
					pstmt.setInt(1,Integer.parseInt(y));
					ResultSet res=pstmt.executeQuery();  
					while(res.next())
					{
						zz=res.getString("SUBMITDATE");
					}
					
					if(zz==null)
					{
						String ww=tf7.getText();
						String hh=tf1.getText();
						String tt=tf3.getText();
						String query="update ISSUESTUDENT SET SUBMITDATE=? where ROLLNUMBER=? AND BOOKSERIALNUMBER=?";
						pstmt=con.prepareStatement(query);
						pstmt.setString(1,ww);
						pstmt.setString(2,hh);
						pstmt.setString(3,tt);
						int count=pstmt.executeUpdate();
						
						int sq=Integer.parseInt(tf3.getText());
						String ii="update BOOKS SET AVAILABLE_BOOKS=? where S_NO=?";
					    PreparedStatement pt=con.prepareStatement(ii);
						pt.setInt(1,change());
						pt.setInt(2,sq);
						int q=pt.executeUpdate();
						
						
						JOptionPane.showMessageDialog(this,"u hv submitd ur book succeccfully");
						
					}
					else
					{
						
						JOptionPane.showMessageDialog(this,"u hv submmtd ur book alrdy");
					}
		   }
		  catch(SQLException g)
		  {
		  	g.printStackTrace();
		  }
			
		}
		
		if(ee.getSource()==b2)
		{
			
		}
		
		if(ee.getSource()==b3)
		{
			
		}
	}
	public void calling()
	{
		String gh1=null,gh2=null,gh3=null,gh4=null,gh11=null,gh22=null;
		int y;
		try
		{
		String dg1="select * from ISSUESTUDENT where ROLLNUMBER=?";
		pstmt=con.prepareStatement(dg1);
		pstmt.setInt(1,Integer.parseInt(tf1.getText()));
		res=pstmt.executeQuery();
		while(res.next())
		{
			gh1=res.getString("NAME");
			gh2=res.getString("ISSUEDATE");
			y=res.getInt("BOOKSERIALNUMBER");
			gh3=String.valueOf(y);
			//gh4=res.getString("SUBMITDATE");
			//System.out.println(gh4);
			//if(gh4.equalsIgnoreCase("null"))
			//{
				tf2.setText(gh1);
				tf3.setText(gh3);
				tf6.setText(gh2);
				
				String gh7="select * from BOOKS where S_NO=?";
				pstmt=con.prepareStatement(gh7);
				pstmt.setInt(1,y);
				res=pstmt.executeQuery();
				while(res.next())
				{
					gh11=res.getString("TITLE");
					gh22=res.getString("AUTHOR");
					
					tf4.setText(gh11);
					tf5.setText(gh22);
				}

			//}
		}
	}
	catch(SQLException ty)
	{
		ty.printStackTrace();
	}
	}
	class Keycalling extends KeyAdapter
	{
		public void keyReleased(KeyEvent ke)
		{
			int key=ke.getKeyCode();
			if(ke.getSource()==tf1)
			{
				if(key==KeyEvent.VK_ENTER)
				{
					calling();
				}
			}
		}
	}
}