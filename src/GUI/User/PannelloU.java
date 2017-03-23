package GUI.User;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import GUI.Admin.Cliente;
import GUI.Admin.Contratto;

public class PannelloU extends JFrame implements ActionListener{
	
	public String Username;
	public JPanel contentPane = new JPanel();
	private final JMenuBar menuBar = new JMenuBar();
	private JMenuItem mntmHome = new JMenuItem("Home");
	private JMenuItem mntmCliente = new JMenuItem("Pannello Cliente");
	private JMenuItem mntmContratto = new JMenuItem("Pannello Contratto");
	
	/* Crea il frame PannelloU.*/
	
	public PannelloU(String user){
		Username = user;
		try {
			try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
	        catch (ClassNotFoundException e) {}
	        catch (InstantiationException e) {}
	        catch (IllegalAccessException e) {}
	        catch (UnsupportedLookAndFeelException e) {}
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.menu();
			this.setBounds(100, 100, 800, 600);
			this.setLocationRelativeTo(null);
			HomeU home = new HomeU(this);
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* Crea il men� */
	
	public void menu(){
		setJMenuBar(menuBar);
		
		JMenu mnHome = new JMenu("Home");
		menuBar.add(mnHome);
		
		mntmHome.addActionListener(this);  /* Action Listener per il menu/Home.*/
		mnHome.add(mntmHome);
		
		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		mntmCliente.addActionListener(this);  /* Action Listener per il menu/Cliente.*/
		mnCliente.add(mntmCliente);
		
		JMenu mnContratto = new JMenu("Contratto");
		menuBar.add(mnContratto);
		
		mntmContratto.addActionListener(this);  /* Action Listener per il menu/Contratto.*/
		mnContratto.add(mntmContratto);
	}
	
	/* Definisce le azioni da eseguire in base al men� clickato.*/
	
	public void actionPerformed(ActionEvent e){
		if(mntmHome == e.getSource()){			
			getContentPane().removeAll();
			HomeU hm = new HomeU(this);
			getContentPane().revalidate();
		}
		else if(mntmCliente == e.getSource()){
			getContentPane().removeAll();
			Cliente cl = new Cliente(this);
			getContentPane().revalidate();
		}
		else if(mntmContratto == e.getSource()){
			getContentPane().removeAll();
			Contratto ct = new Contratto(this);
			getContentPane().revalidate();
		}
	}	
}