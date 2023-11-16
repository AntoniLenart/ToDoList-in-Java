package windowBuilder.views;

import app.Login;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ChangeUsername extends JFrame 
{
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JTextField textFieldOldUsername;
	private JTextField textFieldNewUsername;
	
	private JButton btnApply;
	private JButton btnCancel;

	/**
	 * Create the frame.
	 */
	public ChangeUsername(String username) 
	{
		initComponents();
		createEvents(username);
	}
	
	private void initComponents()
	{
		// Components.
		contentPane = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		
		JLabel lblOldPassword = new JLabel("Old username:");
		JLabel lblNewPassword = new JLabel("New username:");
		
		textFieldOldUsername = new JTextField();
		textFieldNewUsername = new JTextField();
		
		btnApply = new JButton("Apply");
		btnCancel = new JButton("Cancel");
		
		/////////////////////////////////////////////AUTO GENERATED CODE/////////////////////////////////////////////
		
		setTitle("Change username");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 290, 195);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		setIconImage(Toolkit.getDefaultToolkit().getImage(ChangePassword.class.getResource("/windowBuilder/resources/changepassword_128.png")));
		
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
							.addComponent(textFieldOldUsername, Alignment.LEADING)
							.addComponent(textFieldNewUsername, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldOldUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOldPassword))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewPassword)
						.addComponent(textFieldNewUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnApply)
						.addComponent(btnCancel))
					.addContainerGap(117, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void createEvents(String username) 
	{
		btnApply.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
		        try 
		        {
		            Scanner scan = new Scanner(new File("src/DataStorage/credentials_" + username + ".txt"));
		            
		            String username = scan.nextLine();
		            String password = scan.nextLine();
		            scan.close();
    
		            String oldUsername = textFieldOldUsername.getText().toString();
					String newUsername = textFieldNewUsername.getText().toString();
					
					if (username.equals(oldUsername))
					{
						Login login = new Login();
						
						login.setUsername(newUsername);
						login.setPassword(password);
						
						dispose();
					}
					else 
					{
						NotSuccessfulLogin frame = new NotSuccessfulLogin();
						frame.setVisible(true);
						
						textFieldOldUsername.setText(null);
						textFieldNewUsername.setText(null);
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
