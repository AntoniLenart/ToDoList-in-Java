package windowBuilder.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuccessfulLogin extends JFrame 
{

	//Components
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Timer timer;
	private String username;

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
					SuccessfulLogin frame = new SuccessfulLogin("");
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
	public SuccessfulLogin(String username) 
	{
		this.username = username;
		initComponents();
		
        // Create a timer with a 2-second delay
        timer = new Timer(2000, new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                dispose(); // Close the window when the timer expires
            }
        });
        timer.start();
	}
	
	//This method contains all of the code for creating and initializing components.

	private void initComponents() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(SuccessfulLogin.class.getResource("/windowBuilder/resources/login_128.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblSuccess = new JLabel("Welcome " + username);
		lblSuccess.setFont(new Font("Verdana", Font.BOLD, 30));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(122, Short.MAX_VALUE)
					.addComponent(lblSuccess)
					.addGap(113))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(82)
					.addComponent(lblSuccess, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(89, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
