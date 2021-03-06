package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import adapter.UserAdapter;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;

public class UserPantaila extends JFrame{
	
	private JPanel contentPane;
	private JButton btnSaioaItxi = new JButton(ResourceBundle.getBundle("Etiquetas").getString("LogOut"));
	private JButton btnDiruaSartuAtera = new JButton(ResourceBundle.getBundle("Etiquetas").getString("PutTakeMoney"));
	private JButton btnMugimenduakIkusi = new JButton(ResourceBundle.getBundle("Etiquetas").getString("SeeMovements"));
	private JButton btnNewButton = new JButton(ResourceBundle.getBundle("Etiquetas").getString("DeleteBet"));
	private JButton gertaeraIkusi = new JButton(ResourceBundle.getBundle("Etiquetas").getString("SeeEvent"));
	private JButton btnApustuaEgin = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Bet"));
	private JButton btnErreplikatu = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Replicate"));
	private JButton userapustuak = new JButton(ResourceBundle.getBundle("Etiquetas").getString("UserAp"));
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPantaila frame = new UserPantaila();
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
	public UserPantaila() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		gertaeraIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				FindQuestionsGUI fq = new FindQuestionsGUI();
				fq.setVisible(true);
				dispose();
			}
		});
		gertaeraIkusi.setBounds(42, 35, 173, 41);
		contentPane.add(gertaeraIkusi);
		
		btnSaioaItxi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btnSaioaItxi.setBounds(298, 199, 115, 29);
		contentPane.add(btnSaioaItxi);
		
		btnDiruaSartuAtera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				DiruaSartuAtera dsa = new DiruaSartuAtera();
				dsa.setVisible(true);
				dispose();
			}
		});
		btnDiruaSartuAtera.setBounds(42, 86, 173, 41);
		contentPane.add(btnDiruaSartuAtera);
		
		btnApustuaEgin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ApustuaEgin ae = new ApustuaEgin();
				ae.setVisible(true);
				dispose();
			}
		});
		btnApustuaEgin.setBounds(42, 140, 173, 41);
		contentPane.add(btnApustuaEgin);
		
		btnMugimenduakIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Mugimenduak m = new Mugimenduak();
				m.setVisible(true);
				dispose();
			}
		});
		btnMugimenduakIkusi.setBounds(229, 35, 173, 41);
		contentPane.add(btnMugimenduakIkusi);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ApustuaEzabatu ae = new ApustuaEzabatu();
				ae.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(230, 87, 172, 38);
		contentPane.add(btnNewButton);
		
		btnErreplikatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Erreplikatu e = new Erreplikatu();
				e.setVisible(true);
				dispose();
			}
		});
		btnErreplikatu.setBounds(42, 193, 172, 40);
		contentPane.add(btnErreplikatu);
		
		
		userapustuak.setBounds(42, 193, 173, 41);
		contentPane.add(userapustuak);
		userapustuak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				UserApustuak e = new UserApustuak();
				e.setVisible(true);
				dispose();
			}
		});
		userapustuak.setBounds(230, 140, 172, 40);
		contentPane.add(userapustuak);
	}

}
