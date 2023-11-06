package windowBuilder.views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListModel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

public class MainGUI extends JFrame 
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnFinish;
	private JButton btnAddTask;
	private JButton btnQuit;
	private JList<String> listToDo;
	private JList<String> listFinished;
	DefaultListModel<String> listToDoModel = new DefaultListModel<>();
	DefaultListModel<String> listFinishedModel = new DefaultListModel<>();
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
					MainGUI frame = new MainGUI();
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
	public MainGUI() 
	{
		initComponents();
		createEvents();
	}
	
	private void initComponents() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setTitle("ToDoList");
		
		//Today date (right down corner)
		LocalDate todayDate = LocalDate.now();
		DateTimeFormatter dateFormat= DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String dateFormated = todayDate.format(dateFormat);

		
		JLabel lblDate = new JLabel(dateFormated);
		
		lblDate.setFont(new Font("Verdana", Font.ITALIC, 11));
		
		JPanel panelToDo = new JPanel();
		panelToDo.setBorder(new TitledBorder(null, "ToDo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panelFinished = new JPanel();
		panelFinished.setBorder(new TitledBorder(null, "Finished", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		btnAddTask = new JButton("Add task");
		
		btnQuit = new JButton("Quit");
		
		btnFinish = new JButton("Finish");

		listToDo = new JList(listToDoModel);
		listFinished = new JList(listFinishedModel);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDate)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(146)
									.addComponent(btnAddTask)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnFinish))
								.addComponent(panelToDo, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panelFinished, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnQuit, Alignment.TRAILING))))
					.addGap(18, 18, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelFinished, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
						.addComponent(panelToDo, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnQuit)
						.addComponent(btnAddTask)
						.addComponent(btnFinish))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDate))
		);
		
		JScrollPane scrollToDo = new JScrollPane();
		GroupLayout gl_panelToDo = new GroupLayout(panelToDo);
		gl_panelToDo.setHorizontalGroup(
			gl_panelToDo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelToDo.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollToDo, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelToDo.setVerticalGroup(
			gl_panelToDo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelToDo.createSequentialGroup()
					.addComponent(scrollToDo, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
					.addContainerGap())
		);


		scrollToDo.setViewportView(listToDo);
		panelToDo.setLayout(gl_panelToDo);
		
		JScrollPane scrollFinished = new JScrollPane();
		GroupLayout gl_panelFinished = new GroupLayout(panelFinished);
		gl_panelFinished.setHorizontalGroup(
			gl_panelFinished.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelFinished.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollFinished, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelFinished.setVerticalGroup(
			gl_panelFinished.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelFinished.createSequentialGroup()
					.addComponent(scrollFinished, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
					.addContainerGap())
		);


		scrollFinished.setViewportView(listFinished);
		panelFinished.setLayout(gl_panelFinished);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void createEvents()
	{
		btnFinish.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String task = listToDo.getSelectedValue().toString();
				
				listToDoModel.removeElement(task);
				listFinishedModel.addElement(task);
				
				listToDo.setModel(listToDoModel);
				listFinished.setModel(listFinishedModel);
			}
		});
		
		btnAddTask.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
	}
}
