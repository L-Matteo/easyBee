package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class pageAccueil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pageAccueil frame = new pageAccueil();
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
	public pageAccueil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCommande = new JButton("Passer Commande");
		btnCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCommande.setBounds(135, 113, 164, 21);
		contentPane.add(btnCommande);
		
		JButton btnNewButton = new JButton("Liste des commandes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if() {
					listeCommande listeCommande = new listeCommande();
					listeCommande.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(contentPane,"Vous n'avez pas le rôle nécessaires pour accéder à cette fonctionnalité",
							"ERREUR", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});
		btnNewButton.setBounds(135, 157, 164, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Page d'accueil");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(150, 36, 164, 13);
		contentPane.add(lblNewLabel);
	}
}
