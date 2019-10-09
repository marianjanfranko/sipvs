package gui;

import java.awt.event.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class zakaznikOkno extends JFrame{
	private JButton btnVytvor = new JButton("Vytvor objednavku");
	private JButton btnSpat = new JButton("Spat");
	private JTextField adresaMestoTF = new JTextField();
	private JTextField adresaPSCTF = new JTextField();
	private JTextField adresaUlicaTF = new JTextField();
	private JTextField menoTF = new JTextField();
	private JTextField hmotnostTF = new JTextField("0");
	private JTextField cisloTF = new JTextField();
	private JLabel udajeLbl = new JLabel("Udaje prijimatela:");
	private JLabel adresaMestoLbl = new JLabel("Mesto");
	private JLabel adresaPSCLbl = new JLabel("PSC");
	private JLabel adresaUlicaLbl = new JLabel("Ulica a popisne cislo");
	private JLabel menoLbl = new JLabel("Meno a priezvisko");
	private JLabel hmotnostLbl = new JLabel("Hmotnost balika v kg:");
	private JLabel cisloLbl = new JLabel("Telefonne cislo");
	private JCheckBox prvaTrieda = new JCheckBox("Prva trieda");

	
	public zakaznikOkno(final Ucet ucet, final zakaznik zakaznik, final TvorbaObratov obraty) {
		setBounds(0,0,500,500);
		getContentPane().setLayout(null);
		setVisible(true);
		setTitle("Zakaznik");
		
		udajeLbl.setBounds(30,30,200,30);
		getContentPane().add(udajeLbl);
		
		menoLbl.setBounds(30,70,200,30);
		getContentPane().add(menoLbl);
		menoTF.setBounds(200,70,250,30);
		getContentPane().add(menoTF);

		adresaMestoLbl.setBounds(30,110,200,30);
		getContentPane().add(adresaMestoLbl);
		adresaMestoTF.setBounds(200,110,250,30);
		getContentPane().add(adresaMestoTF);
		
		adresaPSCLbl.setBounds(30,150,200,30);
		getContentPane().add(adresaPSCLbl);
		adresaPSCTF.setBounds(200,150,250,30);
		getContentPane().add(adresaPSCTF);
		
		adresaUlicaLbl.setBounds(30,190,200,30);
		getContentPane().add(adresaUlicaLbl);
		adresaUlicaTF.setBounds(200,190,250,30);
		getContentPane().add(adresaUlicaTF);
		
		cisloLbl.setBounds(30,230,200,30);
		getContentPane().add(cisloLbl);
		cisloTF.setBounds(200,230,250,30);
		getContentPane().add(cisloTF);
		
		hmotnostLbl.setBounds(30,300,200,30);
		getContentPane().add(hmotnostLbl);
		hmotnostTF.setBounds(200,300,250,30);
		getContentPane().add(hmotnostTF);
		
		
		btnVytvor.setBounds(150, 350, 200, 40);
		getContentPane().add(btnVytvor);
		
		btnSpat.setBounds(380, 380, 70, 50);
		getContentPane().add(btnSpat);
		
		prvaTrieda.setBounds(30, 272, 128, 23);
		getContentPane().add(prvaTrieda);
		
		/**
		 * Sluzi na vytvorenie balika
		 */
		btnVytvor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String meno=menoTF.getText().toString();
				String adresaMesto=adresaMestoTF.getText().toString();
				String adresaPSC=adresaPSCTF.getText().toString();
				String adresaUlica=adresaUlicaTF.getText().toString();
				String cislo=cisloTF.getText().toString();
				String hmotnost=hmotnostTF.getText().toString();
				if(prvaTrieda.isSelected()){
					try {
						zakaznik.vytvorPT(meno, adresaMesto, adresaPSC, adresaUlica, cislo, hmotnost);
						Double h= Double.parseDouble(hmotnostTF.getText());
						ucet.setStav(ucet.getStav() + h*3.5);
						obraty.vytvor((h*3.5), "Objednavka");
					} catch (Vynimka e) {
						System.out.println("Skontroluj ci si spravne vyplnil vsetky okna");
						new error();
					}
				}
				else{
					try {
						zakaznik.vytvor(meno, adresaMesto, adresaPSC, adresaUlica, cislo, hmotnost);
						Double h= Double.parseDouble(hmotnostTF.getText());
						ucet.setStav(ucet.getStav() + h*2);
					    obraty.vytvor((h*2), "Objednavka");
					} catch (Vynimka e) {
						System.out.println("Skontroluj ci si spravne vyplnil vsetky okna");
						new error();
					}
				}
			}});
		
		/**
		 * Navrat do hlavneho menu
		 */
		btnSpat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			    dispose();
			}});
		
		}
}
