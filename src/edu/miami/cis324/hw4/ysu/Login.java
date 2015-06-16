package edu.miami.cis324.hw4.ysu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField tfUserName;
	private JLabel lblUserName;
	private JLabel lblPassword;
	
	private JPasswordField passwordField;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tfUserName = new JTextField();
			
		tfUserName.setBounds(204, 47, 198, 36);
		frame.getContentPane().add(tfUserName);
		tfUserName.setColumns(10);
		
		lblUserName = new JLabel("Username");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setBounds(44, 47, 124, 36);
		frame.getContentPane().add(lblUserName);
		
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(44, 107, 124, 36);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(204, 107, 198, 36);
		frame.getContentPane().add(passwordField);
		
		btnLogin = new JButton("Log in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String userName = tfUserName.getText();
				
				
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				
				if(userName.equals("y.su") && password.equals("1366Lydia!?"))
				{
					JOptionPane.showMessageDialog(null, "Login successful.");
					
					frame.dispose();
					
					PatientScheduling ps = new PatientScheduling();
					
					ps.setVisible(true);
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Username and password combination is incorrect.");
				}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnLogin.setBounds(150, 184, 138, 36);
		frame.getContentPane().add(btnLogin);
		
		
		
	
		
	}

}
