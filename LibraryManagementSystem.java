import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class LibraryManagementSystem extends JFrame implements ActionListener
{	
	CardLayout cl;
	JPanel main;
	JMenu sysadmin,subbuk,issuebuk,	lmsi;
	IssueStudent ibs;
	IssueBookFaculty igh;
	AddBooks ab;
	ChangePassword cp;
	SubmitStudent ss;
	SubmitFaculty sf;
		
	JMenuItem abAction,cpAction,stuAction,facAction,abtAction,hlpAction,faAction,stAction;
	
	public LibraryManagementSystem()
	{
		setTitle("LIBRARY MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(10,10);
		setLayout(new BorderLayout());
		setResizable(false);
		setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()),(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-10));
	
		ibs=new IssueStudent();
		igh=new IssueBookFaculty();
		ab=new AddBooks();
		cl=new CardLayout();
		cp=new ChangePassword();
		ss=new SubmitStudent();
		sf=new SubmitFaculty();
		
		main=new JPanel(cl);
		main.add(ab,"AddBooks");
		main.add(igh,"IssueFaculty");
		main.add(ibs,"IssueStudent");
		main.add(sf,"SubmitFaculty");
		main.add(ss,"SubmitStudent");
		main.add(cp,"ChangePassword");
		
		
		JMenuBar menu=new JMenuBar();
		setJMenuBar(menu);

		sysadmin=new JMenu("System Administrator");
		menu.add(sysadmin);
		subbuk=new JMenu("Submit Books");
		menu.add(subbuk);
		issuebuk=new JMenu("Issue Books");
		menu.add(issuebuk);
		lmsi=new JMenu("Library Management System Information");
		menu.add(lmsi);

		abAction = new JMenuItem("Add Books");
		abAction.addActionListener(this);
		
		cpAction = new JMenuItem("Change Password");
		cpAction.addActionListener(this);
		
		stuAction = new JMenuItem("Student");
		stuAction.addActionListener(this);
		
		facAction = new JMenuItem("Faculty");
		facAction.addActionListener(this);
		
		faAction = new JMenuItem("Issue Faculty");
		faAction.addActionListener(this);
		
		stAction = new JMenuItem("Issue Student");
		stAction.addActionListener(this);
		
		
		abtAction = new JMenuItem("About Us");
		hlpAction = new JMenuItem("Help");
		
		
		sysadmin.add(abAction);
		sysadmin.add(cpAction);
		subbuk.add(stuAction);
		subbuk.add(facAction);
		issuebuk.add(faAction);
		issuebuk.add(stAction);
		lmsi.add(abtAction);
		lmsi.add(hlpAction);
		
		add(menu,BorderLayout.NORTH);
		add(main,BorderLayout.CENTER);
		
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==abAction)
		{
			cl.show(main,"AddBooks");
			ab.addBooksData();
		}
		else if(ae.getSource()==cpAction)
		{
			cl.show(main,"ChangePassword");
		}
			
		else if(ae.getSource()==stuAction)
		{
			cl.show(main,"SubmitStudent");
		}
			
		else if(ae.getSource()==facAction)
		{
			cl.show(main,"SubmitFaculty");
		}
			
		else if(ae.getSource()==faAction)
		{
			cl.show(main,"IssueFaculty");
			igh.showing();
		}
			
		else if(ae.getSource()==stAction)
		{
			cl.show(main,"IssueStudent");
			ibs.showbooks();
		}
			
	}
	
}