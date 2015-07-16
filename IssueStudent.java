import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Date;
import java.text.SimpleDateFormat;

class IssueStudent extends JPanel implements ActionListener
{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7;
	JButton jb1,jb2,jb3;
	DefaultTableModel dtm1;
	Connection con;
	PreparedStatement pstmt;
	ResultSet res;
	JTable jtb;
	JScrollPane jsp;
	Keycalling kc;
	public IssueStudent()
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
		setLayout(new GridBagLayout());
		setSize(1350,800);
		kc=new Keycalling();

		jl1=new JLabel("Roll Number");
		jl2=new JLabel("Name");
		jl3=new JLabel("Book Serial Number");
		jl4=new JLabel("Subject");
		jl5=new JLabel("Book Name");
		jl6=new JLabel("Book Author");
		jl7=new JLabel("Issue Date");

		jtf1=new JTextField(20);
		jtf2=new JTextField(20);
		jtf3=new JTextField(20);
		jtf3.addKeyListener(kc);
		jtf4=new JTextField(20);
		jtf5=new JTextField(20);
		jtf6=new JTextField(20);
		jtf7=new JTextField(20);
		jtf7.setText(date());
		
		jtf4.setEditable(false);
		jtf5.setEditable(false);
		jtf6.setEditable(false);
		jtf7.setEditable(false);


		
		String col[]={"S_NO.","Subject","Title","Author","TotalBooks","Available"};
		dtm1=new DefaultTableModel(null,col);
		jtb=new JTable(dtm1);
		jtb.setPreferredScrollableViewportSize(new Dimension(400,400));	
		jsp=new JScrollPane(jtb);

		jb1=new JButton("ISSUE");
		jb1.addActionListener(this);
		jb2=new JButton("CLEAR");
		jb3=new JButton("CLOSE");

		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=10;
		gbc.anchor=GridBagConstraints.NORTH;
		gbc.insets=new Insets(80,0,0,450);
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.ipadx=0;
		gbc.ipady=0;
		add(jl1,gbc);
	
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=10;
		gbc.anchor=GridBagConstraints.NORTH;
		gbc.insets=new Insets(160,0,0,450);
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.ipadx=0;
		gbc.ipady=0;
		add(jl2,gbc);	
	
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=10;
		gbc.anchor=GridBagConstraints.NORTH;
		gbc.insets=new Insets(240,0,0,450);
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.ipadx=0;
		gbc.ipady=0;
		add(jl3,gbc);

		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=10;
		gbc.anchor=GridBagConstraints.NORTH;
		gbc.insets=new Insets(320,0,0,450);
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.ipadx=0;
		gbc.ipady=0;
		add(jl4,gbc);
		
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=10;
		gbc.anchor=GridBagConstraints.NORTH;
		gbc.insets=new Insets(400,0,0,450);
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.ipadx=0;
		gbc.ipady=0;
		add(jl5,gbc);
		
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=10;
		gbc.anchor=GridBagConstraints.NORTH;
		gbc.insets=new Insets(480,0,0,450);
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.ipadx=0;
		gbc.ipady=0;
		add(jl6,gbc);


		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=10;
		gbc.anchor=GridBagConstraints.NORTH;
		gbc.insets=new Insets(560,0,0,450);
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.ipadx=0;
		gbc.ipady=0;
		add(jl7,gbc);

		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=10;
		gbc.anchor=GridBagConstraints.NORTH;
		gbc.insets=new Insets(80,0,0,0);
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.ipadx=0;
		gbc.ipady=0;
		add(jtf1,gbc);

		
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=10;
		gbc.anchor=GridBagConstraints.NORTH;
		gbc.insets=new Insets(160,0,0,0);
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.ipadx=0;
		gbc.ipady=0;
		add(jtf2,gbc);

		
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=10;
		gbc.anchor=GridBagConstraints.NORTH;
		gbc.insets=new Insets(240,0,0,0);
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.ipadx=0;
		gbc.ipady=0;
		add(jtf3,gbc);

		
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=10;
		gbc.anchor=GridBagConstraints.NORTH;
		gbc.insets=new Insets(320,0,0,0);
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.ipadx=0;
		gbc.ipady=0;
		add(jtf4,gbc);

		
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=10;
		gbc.anchor=GridBagConstraints.NORTH;
		gbc.insets=new Insets(400,0,0,0);
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.ipadx=0;
		gbc.ipady=0;
		add(jtf5,gbc);

		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=10;
		gbc.anchor=GridBagConstraints.NORTH;
		gbc.insets=new Insets(480,0,0,0);
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.ipadx=0;
		gbc.ipady=0;
		add(jtf6,gbc);	
			
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=10;
		gbc.anchor=GridBagConstraints.NORTH;
		gbc.insets=new Insets(560,0,0,0);
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.ipadx=0;
		gbc.ipady=0;
		add(jtf7,gbc);	
		
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=10;
		gbc.anchor=GridBagConstraints.NORTH;
		gbc.insets=new Insets(20,800,0,10);
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.ipadx=0;
		gbc.ipady=0;
		add(jsp,gbc);

			
		
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=10;
		gbc.anchor=GridBagConstraints.CENTER;
		gbc.insets=new Insets(600,0,10,300);
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.ipadx=30;
		gbc.ipady=0;
		add(jb1,gbc);

		
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=10;
		gbc.anchor=GridBagConstraints.CENTER;
		gbc.insets=new Insets(600,0,10,50);
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.ipadx=30;
		gbc.ipady=0;
		add(jb2,gbc);	
		
		
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=10;
		gbc.anchor=GridBagConstraints.CENTER;
		gbc.insets=new Insets(600,230,10,0);
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.ipadx=30;
		gbc.ipady=0;
		add(jb3,gbc);
		
