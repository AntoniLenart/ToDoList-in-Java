package windowBuilder.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Toolkit;


/**
 * The SuccessfulLogin class represents a window indicating a successful login.
 * It displays a welcome message to the user after successful authentication.
 */
public class SuccessfulLogin extends JFrame 
{

	//Components
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String username;
	private JLabel lblSuccess;


    /**
     * Initializes the SuccessfulLogin window displaying a welcome message to the user.
     *
     * @param username The username of the logged-in user to be displayed in the welcome message.
     */
	public SuccessfulLogin(String username) 
	{
		this.username = username;
		initComponents();
	}
	
    /**
     * Initializes and sets up GUI components for the SuccessfulLogin window.
     * Displays a welcome message with the username.
     */
	private void initComponents() 
	{
		//Components
		lblSuccess = new JLabel("Welcome " + username);
		contentPane = new JPanel();
		
		/////////////////////////////////////////////AUTO GENERATED CODE/////////////////////////////////////////////

		setIconImage(Toolkit.getDefaultToolkit().getImage(SuccessfulLogin.class.getResource("/windowBuilder/resources/login_128.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

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
