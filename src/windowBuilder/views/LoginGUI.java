package windowBuilder.views;

import app.Login;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.LayoutStyle.ComponentPlacement;

public class LoginGUI extends JFrame 
{
	private static final long serialVersionUID = 1L;
	
	//Components.
	private JPanel contentPane;
	
	private JTextField textUsername;
	private JPasswordField passwordField;
	
	private JButton btnLogin;
	
	private JLabel lblUsername;
	private JLabel lblPassword;

	private GroupLayout gl_contentPane;
	
	private Timer timer;
	
	//Frame
	public LoginGUI() 
	{
		initComponents();
		createEvents();
	}

	//This method contains all of the code for creating and initializing components.
	private void initComponents() 
	{
		//Components
		lblPassword = new JLabel("Password:");
		lblUsername = new JLabel("Username:");
		
		btnLogin = new JButton("Log in");
		
		textUsername = new JTextField();
		passwordField = new JPasswordField();
		contentPane = new JPanel();
		gl_contentPane = new GroupLayout(contentPane);

		/////////////////////////////////////////////AUTO GENERATED CODE/////////////////////////////////////////////
		
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginGUI.class.getResource("/windowBuilder/resources/login_128.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 20));
		textUsername.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textUsername.setColumns(10);
		lblUsername.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		passwordField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));

		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblPassword))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(passwordField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
								.addComponent(textUsername, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
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
					.addContainerGap(117, Short.MAX_VALUE))
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
				String username = textUsername.getText();
				
				if(login.run(username, password))
				{
					//Shut down the current window and run succesfullWindow(2 sec), then run mainGUI.
					dispose();
					SuccessfulLogin successfulLoginWindow = new SuccessfulLogin(textUsername.getText());
					successfulLoginWindow.setVisible(true);
					
			        //Create a timer with a 2-second delay
			        timer = new Timer(2000, new ActionListener() 
			        {
			            public void actionPerformed(ActionEvent e) 
			            {
					        successfulLoginWindow.dispose();
			                MainGUI main = new MainGUI(username);
			                main.setVisible(true);
			            }
			        });
			        timer.setRepeats(false);
			        timer.start();
				} 
				else 
				{
					//If incorrect credentials, reset username and password fields.
					NotSuccessfulLogin frame = new NotSuccessfulLogin();
					frame.setVisible(true);

					textUsername.setText(null);
					passwordField.setText(null);
				}
			}
		});
	}
}
