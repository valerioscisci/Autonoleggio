package gui.moduli;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import db.DBConnect;
import entita.Operatore;
import utils.CostruisciTabella;
import utils.TableColumnAdjuster;


public class ModuloOperatore extends JPanel implements ActionListener{

	private static final long serialVersionUID = 7776472295622776147L; 
	private JTable tblOperatori;
	public JTextField txtPassword;
	public JTextField txtUsername;
	private JButton btnAggiungi;
	private JButton btnElimina;
	private JScrollPane scroll = new JScrollPane(tblOperatori);
	
	private Operatore operatore;
	private DBConnect elencoOperatori;
	
	/* Costruttore ModuloOp */
	
	public ModuloOperatore(String str){
		set(str);
	}

	public void set(String str){
		if (str == "Elenca"){
			elencoOperatori = new DBConnect();
			this.removeAll();
			this.setBorder(BorderFactory.createTitledBorder("Elenco Operatori"));
			
			try{
				elencoOperatori.exequery("SELECT * FROM operatore","select");
				
				tblOperatori = new JTable();
				tblOperatori.setModel(new CostruisciTabella(elencoOperatori.rs).model);
				TableColumnAdjuster tca = new TableColumnAdjuster(tblOperatori);
				tca.adjustColumns();
				
				scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				scroll.setViewportView(tblOperatori);
				
				elencoOperatori.con.close();
			}
			catch (SQLException e) {  
				JOptionPane.showMessageDialog(null, "Errore, impossibile caricare l'elenco degli operatori!",
						"Errore ",
						JOptionPane.ERROR_MESSAGE);}
			
			
			
			/* Crea il Layout per l'elenco degli Operatori. */
			
			GroupLayout gl_contentPane = new GroupLayout(this);
			gl_contentPane.setHorizontalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 453, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(103, Short.MAX_VALUE))
				);
				gl_contentPane.setVerticalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
							.addContainerGap())
				);
			this.setLayout(gl_contentPane);
			this.revalidate();
		}
		else if (str == "Nuovo"){
			this.removeAll();
			this.setBorder(BorderFactory.createTitledBorder("Nuovo Operatore"));
			
			btnAggiungi = new JButton("Aggiungi Operatore");
			btnAggiungi.setFont(new Font("Arial", Font.PLAIN, 12));
			btnAggiungi.addActionListener(this);	/* Action Listener per il bottone Accedi.*/
			
			txtPassword = new JPasswordField();
			
			txtUsername = new JTextField();
			txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
			
			JLabel lblUsername = new JLabel("Username");
			lblUsername.setFont(new Font("Arial", Font.BOLD, 14));
			
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setFont(new Font("Arial", Font.BOLD, 14));

			GroupLayout gl_contentPane = new GroupLayout(this);
			
			/* Crea il Layout per un nuovo Operatore. */
			
			gl_contentPane.setHorizontalGroup(
					gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtUsername, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
							.addGap(10))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(194, Short.MAX_VALUE)
							.addComponent(btnAggiungi)
							.addGap(177))
				);
				gl_contentPane.setVerticalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
							.addGap(65)
							.addComponent(btnAggiungi, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(133, Short.MAX_VALUE))
				);
			this.setLayout(gl_contentPane);
			this.revalidate();
		}
		else if (str == "Elimina"){
			this.removeAll();
			this.setBorder(BorderFactory.createTitledBorder("Elimina Operatore"));
			
			btnElimina = new JButton("Elimina Operatore");
			btnElimina.setFont(new Font("Arial", Font.PLAIN, 12));
			btnElimina.addActionListener(this);	/* Action Listener per il bottone Elimina.*/
			
			txtUsername = new JTextField();
			txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
			
			JLabel lblUsername = new JLabel("Username");
			lblUsername.setFont(new Font("Arial", Font.BOLD, 14));
			
			/* Crea il Layout per eleminare un Operatore. */
			
			GroupLayout gl_contentPane = new GroupLayout(this);
			gl_contentPane.setHorizontalGroup(
					gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
							.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addGap(10))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(188, Short.MAX_VALUE)
							.addComponent(btnElimina)
							.addGap(169))
				);
				gl_contentPane.setVerticalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(50)
							.addComponent(btnElimina, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(167, Short.MAX_VALUE))
				);
			this.setLayout(gl_contentPane);
			this.revalidate();
		}
	}
	
	/* Definisce le azioni da eseguire in base al pulsante clickato.*/
	
	public void actionPerformed(ActionEvent e){
		if (btnAggiungi == e.getSource()){
			operatore = new Operatore();
			operatore.setValori(this);
			operatore.aggiungi(this);
		}
		else if(btnElimina == e.getSource()){
			operatore = new Operatore();
			operatore.setUsername(this);
			operatore.elimina(this);
		}
	}
}
