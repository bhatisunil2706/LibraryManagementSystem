import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
class AddBooks extends JPanel implements ActionListener
{
	Connection con;
	PreparedStatement pstmt;
	JLabel jl1,jl2,jl3,jl4,jl5;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5;
	JButton jb1,jb2,jb3;
	DefaultTableModel dtm;
	JTable jtb;
	JScrollPane jsp;
	public AddBooks()
	{
		setLayout(new GridBagLayout());
		setSize(600,600);
		jl1=new JLabel("Serial Number");
		jl2=new JLabel("Subject");
		jl3=new JLabel("Book Title");
		jl4=new JLabel("Book Author");
		jl5=new JLabel("Total Books");

		jtf1=new JTextField(20);
		jtf2=new JTextField(20);
		jtf3=new JTextField(20);
		jtf4=new JTextField(20);
		jtf5=new JTextField(20);

		String col[]={"S_NO.","Subject","Title","Author","TotalBooks","Available"};
		dtm=new DefaultTableModel(null,col);
		jtb=new JTable(dtm);
		jtb.setEnabled(false);
		jtb.setPreferredScrollableViewportSize(new Dimension(400,400));	
		jsp=new JScrollPane(jtb);

		jb1=new JButton("ADD");
		jb1.addActionListener(this);
		jb2=new JButton("CLEAR");
		jb2.addActionListener(this);
		jb3=new JButton("CLOSE");
		jb3.addActionListener(this);
		
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
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		jtf1.setText(fix());
		jtf1.setEditable(false);
	

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
		gbc.insets=new Insets(10,800,0,10);
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
		gbc.insets=new Insets(420,0,0,300);
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
		gbc.insets=new Insets(420,0,0,50);
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
		gbc.insets=new Insets(420,230,0,0);
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.ipadx=30;
		gbc.ipady=0;
		add(jb3,gbc);

	}
		
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==jb1)
			{
			int i1=Integer.parseInt(jtf1.getText());;
			String str1=jtf2.getText();
			String str2=jtf3.getText();
			String str3=jtf4.getText();
			int i2=Integer.parseInt(jtf5.getText());
			String query="insert into Books values(?,?,?,?,?,?)";
			try
			{
				pstmt=con.prepareStatement(query);
				pstmt.setInt(1,i1);
				pstmt.setString(2,str1);
				pstmt.setString(3,str2);
				pstmt.setString(4,str3);
			    pstmt.setInt(5,i2);
			    pstmt.setInt(6,i2);
				int count=pstmt.executeUpdate();
				addBooksData();
				jtf1.setText(fix()); 
					
					
			jtf2.setText("");
			jtf3.setText("");
			jtf4.setText("");
			jtf5.setText("");
			}
			catch(SQLException et)
			{
				et.printStackTrace();
			}
			
		}
		if(e.getSource()==jb2)
		{
			
			jtf2.setText("");
			jtf3.setText("");
			jtf4.setText("");
			jtf5.setText("");
		}
		if(e.getSource()==jb3)
		{
			System.exit(0);
		}
	}
	public void addBooksData()
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
			String strr="select * from Books";
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
	public String fix() 
	{
		int rtrn=0;
		String sd=null;
		try
		{
		
		String sr="select max(s_no) from Books";
		pstmt=con.prepareStatement(sr);
		ResultSet res=pstmt.executeQuery();
		while(res.next())
		{
			int rd=res.getInt("max(s_no)");
			rtrn=rd+1;
			sd=String.valueOf(rtrn);
		
		}
		
		}
		catch(SQLException ss)
		{
			ss.printStackTrace();
		}
			return sd;
	}
}
