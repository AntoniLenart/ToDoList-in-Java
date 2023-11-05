package windowBuilder.views;

import app.Login;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class LoginGUI extends JFrame {

	//Components.
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsername;
	private JButton btnLogin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() 
	{
		initComponents();
		createEvents();
	}

	
	//This method contains all of the code for creating and initializing components.
	
	private void initComponents() 
	{
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginGUI.class.getResource("/windowBuilder/resources/login_128.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		btnLogin = new JButton("Log in");
		
		textUsername = new JTextField();
		textUsername.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(passwordField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
								.addComponent(textUsername, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
							.addGap(10))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(120, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}


	//This method contains all of the code for creating events.

	private void createEvents() 
	{
		btnLogin.addActionListener(new ActionListener() 
		{
			//Using conversion from char[] to string because password.getText() is deprecated.
			public void actionPerformed(ActionEvent e) 
			{
				Login login = new Login();
				
				char [] passwordChars = passwordField.getPassword();
				String password = new String(passwordChars);
				
				if(login.run(textUsername.getText(), password))
				{
					//Shut down the current window and run succesfullWindow(2 sec).
					dispose();
					SuccessfulLogin successfullLoginWindow = new SuccessfulLogin(textUsername.getText());
					successfullLoginWindow.setVisible(true);
				} else 
				{
					//Reset username and password fields.
					JOptionPane.showMessageDialog(null, "Wrong credentials, try again.");
					textUsername.setText(null);
					passwordField.setText(null);
				}
			}
		});
		
	}
}
