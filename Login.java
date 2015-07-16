import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
class Login extends JFrame implements ActionListener 
{	
	PreparedStatement pstmt;
	JLabel l1,l2,l3,l4;
	JTextField tf1;
	JLabel jl1,jl2;
	JPanel jp1,jp2;
	JPasswordField tf2;
	JButton b1;
	Font ff;
	Connection con;
	ResultSet rs;
	public Login()
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
		setTitle("LIBRARY MANAGEMENT");
		setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()),(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-10));
		setResizable(false);
		setLayout(new BorderLayout());
		
		l1=new JLabel("LIBRARY MANAGEMENT SYSTEM");
		ff=new Font(l1.getFont().getName(),Font.BOLD,40);
		l1.setForeground(Color.pink);
		l2=new JLabel("ADMINISTRATOR");
		l3=new JLabel("Administrator ID:");
		l4=new JLabel("Password:");
		tf1=new JTextField(15);
		tf2=new JPasswordField(15);
		b1=new JButton("LOGIN");
		b1.addActionListener(this);

		jp1=new JPanel(new GridBagLayout());
		
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=2;
		gbc.ipadx=0;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.anchor=GridBagConstraints.CENTER;
		jp1.add(l1,gbc);
		
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=2;
		gbc.ipadx=0;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.anchor=GridBagConstraints.CENTER;
		jp1.add(l3,gbc);

		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=3;
		gbc.ipadx=0;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.anchor=GridBagConstraints.CENTER;
		jp1.add(l4,gbc);

		gbc=new GridBagConstraints();
		gbc.gridx=2;
		gbc.gridy=2;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.anchor=GridBagConstraints.CENTER;
		jp1.add(tf1,gbc);
	
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=3;
		gbc.ipadx=0;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.anchor=GridBagConstraints.CENTER;
		jp1.add(l4,gbc);

		gbc=new GridBagConstraints();
		gbc.gridx=2;
		gbc.gridy=3;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.anchor=GridBagConstraints.CENTER;
		jp1.add(tf2,gbc);

		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=4;
		gbc.gridwidth=2;
		gbc.ipadx=0;
		gbc.ipady=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.anchor=GridBagConstraints.CENTER;
		jp1.add(b1,gbc);
		
		/*ImageIcon img=new ImageIcon();
		jl1=new JLabel(img);
		
		ImageIcon img1=new ImageIcon("D:/DOCS/Books/java/J2EE/project images/student.jpg");
		jl2=new JLabel(img1);*/
		
		//add(jl1,BorderLayout.NORTH);
		add(jp1,BorderLayout.CENTER);
		//add(jl2,BorderLayout.WEST);
		setVisible(true);
	}
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==b1)
			{
				String str1=tf1.getText().trim();
				String str2=String.valueOf(tf2.getPassword()).trim();
				try
				{
					String query="select * from login where login_id=? and password=?";
					pstmt=con.prepareStatement(query);
					pstmt.setString(1,str1);
					pstmt.setString(2,str2);
					rs=pstmt.executeQuery();
					if(rs.next())
					{
						new LibraryManagementSystem();
						dispose();
					}
					else
					{
						System.out.println("use pane");
					}
				}
				catch(SQLException g)
				{
					g.printStackTrace();
				}
			}
		
		}
		public static void main(String args[])
		{
			new Login();
		}


}