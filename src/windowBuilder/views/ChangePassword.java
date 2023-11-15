package windowBuilder.views;

import app.Login;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ChangePassword extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JPasswordField passwordFieldOldPassword;
	private JPasswordField passwordFieldNewPassword;
	
	private JButton btnApply;
	private JButton btnCancel;

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
					ChangePassword frame = new ChangePassword();
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
	public ChangePassword() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChangePassword.class.getResource("/windowBuilder/resources/changepassword_128.png")));
		initComponents();
		createEvents();
	}
	
	private void initComponents()
	{
		// Components.
		contentPane = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		
		JLabel lblOldPassword = new JLabel("Old password:");
		JLabel lblNewPassword = new JLabel("New password:");
		
		passwordFieldOldPassword = new JPasswordField();
		passwordFieldNewPassword = new JPasswordField();
		
		btnApply = new JButton("Apply");
		btnCancel = new JButton("Cancel");
		
		/////////////////////////////////////////////AUTO GENERATED CODE/////////////////////////////////////////////
		
		setTitle("Change password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 290, 195);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOldPassword)
						.addComponent(lblNewPassword))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnApply)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancel))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(passwordFieldOldPassword, Alignment.LEADING)
							.addComponent(passwordFieldNewPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordFieldOldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOldPassword))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewPassword)
						.addComponent(passwordFieldNewPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnApply)
						.addComponent(btnCancel))
					.addContainerGap(117, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void createEvents() 
	{
		btnApply.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
		        try 
		        {
		            Scanner scan = new Scanner(new File("src/DataStorage/credentials.txt"));
		            
		            String username = scan.nextLine();
		            String password = scan.nextLine();
		            scan.close();
		            
		            char[] oldPasswordChars = passwordFieldOldPassword.getPassword();
		            char[] newPasswordChars = passwordFieldNewPassword.getPassword();
		            
		            String oldPassword = new String(oldPasswordChars);
					String newPassword = new String (newPasswordChars);
					
					if (password.equals(oldPassword))
					{
						Login tmp = new Login();
						tmp.setPassword(newPassword);
						tmp.setUsername(username);
						
						dispose();
					}
					else 
					{
						NotSuccessfulLogin frame = new NotSuccessfulLogin();
						frame.setVisible(true);
						
						passwordFieldOldPassword.setText(null);
						passwordFieldNewPassword.setText(null);
					}
		        } 
		        catch (FileNotFoundException z) 
		        {
		            z.printStackTrace();
		        }
			}
		});
		
		btnCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
	}
}
