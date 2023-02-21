/*
your pass word is 1234
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ATM extends BANK
{
	public static void main(String args[])
	{
		new ATM();
	}
	JFrame f1=new JFrame("BANK");
	JLabel l1=new JLabel("Login to ATM");
	JLabel l2=new JLabel("You are new user so your userpin is 1234");
	JLabel l3=new JLabel("Enter User Id :");
	JLabel l4=new JLabel("Enter User Pin :");
	JLabel l5=new JLabel();
	Font font1=new Font("Courier",Font.BOLD,24);
	JButton b1=new JButton("LOGIN");
	JButton b2=new JButton("EXIT");
	JButton b3=new JButton("Continue");
	JTextField tf1=new JTextField();
	JTextField tf2=new JTextField();
	public ATM()
	{
		l1.setBounds(170,20,200,30);
		l1.setFont(font1);
		l2.setBounds(130,90,300,30);
		l3.setBounds(100,150,100,30);
		l4.setBounds(100,200,100,30);
		l5.setBounds(100,250,300,30);
		tf1.setBounds(250,150,150,30);
		tf2.setBounds(250,200,150,30);
		b1.setBounds(300,300,100,30);
		b2.setBounds(100,300,100,30);
		b3.setBounds(400,400,100,30);
		f1.add(l1);
		f1.add(l2);
		f1.add(l3);
		f1.add(l4);
		f1.add(l5);
		f1.add(b1);
		f1.add(b2);
		f1.add(b3);
		f1.add(tf1);
		f1.add(tf2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b3.setVisible(false);
		l5.setVisible(false);
		f1.setLayout(null);
		f1.setSize(550,600);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s1=tf1.getText();
		String s2=tf2.getText();
		int a=Integer.parseInt(s2);
		if(ae.getSource()==b1)
		{
			if(a==1234 && s1.length()>=5)
			{
				l5.setVisible(true);
				l5.setText("Correct, press Continue to proceed forward");
				b3.setVisible(true);
			}
			else
			{
				l5.setVisible(true);
				l5.setText("Incorrect credentials, sorry cannot proceed forward");
				b3.setVisible(false);
			}
		}
		else if(ae.getSource()==b2)
		{
			f1.setVisible(false);
		}
		else if(ae.getSource()==b3)
		{
			f1.setVisible(false);
			f2.setVisible(false);
			new BANK();
		}
	}
}
class BANK implements ActionListener
{
	public int cash=0,draw,deposit,transfer,i=0,passcode=1234;
	JFrame f2=new JFrame("BANK");
	JFrame f3=new JFrame("HISTORY");
	JLabel l1=new JLabel("ATM");
	JLabel l2=new JLabel("Balance :");	
	JLabel l3=new JLabel("History");
	Font font1=new Font("Courier",Font.BOLD,24);
	JTextField tf3=new JTextField("Bank Account created successfully, Your bank Balance is 0 $");
	JTextArea ta1=new JTextArea();
	JButton b1=new JButton("Withdraw");
	JButton b2=new JButton("Deposit");
	JButton b3=new JButton("Transfer");
	JButton b4=new JButton("History");
	JButton b5=new JButton("QUIT");
	JButton b6=new JButton("Back");
	public BANK()
	{
		l1.setBounds(230,20,100,30);
		l1.setFont(font1);
		l2.setBounds(50,300,100,30);
		l3.setBounds(220,10,100,30);
		b1.setBounds(50,100,100,30);
		b2.setBounds(50,250,100,30);
		b3.setBounds(350,100,100,30);
		b4.setBounds(350,250,100,30);
		b5.setBounds(200,500,100,30);
		b6.setBounds(220,520,80,30);
		tf3.setBounds(50,340,400,50);
		ta1.setBounds(0,50,550,450);
		f2.add(l1);
		f2.add(l2);
		f3.add(l3);
		f2.add(b1);
		f2.add(b2);
		f2.add(b3);
		f2.add(b4);
		f2.add(b5);
		f3.add(b6);
		f2.add(tf3);
		f3.add(ta1);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		f2.setLayout(null);
		f2.setVisible(true);
		f2.setSize(550,600);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			draw=Integer.parseInt(JOptionPane.showInputDialog("How much amount do you want to draw ?"));
			int a=Integer.parseInt(JOptionPane.showInputDialog("Enter the userPin to proceed"));
			if(a==passcode)
			{
				if(draw<=cash)
				{
					cash=cash-draw;
					tf3.setText("Withdrawn Successfully "+"\n"+"Your bank balance is "+cash+" $");
					ta1.append((++i)+". "+draw+" $ Withdrawn Successfully through ATM"+"\n");
				}
				else
				{
					tf3.setText("Insufficient Bank Balance, Your bank balance is "+cash+" $");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Your Userpin is incorrect","Incorrect Pin",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(ae.getSource()==b2)
		{
			deposit=Integer.parseInt(JOptionPane.showInputDialog("How much money you wanted to deposit ?"));
			int a=Integer.parseInt(JOptionPane.showInputDialog("Enter the userPin to proceed"));
			if(a==passcode)
			{
				cash =cash+deposit;
				tf3.setText("Deposited Successfully "+"\n"+"Your bank balance is "+cash+" $");
				ta1.append((++i)+". "+deposit+" $ Deposited Successfully through ATM"+"\n");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Your Userpin is incorrect","Incorrect Pin",JOptionPane.ERROR_MESSAGE);
			}	
		}
		else if(ae.getSource()==b3)
		{
			String username=JOptionPane.showInputDialog("Enter the username to whom you want to transfer the money ?");
			transfer=Integer.parseInt(JOptionPane.showInputDialog("How much money you want to transfer ?"));
			int a=Integer.parseInt(JOptionPane.showInputDialog("Enter the userPin to proceed"));
			if(a==passcode)
			{
				if(transfer<=cash)
				{
					cash=cash-transfer;
					tf3.setText("Transffered Successfully "+"\n"+"Your bank balance is "+cash+" $");
					ta1.append((++i)+". "+transfer+" $ Transffered Successfully to "+username+" through ATM"+"\n");
				}
				else
				{
					tf3.setText("Insufficient Bank Balance, Your bank balance is "+cash+" $");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Your Userpin is incorrect","Incorrect Pin",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(ae.getSource()==b4)
		{
			f3.setLayout(null);
			f3.setSize(550,600);
			f3.setVisible(true);
		}
		else if(ae.getSource()==b5)
		{
			f2.setVisible(false);
		}
		else if(ae.getSource()==b6)
		{
			f3.setVisible(false);
		}
	}
}