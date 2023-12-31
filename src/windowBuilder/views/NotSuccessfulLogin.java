package windowBuilder.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NotSuccessfulLogin extends JFrame 
{
	private static final long serialVersionUID = 1L;
	
	//Components
	private JPanel contentPane;
	private JButton btnTryAgain;
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	public NotSuccessfulLogin() 
	{
		initComponents();
		createEvents();
	}
	
	//This method contains all of the code for creating and initializing components.
	
	private void initComponents() 
	{
		//Components
		lblNewLabel = new JLabel("Incorrect credentials.");
		contentPane = new JPanel();
		btnTryAgain = new JButton("Try again");
		
		/////////////////////////////////////////////AUTO GENERATED CODE/////////////////////////////////////////////

		setIconImage(Toolkit.getDefaultToolkit().getImage(NotSuccessfulLogin.class.getResource("/windowBuilder/resources/wrong_128.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		btnTryAgain.setFont(new Font("Verdana", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(92, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					.addGap(80))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(136)
					.addComponent(btnTryAgain)
					.addContainerGap(205, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(62)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnTryAgain)
					.addContainerGap(77, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	//This method contains all of the code for creating events

	private void createEvents() 
	{
		//After wrong password and clicking "OK", dispose window to try again.
		btnTryAgain.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
	}
}

