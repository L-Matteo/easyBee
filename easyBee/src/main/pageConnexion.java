package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class pageConnexion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JPasswordField passwordField;
	Statement st;
	ConnexionBdd cn=new ConnexionBdd(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pageConnexion frame = new pageConnexion();
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
	public pageConnexion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450,250,373,300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Connexion");
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Identifiant :");
		lblNewLabel.setBounds(110, 46, 71, 20);
		contentPane.add(lblNewLabel);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(110, 66, 134, 19);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mot de passe : ");
		lblNewLabel_1.setBounds(110, 104, 96, 13);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(110, 120, 134, 19);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Connexion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = textFieldLogin.getText();
				char[] password = passwordField.getPassword();
				textFieldLogin.setText(""); // supprimer le texte dans les champs 
				passwordField.setText("");
				try {
					String requeteConnexion = "select identifiant, motDePasse from salarie "
							+ "where identifiant = '" + login + "' and motDePasse = '" + new String(password) + "'";
					st=cn.laconnexion().createStatement();
					ResultSet resultSet = st.executeQuery(requeteConnexion);
					if(resultSet.next()) {
						JOptionPane.showMessageDialog(contentPane,"Vous êtes connecté."); 
					} else {
						JOptionPane.showMessageDialog(contentPane,"ERREUR | Votre identifiant ou votre mot de passe est incorrect.", "Erreur connexion",
								JOptionPane.ERROR_MESSAGE); 
					}
				} catch(SQLException ex) {
					JOptionPane.showMessageDialog(contentPane,"ERREUR | Problème de connexion à la base de données.", "Problème connexion", 
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(110, 169, 134, 21);
		contentPane.add(btnNewButton);
		
		
	}
}