		//showbooks();				
	
	}
	public void actionPerformed(ActionEvent lp)
	{
		if(lp.getSource()==jb1)
		{
			totalbooks();
		}
	}
	public void showbooks()
	{
		
		int i=dtm1.getRowCount();
			while(i>0)
			{
				dtm1.removeRow(0);
				i--;
			}
		try
			{
			Statement stmt= con.createStatement();
			String strr="select * from BOOKS";
			ResultSet rs=stmt.executeQuery(strr);
			while(rs.next())
			{
				String []s = {rs.getInt("s_no")+"",rs.getString("subject"),rs.getString("title"),rs.getString("author"),rs.getInt("total_books")+"",rs.getInt("AVAILABLE_BOOKS")+""};
				dtm1.addRow(s);
			}
			}
			catch(SQLException ee)
			{
				ee.printStackTrace();
			}
	}
	public void calling()
	{
		try
		{
		String str1=null,str2=null,str3=null;
		String st="select * from Books where s_no=?";
		pstmt=con.prepareStatement(st);
		pstmt.setString(1,jtf3.getText());
		ResultSet res=pstmt.executeQuery();
		while(res.next())
		{	
			str1=res.getString("SUBJECT");
			str2=res.getString("TITLE");
			str3=res.getString("AUTHOR");
			
		}
		jtf4.setText(str1);
		jtf5.setText(str2);
		jtf6.setText(str3);
		}
		catch(SQLException w)
		{
			w.printStackTrace();
		}
	}
	class Keycalling extends KeyAdapter
	{
		public void keyReleased(KeyEvent ke)
		{
			int key=ke.getKeyCode();
			if(ke.getSource()==jtf3)
			{
				if(key==KeyEvent.VK_ENTER)
				{
					calling();
				}
			}
		}
	}
	public String date()
	{
		Date d=new Date();
		SimpleDateFormat sdm=new SimpleDateFormat("dd-MM-yyyy");
		String s5=sdm.format(d);
		return s5;
	
	}
	public void issuetable()
	{
		String str1=jtf1.getText();
		String str2=jtf2.getText();
		String str3=jtf3.getText();
		String str4=jtf7.getText();
		
		try
		{
			String str5="insert into ISSUESTUDENT values(?,?,?,?,?)";
			pstmt=con.prepareStatement(str5);
			pstmt.setInt(1,Integer.parseInt(str1));
			pstmt.setString(2,str2);
			pstmt.setInt(3,Integer.parseInt(str3));
			pstmt.setString(4,str4);
			pstmt.setString(5,null);
			int tt=pstmt.executeUpdate();
		}	
		catch(SQLException e)
		{
			e.printStackTrace();
		}
			
	}	
		public void totalbooks()
		{
			String str3=jtf3.getText();
			try
			{
				String str1="select * from BOOKS where S_NO=?";
				pstmt=con.prepareStatement(str1);
				pstmt.setInt(1,Integer.parseInt(str3));
				res=pstmt.executeQuery();
				while(res.next())
				{
					int i1=res.getInt("AVAILABLE_BOOKS");
					int i2=i1-1;
					if(i1>0)
					{
						
		     				String str31=null,str4=null;
		     				String hj=jtf1.getText();
		     				String str2="select * from ISSUESTUDENT where ROLLNUMBER=?";
		     				pstmt=con.prepareStatement(str2);
		        			pstmt.setInt(1,Integer.parseInt(hj));
		     				res=pstmt.executeQuery();
		     				if(res.next())
		     				{
		     		    		String str12=null;
		                		str3=res.getString("ISSUEDATE");
				        		str12=res.getString("SUBMITDATE");
				       			if(str12!=null)
						     	{
				        			String str5="update BOOKS set AVAILABLE_BOOKS=? where S_NO=?";
									pstmt=con.prepareStatement(str5);
									pstmt.setInt(1,i2);
									pstmt.setInt(2,Integer.parseInt(str3));
									int r=pstmt.executeUpdate();	
									issuetable();
									showbooks();
						     	}
						     	else
						     	{
						     		JOptionPane.showMessageDialog(this,"u hv issued a book alrdy");
						   		}

							}
							else
							{
								String str5="update BOOKS set AVAILABLE_BOOKS=? where S_NO=?";
								pstmt=con.prepareStatement(str5);
								pstmt.setInt(1,i2);
								pstmt.setInt(2,Integer.parseInt(str3));
								int r=pstmt.executeUpdate();	
								issuetable();
								showbooks();
								JOptionPane.showMessageDialog(this,"u hv issued a book successfully");
							}
					}
					else
					{
						JOptionPane.showMessageDialog(this,"books are out of stock");
					}
				}
			}
			catch(SQLException g)
			{
				g.printStackTrace();
			}
		}
}
