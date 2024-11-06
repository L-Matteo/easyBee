package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class detailsCmde extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public detailsCmde(Utilisateur user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450,250,373,300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(187, 114, 0, 0);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.setBackground(new Color(128, 128, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listeCmde listeCmde = new listeCmde(user);
				listeCmde.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 232, 85, 21);
		contentPane.add(btnNewButton);
		
		
	}
}
