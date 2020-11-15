package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import adapter.UserAdapter;
import businessLogic.BLFacade;
import domain.PertsonaErregistratua;

public class UserApustuak extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserApustuak frame = new UserApustuak();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserApustuak() {
		
		frame = new JFrame();
		frame.setBounds(100,100,450, 300);
		
		BLFacade bl = MainGUI.getBusinessLogic();
		int nan = Integer.parseInt(Login.nanZb.getText());
		PertsonaErregistratua per = (PertsonaErregistratua)bl.getUserByNan(nan);
		UserAdapter model = new UserAdapter(per);
		
		
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(380,280));
		JPanel panel = new JPanel();
		panel.add(scrollPane);
		getContentPane().add(panel, BorderLayout.CENTER);

	}

}
