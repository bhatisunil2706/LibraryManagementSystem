import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
class IssueBookFaculty extends JPanel implements ActionListener
{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	JTextField jtf2,jtf3,jtf4,jtf5,jtf6,jtf7;
	JButton jb1,jb2,jb3;
	DefaultTableModel dtm;
	JTable jtb;
	JScrollPane jsp;
	PreparedStatement pstmt;
	ResultSet res;
	Keycalling kv;
	Connection con;
	JComboBox jcb;
	
	public IssueBookFaculty()
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
		catch(SQLException ee)
		{
			ee.printStackTrace();
		}
		kv=new Keycalling();
		setLayout(new GridBagLayout());
		setSize(1150,800);
		
		jl1=new JLabel("Department");
		jl2=new JLabel("Faculty Id");
		jl3=new JLabel("Book Serial Number");
		jl4=new JLabel("Subject");
		jl5=new JLabel("Book Name");
		jl6=new JLabel("Book Author");
		jl7=new JLabel("Issue Date");

		jtf2=new JTextField(20);
		jtf3=new JTextField(20);
		jtf3.addKeyListener(kv);
		jtf4=new JTextField(20);
		jtf4.setEditable(false);
		jtf5=new JTextField(20);
		jtf5.setEditable(false);
		jtf6=new JTextField(20);
		jtf6.setEditable(false);
		jtf7=new JTextField(20);
		jtf7.setEditable(false);
		jtf7.setText(new IssueStudent().date());

		
		String col[]={"S_NO.","Subject","Title","Author","TotalBooks","Available"};
		dtm=new DefaultTableModel(null,col);
		jtb=new JTable(dtm);
		jtb.setPreferredScrollableViewportSize(new Dimension(400,400));	
		jsp=new JScrollPane(jtb);

		String dpt[]={"COMPUTER SCIENCE","IT","ELECTRONIC","ELECTRICAL","MECHNICAL","AUTOMOBILE"};
		jcb=new JComboBox(dpt);
		jb1=new JButton("ISSUE");
		jb1.addActionListener(this);
		jb2=new JButton("CLEAR");
		jb2.addActionListener(this);
		jb3=new JButton("LOGOUT");
		jb3.addActionListener(this);

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
		add(jcb,gbc);

		
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
	
		
	}
	public void actionPerformed(ActionEvent lp)
	{
		if(lp.getSource()==jb1)
		{
			totaly();
		}
		if(lp.getSource()==jb2)
		{
			jtf2.setText("");
			jtf3.setText("");
			jtf4.setText("");
			jtf5.setText("");
			jtf6.setText("");
		}
		if(lp.getSource()==jb3)
		{
			System.exit(0);
			
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
					try
					{
						String str1=null,str2=null,str3=null;
						String st="select * from Books where s_no=?";
						pstmt=con.prepareStatement(st);
						pstmt.setInt(1,Integer.parseInt(jtf3.getText()));
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
			}
		}
	}
	public void showing()
	{
		
		int i=dtm.getRowCount();
			while(i>0)
			{
				dtm.removeRow(0);
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
				dtm.addRow(s);
			}
			}
			catch(SQLException ee)
			{
				ee.printStackTrace();
			}
	}
	public void issuetable()
	{
		String str2=jtf2.getText();
		String str3=jtf3.getText();
		String str4=jtf7.getText();
		
		try
		{
			String str5="insert into ISSUEFACULTY values(?,?,?,?,?)";
			pstmt=con.prepareStatement(str5);
			pstmt.setString(1,jcb.getSelectedItem().toString());
			pstmt.setInt(2,Integer.parseInt(str2));
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
		public void totaly()
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
		     				String hj=jtf2.getText();
		     				String str2="select * from ISSUEFACULTY where FID=?";
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
									showing();
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
								showing();
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