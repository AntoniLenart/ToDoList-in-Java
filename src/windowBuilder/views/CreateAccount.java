package windowBuilder.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import app.Login;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * The CreateAccount class represents a window for creating a new user account.
 * Users can input their desired username and password to create a new account.
 */
public class CreateAccount extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblNewLabel;
	private JPasswordField passwordFieldPassword;
	private JPasswordField passwordFieldConfirmPassword;
	private JTextField textFieldUsername;
	private JButton btnCancel;
	private JButton btnCreate;


	/**
	 * Create the frame.
	 */
	public CreateAccount() 
	{
		initComponents();
		createEvents();
	}
	
	private void initComponents()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreateAccount.class.getResource("/windowBuilder/resources/createaccount_128.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		lblNewLabel = new JLabel("Confirm password:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		passwordFieldPassword = new JPasswordField();
		passwordFieldConfirmPassword = new JPasswordField();
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		
		btnCancel = new JButton("Cancel");	
		btnCreate = new JButton("Create");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblUsername)
								.addComponent(lblPassword)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordFieldConfirmPassword, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
								.addComponent(passwordFieldPassword, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
								.addComponent(textFieldUsername, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
						.addComponent(btnCancel, Alignment.TRAILING)
						.addComponent(btnCreate, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(textFieldUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordFieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(passwordFieldConfirmPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnCreate)
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addComponent(btnCancel)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
    /**
     * Sets up action listeners for Cancel and Create buttons.
     * Handles events when users attempt to create a new account.
     */
	private void createEvents()
	{
		btnCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				dispose(); //Close window.
			}
		});
		
		btnCreate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String username = textFieldUsername.getText().toString();
				
				char[] passwordChars = passwordFieldPassword.getPassword();
				char[] passwordConfirmChars = passwordFieldConfirmPassword.getPassword();
				
				String password = new String(passwordChars);
				String passwordConfirm = new String(passwordConfirmChars);
				
				if (password.equals(passwordConfirm))
				{
					Login login = new Login();
					login.createAccount(username, password);
					dispose(); //Close window.
				}
			}
		});
		
	}
}
