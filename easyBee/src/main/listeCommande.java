package main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class listeCommande extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Statement st;
	ConnexionBdd cn=new ConnexionBdd(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listeCommande frame = new listeCommande();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public listeCommande() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 128));
		contentPane.setBorder(new EmptyBorder(35, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBoxListeCommande = new JComboBox<String>();
		comboBoxListeCommande.setBounds(117, 56, 200, 30);
		comboBoxListeCommande.setPreferredSize(new Dimension(200, 30)); // modifier la taille
		contentPane.add(comboBoxListeCommande);
		
		JButton btnSuivant = new JButton("Suivant");
		btnSuivant.setBounds(138, 132, 157, 21);
		contentPane.add(btnSuivant);
		
		String requeteListCmde = "select nomCommande from cmdeapprodepot;";
		st=cn.laconnexion().createStatement();
		ResultSet rs = st.executeQuery(requeteListCmde);
		while(rs.next()) {
			String produit = rs.getString("nomCommande");
			comboBoxListeCommande.addItem(produit);
		}
	}

}
